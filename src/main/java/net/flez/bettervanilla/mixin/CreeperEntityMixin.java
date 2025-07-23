package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.block.FleeBlockGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {
    @Inject(method = "initGoals", at = @At("TAIL"))
    private void addFleeBlockGoal(CallbackInfo ci) {
        CreeperEntity creeper = (CreeperEntity) (Object) this;
        GoalSelector goalSelector = ((MobEntityAccessor) creeper).getGoalSelector();
        goalSelector.add(1, new FleeBlockGoal(creeper, 6.0F, 1.0D, 1.2D));
    }
}
