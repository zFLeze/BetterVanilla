package net.flez.bettervanilla.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "postHit")
	private void BoomBlade(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
		String stackName = stack.getName().getString();
		if (!target.getWorld().isClient) {
			if (stackName.equals("BoomBlade") && stack.isIn(ItemTags.SWORDS)) {
				target.getWorld().createExplosion(attacker, target.getX(), target.getY(), target.getZ(), 2.0f, World.ExplosionSourceType.TNT);
			}
		}
	}
}