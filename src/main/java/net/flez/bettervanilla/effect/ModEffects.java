package net.flez.bettervanilla.effect;

import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> RUST = registerStatusEffect("rust",
            new RustEffect(StatusEffectCategory.HARMFUL, 0x6EAF7C)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(BetterVanilla.MOD_ID, "rust"),
                            -0.3D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BetterVanilla.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        BetterVanilla.LOGGER.info("Registering effects for " + BetterVanilla.MOD_ID);
    }
}
