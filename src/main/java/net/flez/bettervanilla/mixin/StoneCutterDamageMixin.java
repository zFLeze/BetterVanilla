package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.util.ModDamageTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class StoneCutterDamageMixin {
    @Inject(method = "checkBlockCollision", at = @At("HEAD"))
    private void damage(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;

        if (entity instanceof LivingEntity livingEntity) {
        World world = entity.getWorld();
        BlockPos standingPos = entity.getBlockPos();
        BlockState state = world.getBlockState(standingPos);
            DamageSource damageSource = new DamageSource(
                    world.getRegistryManager()
                            .get(RegistryKeys.DAMAGE_TYPE)
                            .entryOf(ModDamageTypes.STONECUTTER));

        if (state.isOf(Blocks.STONECUTTER)) {
            livingEntity.damage(damageSource, 1.5f);
           }
        }
    }
}
