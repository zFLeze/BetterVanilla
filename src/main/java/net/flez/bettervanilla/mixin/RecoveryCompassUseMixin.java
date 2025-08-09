package net.flez.bettervanilla.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Item.class)
public class RecoveryCompassUseMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void bettervanilla$teleportToDeathLocation(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.RECOVERY_COMPASS) && !world.isClient) {
            Optional<GlobalPos> deathPos = player.getLastDeathPos();

            if (deathPos.isPresent() && deathPos.get().dimension().equals(world.getRegistryKey())) {
                BlockPos pos = deathPos.get().pos();
                ((ServerPlayerEntity) player).teleport((ServerWorld) world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, player.getYaw(), player.getPitch());
                cir.setReturnValue(TypedActionResult.success(stack));
            }
        }
    }
}

