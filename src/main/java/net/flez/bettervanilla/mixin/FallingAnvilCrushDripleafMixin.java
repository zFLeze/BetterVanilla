package net.flez.bettervanilla.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FallingBlockEntity.class)
public class FallingAnvilCrushDripleafMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void crushDripleafOnFall(CallbackInfo ci) {
        FallingBlockEntity entity = (FallingBlockEntity)(Object)this;
        World world = entity.getWorld();

        if (!world.isClient && entity.getBlockState().isIn(BlockTags.ANVIL)) {
            BlockPos posBelow = entity.getBlockPos().down();
            Block blockBelow = world.getBlockState(posBelow).getBlock();

            if (blockBelow == Blocks.BIG_DRIPLEAF || blockBelow == Blocks.SMALL_DRIPLEAF) {
                world.breakBlock(posBelow, true);
            }
        }
    }
}
