package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.BounceFunctions;
import net.minecraft.block.Blocks;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileEntity.class)
public abstract class BounceArrowMixin {

    @Inject(method = "onCollision", at = @At("HEAD"), cancellable = true)
    private void arrowBounceOnSlime(HitResult hitResult, CallbackInfo ci) {
        if (!(hitResult instanceof BlockHitResult blockHit)) return;
        ProjectileEntity arrow = (ProjectileEntity)(Object)this;

        if (!arrow.getWorld().getBlockState(blockHit.getBlockPos()).isOf(Blocks.SLIME_BLOCK)) return;
        BounceFunctions.bounce(arrow, blockHit);
        ci.cancel();
    }
}
