//package net.flez.bettervanilla.mixin;
//
//import net.flez.bettervanilla.item.ModItems;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.damage.DamageSource;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(LivingEntity.class)
//public abstract class ReflectDamageMixin {
//    @Inject(method = "damage", at = @At("HEAD"))
//    private void reflectDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
//        LivingEntity player = (LivingEntity) (Object) this;
//        if (player.isBlocking() && player.getActiveItem().getItem() == ModItems.AMETHYST_SHIELD) {
//            Entity attacker = source.getAttacker();
//            if (attacker instanceof LivingEntity) {
//                attacker.damage(player.getDamageSources().thorns(attacker), amount * 0.25f);
//            }
//        }
//    }
//}
