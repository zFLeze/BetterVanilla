package net.flez.bettervanilla.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.SitEntity;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class ModEvents {
    public static void registerSittableFunction() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (world.isClient()) return ActionResult.PASS;
            if (player.isBlocking() || player.isSneaking()) return ActionResult.PASS;
            if (!(state.getBlock() instanceof StairsBlock)) return ActionResult.PASS;
            
            if (player.hasVehicle() && player.getVehicle() instanceof SitEntity oldSeat) {
                oldSeat.kill();
                player.dismountVehicle();
            }

            List<SitEntity> existing = world.getEntitiesByClass(SitEntity.class, new Box(pos).expand(0.5), e -> true);
            if (!existing.isEmpty()) return ActionResult.PASS;

                double yOffset = 0.6;
                double x = pos.getX() + 0.5;
                double y = pos.getY() + yOffset;
                double z = pos.getZ() + 0.5;

                SitEntity sitEntity = new SitEntity(ModEntities.SIT_ENTITY, world);
                sitEntity.setPosition(x, y, z);
                sitEntity.setSittingBlockPos(pos);
                world.spawnEntity(sitEntity);
                player.startRiding(sitEntity, false);
            return ActionResult.CONSUME;
        });
    }

    public static void registerFireAspectIgnite() {
        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            ItemStack stack = playerEntity.getMainHandStack();
            if (hasFireAspect(world, stack)) {
                BlockPos pos = blockHitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);
                if (state.getBlock() instanceof CampfireBlock && !state.get(CampfireBlock.LIT)) {
                    world.setBlockState(pos, state.with(CampfireBlock.LIT, true));
                    world.playSound(playerEntity, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
                if (state.isIn(BlockTags.CANDLES) && !state.get(CandleBlock.LIT)) {
                    world.setBlockState(pos, state.with(CandleBlock.LIT, true));
                    world.playSound(playerEntity, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
                if (state.getBlock() instanceof TntBlock) {
                    TntBlock.primeTnt(world, pos);
                    world.removeBlock(pos, false);
                    world.playSound(playerEntity, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }

    public static boolean hasFireAspect(World world, ItemStack stack) {
        RegistryEntry<Enchantment> fireAspect = world.getRegistryManager()
                .get(RegistryKeys.ENCHANTMENT)
                .entryOf(Enchantments.FIRE_ASPECT);
        return EnchantmentHelper.getLevel(fireAspect, stack) > 0;
    }
}
