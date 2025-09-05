package net.flez.bettervanilla.entity.custom;

import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlazingArrowEntity extends ArrowEntity {
    public BlazingArrowEntity(EntityType<? extends BlazingArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public BlazingArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
    }

    public BlazingArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return ModItems.BLAZING_ARROW.getDefaultStack();
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (this.isCritical()) entityHitResult.getEntity().setOnFireFor(5);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BLAZING_ARROW);
    }
}
