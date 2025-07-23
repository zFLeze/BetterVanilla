package net.flez.bettervanilla.mixin;

import net.minecraft.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.entity.mob.MobEntity;

@Mixin(MobEntity.class)
public interface MobEntityAccessor {
    @Accessor("goalSelector")
    GoalSelector getGoalSelector();
}
