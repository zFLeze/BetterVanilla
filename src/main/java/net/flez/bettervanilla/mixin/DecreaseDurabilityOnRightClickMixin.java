package net.flez.bettervanilla.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class DecreaseDurabilityOnRightClickMixin {
    @Inject(method = "use", at = @At("HEAD"))
    private void bettervanilla$onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.getItem() == Items.RECOVERY_COMPASS) {
            stack.damage(1, user, EquipmentSlot.MAINHAND);

            if (stack.getDamage() == stack.getMaxDamage() && !(stack.getMaxDamage() == 0)) {
                stack.decrement(1);
            }
        }
    }
}
