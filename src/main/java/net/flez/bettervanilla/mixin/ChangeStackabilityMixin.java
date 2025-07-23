package net.flez.bettervanilla.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ChangeStackabilityMixin {
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void changeCakeStackSize(CallbackInfoReturnable<Integer> cir) {
        if (((Object) this == Items.CAKE)) {
            cir.setReturnValue(64);
        }
    }
}

