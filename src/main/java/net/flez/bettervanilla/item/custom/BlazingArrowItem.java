package net.flez.bettervanilla.item.custom;

import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.custom.BlazingArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlazingArrowItem extends ArrowItem {
    public BlazingArrowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        BlazingArrowEntity arrow = new BlazingArrowEntity(ModEntities.BLAZING_ARROW_ENTITY, world);
        arrow.setOnFireFor(5);
        return arrow;
    }


    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        return super.createEntity(world, pos, stack, direction);
    }
}
