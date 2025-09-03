package net.flez.bettervanilla.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.SitEntity;
import net.flez.bettervanilla.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.List;

public class ModEvents {

    // -------------------- SITTING + GRIND + FIRE --------------------
    public static void registerBlockInteractions() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClient) return ActionResult.PASS;

            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = player.getStackInHand(hand);

            // ---------- SITTING ON STAIRS ----------
            if (!player.isBlocking() && state.getBlock() instanceof StairsBlock) {
                if (player.hasVehicle() && player.getVehicle() instanceof SitEntity oldSeat) {
                    oldSeat.kill();
                    player.dismountVehicle();
                }

                List<SitEntity> existing = world.getEntitiesByClass(SitEntity.class, new Box(pos).expand(0.5), e -> true);
                if (existing.isEmpty()) {
                    double yOffset = 0.6;
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + yOffset;
                    double z = pos.getZ() + 0.5;

                    SitEntity sitEntity = new SitEntity(ModEntities.SIT_ENTITY, world);
                    sitEntity.setPosition(x, y, z);
                    sitEntity.setSittingBlockPos(pos);
                    world.spawnEntity(sitEntity);
                    player.startRiding(sitEntity, false);
                    return ActionResult.SUCCESS;
                }
            }

            // ---------- GRIND PROCESS ----------
            boolean grindable = state.isOf(Blocks.GRINDSTONE) && player.isSneaking() &&
                    (stack.isOf(Items.AMETHYST_SHARD) || stack.isOf(Items.EMERALD) || stack.isOf(Items.COAL)
                            || stack.isOf(Items.GOLD_INGOT) || stack.isOf(Items.COPPER_INGOT) || stack.isOf(ModItems.OXIDIZED_COPPER_INGOT));
            if (grindable) {
                if (stack.isOf(Items.AMETHYST_SHARD)) convertItem(world, stack, ModItems.AMETHYST_DUST, player);
                else if (stack.isOf(Items.EMERALD)) convertItem(world, stack, ModItems.EMERALD_DUST, player);
                else if (stack.isOf(Items.COAL)) convertItem(world, stack, ModItems.COAL_DUST, player);
                else if (stack.isOf(Items.GOLD_INGOT)) convertItem(world, stack, ModItems.GOLD_DUST, player);
                else if (stack.isOf(Items.COPPER_INGOT)) convertItem(world, stack, ModItems.COPPER_DUST, player);
                else if (stack.isOf(ModItems.OXIDIZED_COPPER_INGOT)) convertItem(world, stack, ModItems.OXIDIZED_COPPER_DUST, player);

                return ActionResult.SUCCESS;
            }

            // ---------- FIREASPECT IGNITION ----------
            if (hasFireAspect(world, stack)) {
                if (state.getBlock() instanceof CampfireBlock && !state.get(CampfireBlock.LIT)) {
                    world.setBlockState(pos, state.with(CampfireBlock.LIT, true));
                    world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
                if (state.isIn(BlockTags.CANDLES) && !state.get(CandleBlock.LIT)) {
                    world.setBlockState(pos, state.with(CandleBlock.LIT, true));
                    world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
                if (state.getBlock() instanceof TntBlock) {
                    TntBlock.primeTnt(world, pos);
                    world.removeBlock(pos, false);
                    world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }

    // -------------------- RECOVERY COMPASS --------------------
    public static void registerRecoveryCompassUsage() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            EquipmentSlot slot = (hand == Hand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            BetterVanilla.LOGGER.info("CALLED!");
            if (!world.isClient && stack.isOf(Items.RECOVERY_COMPASS) && player.getLastDeathPos().isPresent()) {
                BetterVanilla.LOGGER.info("CALLED!");
                player.getItemCooldownManager().set(stack.getItem(), 100);
                BlockPos deathPos = player.getLastDeathPos().get().pos();

                if (world instanceof ServerWorld serverWorld) {
                    stack.damage(1, player, slot);
                    player.teleport(serverWorld, deathPos.getX(), deathPos.getY(), deathPos.getZ(),
                            EnumSet.noneOf(PositionFlag.class), player.getYaw(), player.getPitch());
                    world.playSound(null, deathPos.getX(), deathPos.getY(), deathPos.getZ(),
                            SoundEvents.ENTITY_PLAYER_TELEPORT, SoundCategory.PLAYERS, 1f, 1f);
                }
                return TypedActionResult.success(stack);
            }

            return TypedActionResult.pass(stack);
        });
    }

    // -------------------- ARMOR DAMAGE PREVENTION --------------------
    public static void registerArmorProtection() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (!damageSource.isOf(DamageTypes.CACTUS) && !damageSource.isOf(DamageTypes.SWEET_BERRY_BUSH)) return true;

            boolean hasBoots = !livingEntity.getEquippedStack(EquipmentSlot.FEET).isEmpty();
            boolean hasChest = !livingEntity.getEquippedStack(EquipmentSlot.CHEST).isEmpty();
            boolean isLeatherBoots = livingEntity.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS);
            boolean isLeatherChest = livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.LEATHER_CHESTPLATE);

            BlockPos pos = livingEntity.getBlockPos();
            Box box = livingEntity.getBoundingBox();
            boolean onTop = box.minY >= pos.getY() + 0.9;
            double relX = livingEntity.getX() - (pos.getX() + 0.5);
            double relZ = livingEntity.getZ() - (pos.getZ() + 0.5);

            if (damageSource.isOf(DamageTypes.SWEET_BERRY_BUSH) && hasBoots && !isLeatherBoots) return false;
            if (onTop && hasBoots && !isLeatherBoots) return false;
            if (!onTop && hasChest && !isLeatherChest) return false;

            return true;
        });
    }

    // -------------------- CAULDRON AFTER BREAK --------------------
    public static void registerCauldronAfterBreak() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (world.isClient) return;
            if (state.isOf(Blocks.WATER_CAULDRON)) world.setBlockState(pos, Blocks.WATER.getDefaultState());
            else if (state.isOf(Blocks.LAVA_CAULDRON)) world.setBlockState(pos, Blocks.LAVA.getDefaultState());
            else if (state.isOf(Blocks.POWDER_SNOW_CAULDRON)) world.setBlockState(pos, Blocks.POWDER_SNOW.getDefaultState());
        });
    }

    // -------------------- HELPERS --------------------
    private static void convertItem(World world, ItemStack stack, Item result, PlayerEntity player) {
        stack.decrement(1);
        player.giveItemStack(new ItemStack(result, 8));
        world.playSound(player, player.getX(), player.getY(), player.getZ(),
                SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);
    }

    private static boolean hasFireAspect(World world, ItemStack stack) {
        RegistryEntry<Enchantment> fireAspect = world.getRegistryManager()
                .get(RegistryKeys.ENCHANTMENT)
                .entryOf(Enchantments.FIRE_ASPECT);
        return EnchantmentHelper.getLevel(fireAspect, stack) > 0;
    }
}
