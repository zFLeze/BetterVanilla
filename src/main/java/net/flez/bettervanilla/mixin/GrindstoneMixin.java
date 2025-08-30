package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class GrindstoneMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (!context.getWorld().isClient() && context.getPlayer() != null) {
            ItemStack stack = context.getPlayer().getMainHandStack();
            Item item = stack.getItem();
            int result = 4;
            BlockPos pos = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(pos);

            if (state.isOf(Blocks.GRINDSTONE) && context.getPlayer().isSneaking()) {
                if (item == Items.AMETHYST_SHARD) {
                    stack.decrement(1);
                    context.getPlayer().giveItemStack(new ItemStack(ModItems.AMETHYST_DUST, result));
                    context.getWorld().playSound(context.getPlayer(), pos.getX(), pos.getY(), pos.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS);
                } else if (item == Items.EMERALD) {
                    context.getPlayer().setStackInHand(context.getHand(), new ItemStack(ModItems.EMERALD_DUST, result));
                }
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}
