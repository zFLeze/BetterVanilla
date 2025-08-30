package net.flez.bettervanilla.mixin;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class CauldronBreakMixin {
    @Inject(method = "afterBreak", at = @At("HEAD"))
    private void bettervanilla$onCauldronBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        if (!world.isClient()) {
            if (state.isOf(Blocks.LAVA_CAULDRON)) {
                world.setBlockState(pos, Blocks.LAVA.getDefaultState());
            } else if (state.isOf(Blocks.WATER_CAULDRON) && state.get(LeveledCauldronBlock.LEVEL) == 3) {
                world.setBlockState(pos, Blocks.WATER.getDefaultState());
            } else if (state.isOf(Blocks.POWDER_SNOW_CAULDRON)) {
                world.setBlockState(pos, Blocks.POWDER_SNOW.getDefaultState());
            }
        }
    }
}

