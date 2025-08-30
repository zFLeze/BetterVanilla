package net.flez.bettervanilla.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class CauldronUtil {
    public static double getFluidHeight(BlockState state) {
        return (6.0 + (double) state.get(LeveledCauldronBlock.LEVEL) * 3.0) / 16.0;
    }
    public static boolean isEntityTouchingFluid(BlockState state, BlockPos pos, LivingEntity entity) {
        double fluidHeight = (6.0 + (double) state.get(LeveledCauldronBlock.LEVEL) * 3.0) / 16.0;
        return entity.getY() < pos.getY() + fluidHeight
                && entity.getBoundingBox().maxY > pos.getY() + 0.25;
    }
}
