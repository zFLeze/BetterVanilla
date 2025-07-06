package net.flez.bettervanilla.mixin;

import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EggEntity.class)
public class PracticeMixin {
        @Inject(method = "onCollision", at = @At("HEAD"))
        private void differentEggFunctionsOnHitWhenRenamed(HitResult hitResult, CallbackInfo ci) {

            ThrownItemEntity egg = (ThrownItemEntity)(Object)this;
            String stackName = egg.getStack().getName().getString();

            if (!egg.getWorld().isClient) {
                ServerWorld serverWorld = (ServerWorld) egg.getWorld();

                if (stackName.equals("Boom Buddy")) {
                    egg.getWorld().createExplosion(egg, egg.getX(), egg.getY(), egg.getZ(), 5.0F, World.ExplosionSourceType.TNT);
                } else if (egg.getOwner() instanceof ServerPlayerEntity player && stackName.equals("Blink")) {
                    player.teleport(serverWorld, egg.getX(), egg.getY(), egg.getZ(), player.getYaw(), player.getPitch());
                }
            }
        }
}
