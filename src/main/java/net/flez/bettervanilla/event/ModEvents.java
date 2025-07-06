package net.flez.bettervanilla.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.CustomBlockSitEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import static net.flez.bettervanilla.datagen.ModBlockTagProvider.SITTABLE_LOGS;
import static net.flez.bettervanilla.datagen.ModBlockTagProvider.SITTABLE_STAIRS;

public class ModEvents {
    public static void registerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);

            if (!world.isClient && (state.isIn(SITTABLE_STAIRS) || state.isIn(SITTABLE_LOGS))) {
                double yOffset = state.isIn(SITTABLE_STAIRS) ? 0.57 : 1.07;

                if (!world.getEntitiesByType(ModEntities.SIT_ENTITY, new Box(pos), e -> true).isEmpty()) {
                    return ActionResult.PASS;
                }

                if (player.isSneaking()) return ActionResult.PASS;

                CustomBlockSitEntity seat = new CustomBlockSitEntity(ModEntities.SIT_ENTITY, world);
                seat.setPosition(pos.getX() + 0.5, pos.getY() + yOffset, pos.getZ() + 0.5);
                world.spawnEntity(seat);
                player.startRiding(seat);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}
