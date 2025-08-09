package net.flez.bettervanilla.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class BounceFunctions {
    public static void bounce(Entity projectile, BlockHitResult hitResult) {
        Vec3d velocity = projectile.getVelocity();
        Direction direction = hitResult.getSide();

            Vec3d bounce = switch (direction.getAxis()) {
                case X -> new Vec3d(-velocity.x, velocity.y, velocity.z);
                case Y -> new Vec3d(velocity.x, -velocity.y * 0.7, velocity.z);
                case Z -> new Vec3d(velocity.x, velocity.y, -velocity.z);
            };

            Vec3d pushOut = Vec3d.of(direction.getVector()).multiply(0.01);
            Vec3d collisionPos = hitResult.getPos().add(pushOut);

            projectile.setPos(collisionPos.x, collisionPos.y, collisionPos.z);
            projectile.setVelocity(bounce);
            projectile.setOnGround(false);

    }
}
