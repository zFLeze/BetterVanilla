package net.flez.bettervanilla.mixin;

import net.minecraft.component.DataComponentTypes;
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
public class SetDurabilityMixin {
    @Inject(method = "use", at = @At("HEAD"))
    private void bettervanilla$damageCompass(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
       ItemStack stack = user.getStackInHand(hand);
       if (stack.getItem() == Items.RECOVERY_COMPASS) {
           stack.set(DataComponentTypes.MAX_DAMAGE, 15);
       }
    }
}
