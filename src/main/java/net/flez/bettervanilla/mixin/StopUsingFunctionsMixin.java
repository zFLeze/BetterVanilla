package net.flez.bettervanilla.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class StopUsingFunctionsMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void bettervanilla$cancelUsage(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (context.getPlayer() != null) {
            PlayerEntity player = context.getPlayer();
            BlockPos pos = context.getBlockPos();
            BlockState state = player.getWorld().getBlockState(pos);
            if (state.getBlock() instanceof StairsBlock && !player.isSneaking()) {
                cir.setReturnValue(ActionResult.FAIL);
            }
        }
    }
}
