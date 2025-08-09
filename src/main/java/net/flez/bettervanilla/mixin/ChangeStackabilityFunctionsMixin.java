package net.flez.bettervanilla.mixin;

import net.flez.bettervanilla.util.ChangeStackabilityAccess;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.*;

@Mixin(Item.class)
public class ChangeStackabilityFunctionsMixin implements ChangeStackabilityAccess {
    @Mutable @Final @Shadow private ComponentMap components;

    @Override
    public void bettervanilla$applyChangingStackability(int newSize) {
        this.components = ComponentMap.builder()
                .addAll(this.components)
                .add(DataComponentTypes.MAX_STACK_SIZE, newSize)
                .build();
    }
}
