package net.flez.bettervanilla.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowballEntity.class)
public class SnowballDamageMixin {
    @Inject(method = "onEntityHit", at = @At("HEAD"))
    private void damage(EntityHitResult entityHitResult, CallbackInfo ci) {
        SnowballEntity snowball = (SnowballEntity) (Object) this;
        if (!snowball.getWorld().isClient && entityHitResult.getEntity() instanceof LivingEntity && !(entityHitResult.getEntity() instanceof EndCrystalEntity)) {
            entityHitResult.getEntity().damage(snowball.getDamageSources().thrown(snowball.getOwner(), ((LivingEntity) entityHitResult.getEntity()).getAttacker()), 0.5f);
        }
    }
}
