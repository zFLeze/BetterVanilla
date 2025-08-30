package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.util.CauldronUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.flez.bettervanilla.util.CauldronUtil.getFluidHeight;

@Mixin(LivingEntity.class)
public class WaterCauldronMixin {
    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void bettervanilla$cancelFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (((LivingEntity) (Object) this));
        World world = entity.getWorld();
        BlockPos pos = entity.getBlockPos();
        BlockState state = world.getBlockState(pos);
        if (state.isOf(Blocks.WATER_CAULDRON)) {
            if (CauldronUtil.isEntityTouchingFluid(state, pos, entity) && !(entity instanceof EndermanEntity)) {
                cir.setReturnValue(false);
            }
        }
    }
}
