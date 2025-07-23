package net.flez.bettervanilla.datacomponents;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.mojang.serialization.Codec;
import net.flez.bettervanilla.BetterVanilla;

public class ModDataComponents {
    public static final ComponentType<Integer> OXIDATION_STAGE =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    Identifier.of(BetterVanilla.MOD_ID, "oxidation_stage"),
                    ComponentType.<Integer>builder()
                            .codec(Codec.INT)
                            .build()
            );

    public static void register() {
        BetterVanilla.LOGGER.info("Registering Data Components for " + BetterVanilla.MOD_ID);
    }
}
