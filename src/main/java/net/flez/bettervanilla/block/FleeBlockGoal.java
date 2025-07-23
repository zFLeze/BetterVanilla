package net.flez.bettervanilla.block;

import net.flez.bettervanilla.block.custom.AmethystLampBlock;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class FleeBlockGoal extends Goal {
    protected final PathAwareEntity mob;
    private final double slowSpeed;
    private final double fastSpeed;
    private final int fleeDistance;
    private final EntityNavigation navigation;
    private Vec3d targetPos;

    public FleeBlockGoal(PathAwareEntity mob, float fleeDistance, double slowSpeed, double fastSpeed) {
        this.mob = mob;
        this.fleeDistance = (int) fleeDistance;
        this.slowSpeed = slowSpeed;
        this.fastSpeed = fastSpeed;
        this.navigation = mob.getNavigation();
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        BlockPos mobPos = mob.getBlockPos();
        BlockPos.Mutable checkPos = new BlockPos.Mutable();

        for (int dx = -fleeDistance; dx <= fleeDistance; dx++) {
            for (int dy = -3; dy <= 3; dy++) {
                for (int dz = -fleeDistance; dz <= fleeDistance; dz++) {
                    checkPos.set(mobPos.getX() + dx, mobPos.getY() + dy, mobPos.getZ() + dz);
                    var state = mob.getWorld().getBlockState(checkPos);
                    if (state.isOf(ModBlocks.AMETHYST_LAMP) && state.get(AmethystLampBlock.LIT)) {
                        Vec3d away = NoPenaltyTargeting.findFrom(mob, 16, 7, Vec3d.ofCenter(checkPos));
                        if (away != null) {
                            this.targetPos = away;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        return !this.navigation.isIdle();
    }

    @Override
    public void start() {
        if (this.targetPos != null) {
            this.navigation.startMovingTo(targetPos.x, targetPos.y, targetPos.z, this.slowSpeed);
        }
    }

    @Override
    public void stop() {
        this.targetPos = null;
    }

    @Override
    public void tick() {
        if (this.targetPos != null) {
            double distSq = mob.squaredDistanceTo(this.targetPos);
            this.navigation.setSpeed(distSq < 49.0 ? this.fastSpeed : this.slowSpeed);
        }
    }
}
