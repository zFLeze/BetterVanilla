package net.flez.bettervanilla.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class CampfireEntityDropMixin {
    @Inject(method = "drop", at = @At("HEAD"), cancellable = true)
    private void bettervanilla$changeDrop(ServerWorld world, DamageSource damageSource, CallbackInfo ci) {
        LivingEntity livingEntity = (((LivingEntity) (Object) this));
        BlockPos pos = livingEntity.getBlockPos();
        BlockState state = world.getBlockState(pos);
        if (state.isIn(BlockTags.CAMPFIRES)) {
            ci.cancel();
            if (livingEntity instanceof CowEntity cow) {
            cow.dropStack(new ItemStack(Items.COOKED_BEEF));
        } else if (livingEntity instanceof PigEntity pig) {
            pig.dropStack(new ItemStack(Items.COOKED_PORKCHOP));
        } else if (livingEntity instanceof ChickenEntity chicken) {
            chicken.dropStack(new ItemStack(Items.COOKED_CHICKEN));
        } else if (livingEntity instanceof SheepEntity sheep) {
            sheep.dropStack(new ItemStack(Items.COOKED_MUTTON));
        } else if (livingEntity instanceof RabbitEntity rabbit) {
            rabbit.dropStack(new ItemStack(Items.COOKED_RABBIT));
        } else if (livingEntity instanceof CodEntity cod) {
            cod.dropStack(new ItemStack(Items.COOKED_COD));
        } else if (livingEntity instanceof SalmonEntity salmon) {
            salmon.dropStack(new ItemStack(Items.COOKED_SALMON));
        }
        }
    }
}
