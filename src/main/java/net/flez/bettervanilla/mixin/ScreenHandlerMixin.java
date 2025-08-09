package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.datagen.ModBlockTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenHandler.class)
public abstract class ScreenHandlerMixin {
    @Inject(method = "canUse(Lnet/minecraft/screen/ScreenHandlerContext;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/Block;)Z", at = @At("HEAD"), cancellable = true)
    private static void canInteract(ScreenHandlerContext context, PlayerEntity player, Block block, CallbackInfoReturnable<Boolean> cir) {
        boolean result = context.get((world, pos) -> {
            BlockState state = world.getBlockState(pos);
            if (state.isIn(ModBlockTagProvider.CRAFTING_TABLES)) return player.canInteractWithBlockAt(pos, 4);
            return state.getBlock() == block && player.canInteractWithBlockAt(pos, 4.0);
        }, true);
        cir.setReturnValue(result);
    }
}

