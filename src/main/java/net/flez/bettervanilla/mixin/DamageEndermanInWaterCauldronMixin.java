package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.util.CauldronUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class DamageEndermanInWaterCauldronMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void bettervanilla$damageEnderman(CallbackInfo ci) {
        LivingEntity entity = (((LivingEntity) (Object) this));
        World world = entity.getWorld();
        BlockPos pos = entity.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (state.isOf(Blocks.WATER_CAULDRON) && CauldronUtil.isEntityTouchingFluid(state, pos, entity) && entity instanceof EndermanEntity enderman) {
            enderman.damage(enderman.getDamageSources().drown(), 1.0f);
        }
    }
}
