package net.flez.bettervanilla.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SitEntity extends Entity {

    private BlockPos sittingBlockPos;

    public SitEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true;
    }

    public void setSittingBlockPos(BlockPos pos) {
        this.sittingBlockPos = pos;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (!this.getWorld().isClient && passenger instanceof PlayerEntity player) {
            Vec3d pos = Dismounting.findRespawnPos(player.getType(), this.getWorld(), this.getBlockPos(), true);
            if (pos != null) {
                player.requestTeleport(pos.x, pos.y, pos.z);
            } else {
                player.requestTeleport(this.getX(), this.getY() + 1, this.getZ());
            }
        }
        this.kill();
    }


    @Override
    public void tick() {
        super.tick();

        if (this.getPassengerList().isEmpty()) {
            this.kill();
            return;
        }

        if (sittingBlockPos != null) {
            BlockState state = this.getWorld().getBlockState(sittingBlockPos);
            if (state.isAir()) {
                this.getPassengerList().forEach(Entity::dismountVehicle);
                this.kill();
            }
        }
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    public boolean shouldSave() {
        return false;
    }
}
