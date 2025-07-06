package net.flez.bettervanilla;

import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.block.entity.ModBlockEntities;
import net.flez.bettervanilla.effect.ModEffects;
import net.flez.bettervanilla.event.ModEvents;
import net.flez.bettervanilla.item.ModItemGroups;
import net.flez.bettervanilla.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Blocks;
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
		ModEvents.registerEvents();
		ModBlockEntities.registerBlockEntities();
		ModEffects.registerEffects();
	}
}