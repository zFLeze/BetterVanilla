package net.flez.bettervanilla.util;

import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> STONECUTTER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(BetterVanilla.MOD_ID, "stonecutter"));

    public void registerDamageTypes() {
        System.out.println("Registering Damage Types for " + BetterVanilla.MOD_ID);
    }
}
