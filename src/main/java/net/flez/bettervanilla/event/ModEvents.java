package net.flez.bettervanilla.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.SitEntity;
import net.flez.bettervanilla.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
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

            if (state.getBlock() instanceof StairsBlock && player.isSneaking() && player.getMainHandStack().isOf(Items.WATER_BUCKET)) {
                return ActionResult.PASS;
            }

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
        });
    }

    public static void registerGrindFunction() {
        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            BlockPos clickedPos = playerEntity.getBlockPos();
            BlockState clickedState = world.getBlockState(clickedPos);
            ItemStack stack = playerEntity.getMainHandStack();
            boolean grindable = clickedState.isOf(Blocks.GRINDSTONE) && playerEntity.isSneaking() && !(playerEntity.getMainHandStack().isOf(Items.DIAMOND) || playerEntity.getMainHandStack().isOf(Items.NETHERITE_INGOT));
            if (grindable) {
                if (stack.isOf(Items.AMETHYST_SHARD)) {
                    convertItemHelper(world, stack, ModItems.AMETHYST_DUST, playerEntity);
                } else if (stack.isOf(Items.EMERALD)) {
                    convertItemHelper(world, stack, ModItems.EMERALD_DUST, playerEntity);
                } else if (stack.isOf(Items.COAL)) {
                    convertItemHelper(world, stack, ModItems.COAL_DUST, playerEntity);
                } else if (stack.isOf(Items.GOLD_INGOT)) {
                    convertItemHelper(world, stack, ModItems.GOLD_DUST, playerEntity);
                } else if (stack.isOf(Items.COPPER_INGOT)) {
                    convertItemHelper(world, stack, ModItems.COPPER_DUST, playerEntity);
                } else if (stack.isOf(ModItems.OXIDIZED_COPPER_INGOT)) {
                    convertItemHelper(world, stack, ModItems.OXIDIZED_COPPER_DUST, playerEntity);
                }
            }
            return ActionResult.SUCCESS;
        });
    }

    public static void registerCauldronAfterBreak() {
        PlayerBlockBreakEvents.AFTER.register((world, playerEntity, blockPos, blockState, blockEntity) -> {
            if (!world.isClient()) {
                if (blockState.isOf(Blocks.WATER_CAULDRON)) {
                    world.setBlockState(blockPos, Blocks.WATER.getDefaultState());
                } else if (blockState.isOf(Blocks.LAVA_CAULDRON)) {
                    world.setBlockState(blockPos, Blocks.LAVA.getDefaultState());
                } else if (blockState.isOf(Blocks.POWDER_SNOW_CAULDRON)) {
                    world.setBlockState(blockPos, Blocks.POWDER_SNOW.getDefaultState());
                }
            }
        });
    }

    public static void registerTakeNoDamageWithArmor() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (!(livingEntity.getEquippedStack(EquipmentSlot.FEET).isEmpty() || livingEntity.getEquippedStack(EquipmentSlot.CHEST).isEmpty())) return false;
            if (damageSource.getSource() != null && (damageSource != damageSource.getSource().getDamageSources().cactus() || damageSource != damageSource.getSource().getDamageSources().sweetBerryBush()))
                return true;
            BlockPos pos = livingEntity.getBlockPos();
            Box box = livingEntity.getBoundingBox();
            boolean onTop = box.minY >= pos.getY() + 0.9;

            double relX = livingEntity.getX() - (pos.getX() + 0.5);
            double relZ = livingEntity.getZ() - (pos.getZ() + 0.5);
            boolean touchingSide = Math.abs(relX) >= 0.4 || Math.abs(relZ) >= 0.4;

            boolean hasBoots = !livingEntity.getEquippedStack(EquipmentSlot.FEET).isEmpty();
            boolean hasChestPlate = !livingEntity.getEquippedStack(EquipmentSlot.CHEST).isEmpty();
            boolean isLeatherBoots = livingEntity.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS);
            boolean isLeatherChestPlate = livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.LEATHER_CHESTPLATE);

            if (damageSource == damageSource.getSource().getDamageSources().sweetBerryBush() && hasBoots && !isLeatherBoots) {
                return false;
            }

            if (onTop && hasBoots && !isLeatherBoots) {
                return false;
            }
            return !touchingSide || !hasChestPlate || isLeatherChestPlate;
        });
    }

    public static void registerRecoveryCompassUsage() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            EquipmentSlot slot = (hand == Hand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            if (!world.isClient() && stack.isOf(Items.RECOVERY_COMPASS) && player.getLastDeathPos().isPresent()) {
                stack.set(DataComponentTypes.MAX_DAMAGE, 15);
                player.getItemCooldownManager().set(stack.getItem(), 100);
                BlockPos deathPos = player.getLastDeathPos().get().pos();

                if (world instanceof ServerWorld serverWorld) {
                    stack.damage(1, player, slot);
                    player.teleport(serverWorld, deathPos.getX(), deathPos.getY(), deathPos.getZ(), EnumSet.noneOf(PositionFlag.class), player.getYaw(), player.getPitch());
                    world.playSound(null, deathPos.getX(), deathPos.getY(), deathPos.getZ(),
                            SoundEvents.ENTITY_PLAYER_TELEPORT, SoundCategory.PLAYERS, 1f, 1f);
                }
                return TypedActionResult.success(stack);
            }

            return TypedActionResult.pass(stack);
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

    private static void convertItemHelper(World world, ItemStack stack, Item convertedItem, PlayerEntity playerEntity) {
        stack.decrement(1);
        playerEntity.giveItemStack(new ItemStack(convertedItem, 8));
        world.playSound(playerEntity, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);
    }

    public static boolean hasFireAspect(World world, ItemStack stack) {
        RegistryEntry<Enchantment> fireAspect = world.getRegistryManager()
                .get(RegistryKeys.ENCHANTMENT)
                .entryOf(Enchantments.FIRE_ASPECT);
        return EnchantmentHelper.getLevel(fireAspect, stack) > 0;
    }
}
