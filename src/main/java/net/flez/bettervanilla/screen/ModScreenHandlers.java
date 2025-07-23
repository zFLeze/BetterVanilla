package net.flez.bettervanilla.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static void registerScreenHandlers() {
        BetterVanilla.LOGGER.info("Registering Screen Handlers for " + BetterVanilla.MOD_ID);
    }
}
