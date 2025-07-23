package net.flez.bettervanilla.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CactusBlock.class)
public class CactusBlockMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void damage(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (!(entity instanceof PlayerEntity player)) return;

        Box box = player.getBoundingBox();
        boolean onTop = box.minY >= pos.getY() + 0.9;

        double relX = player.getX() - (pos.getX() + 0.5);
        double relZ = player.getZ() - (pos.getZ() + 0.5);
        boolean touchingSide = Math.abs(relX) >= 0.4 || Math.abs(relZ) >= 0.4;

        boolean hasBoots = !player.getEquippedStack(EquipmentSlot.FEET).isEmpty();
        boolean hasChestPlate = !player.getEquippedStack(EquipmentSlot.CHEST).isEmpty();
        boolean isLeatherBoots = player.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS);
        boolean isLeatherChestPlate = player.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.LEATHER_CHESTPLATE);

        if (onTop && !isLeatherBoots) {
            if (hasBoots) ci.cancel();
        } else if (touchingSide && hasChestPlate && !isLeatherChestPlate) {
            ci.cancel();
        }
    }

}
