package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.util.BounceFunctions;
import net.minecraft.block.Blocks;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class BounceSpectralArrowMixin {
    @Inject(method = "onBlockHit", at = @At("HEAD"), cancellable = true)
    private void spectralArrowbounceOnSlime(BlockHitResult hit, CallbackInfo ci) {
        PersistentProjectileEntity specArrow = (PersistentProjectileEntity)(Object)this;

        if (!specArrow.getWorld().getBlockState(hit.getBlockPos()).isOf(Blocks.SLIME_BLOCK)) return;
        BounceFunctions.bounce(specArrow, hit);
        ci.cancel();
    }
}
