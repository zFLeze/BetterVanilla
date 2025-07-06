package net.flez.bettervanilla.mixin;

import net.minecraft.entity.projectile.AbstractWindChargeEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractWindChargeEntity.class)
public abstract class BounceWindChargeMixin {
    @Inject(method = "onCollision", at = @At("HEAD"), cancellable = true)
    private void deflectOnSlime(HitResult hit, CallbackInfo ci) {
        if (!(hit instanceof BlockHitResult blockHit)) return;
        AbstractWindChargeEntity thrownEntity = (AbstractWindChargeEntity)(Object) this;

        if (!thrownEntity.getWorld().getBlockState(blockHit.getBlockPos()).isOf(Blocks.SLIME_BLOCK)) return;

        Vec3d hitPos = blockHit.getPos();
        Direction normal = blockHit.getSide();
        Vec3d adjust = Vec3d.of(normal.getVector()).multiply(0.01); // tiny push back
        thrownEntity.setPos(
                hitPos.x + adjust.x,
                hitPos.y + adjust.y,
                hitPos.z + adjust.z
        );

        Vec3d velocity = thrownEntity.getVelocity();
        Vec3d bounced = switch (normal.getAxis()) {
            case X -> new Vec3d(-velocity.x * 0.8, velocity.y * 0.8, velocity.z * 0.8);
            case Y -> new Vec3d(velocity.x * 0.8, -velocity.y * 0.8, velocity.z * 0.8);
            case Z -> new Vec3d(velocity.x * 0.8, velocity.y * 0.8, -velocity.z * 0.8);
        };

        thrownEntity.setVelocity(bounced);
        ci.cancel();
    }
}
