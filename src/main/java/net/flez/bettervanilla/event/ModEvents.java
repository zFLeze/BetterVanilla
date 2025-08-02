package net.flez.bettervanilla.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.CustomBlockSitEntity;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import static net.flez.bettervanilla.datagen.ModBlockTagProvider.SITTABLE_LOGS;
import static net.flez.bettervanilla.datagen.ModBlockTagProvider.SITTABLE_STAIRS;

public class ModEvents {
    public static void registerSitableFunction() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            BlockPos above1 = pos.up();
            BlockPos above2 = pos.up(2);
            BlockState stateAbove1 = world.getBlockState(above1);
            BlockState stateAbove2 = world.getBlockState(above2);
            BlockPos playerDown = player.getBlockPos().down();
            BlockState below = player.getWorld().getBlockState(playerDown);

            if (!world.isClient && player.getMainHandStack().getItem() instanceof Item && !(player.getMainHandStack().getItem() instanceof BlockItem) && (state.isIn(SITTABLE_STAIRS) || state.isIn(SITTABLE_LOGS))) {

                double yOffset = state.isIn(SITTABLE_STAIRS) ? 0.57 : 1.07;
                if (!stateAbove1.isAir() || (stateAbove1.isOpaqueFullCube(world, above1) && stateAbove2.isAir()) || stateAbove2.isOpaqueFullCube(world, above2))
                    return ActionResult.PASS;

                if (!world.getEntitiesByType(ModEntities.SIT_ENTITY, new Box(pos), e -> true).isEmpty()) {
                    return ActionResult.PASS;
                }

                if (player.isSneaking())
                    return ActionResult.PASS;

                CustomBlockSitEntity seat = new CustomBlockSitEntity(ModEntities.SIT_ENTITY, world);
                seat.setPosition(pos.getX() + 0.5, pos.getY() + yOffset, pos.getZ() + 0.5);
                world.spawnEntity(seat);
                player.startRiding(seat);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
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
