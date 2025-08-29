package net.flez.bettervanilla;

import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.block.entity.ModBlockEntities;
import net.flez.bettervanilla.datacomponents.ModDataComponents;
import net.flez.bettervanilla.event.ModEvents;
import net.flez.bettervanilla.item.ModItemGroups;
import net.flez.bettervanilla.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.flez.bettervanilla.util.ChangeStackabilityAccess;
import net.flez.bettervanilla.screen.ModScreenHandlers;
import net.flez.bettervanilla.util.GrindFunctions;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterVanilla implements ModInitializer {
	public static final String MOD_ID = "bettervanilla";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
		registry.add(Blocks.HAY_BLOCK, 10, 30);

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroup();
		ModEvents.registerSitableFunction();
		ModEvents.registerFireAspectIgnite();
		ModBlockEntities.registerBlockEntities();
		ModBlockEntities.registerTrappedChestEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerBlockEntities();
		ModDataComponents.register();
		GrindFunctions.registerGrindFunctions();
        ((ChangeStackabilityAccess) Items.CAKE).bettervanilla$applyChangingStackability(64);
        ((ChangeStackabilityAccess) Items.POTION).bettervanilla$applyChangingStackability(16);
        ((ChangeStackabilityAccess) Items.SPLASH_POTION).bettervanilla$applyChangingStackability(16);
        ((ChangeStackabilityAccess) Items.LINGERING_POTION).bettervanilla$applyChangingStackability(16);
	}
}