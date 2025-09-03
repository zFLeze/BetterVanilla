package net.flez.bettervanilla;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.block.entity.ModBlockEntities;
import net.flez.bettervanilla.datacomponents.ModDataComponents;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.event.ModEvents;
import net.flez.bettervanilla.item.ModItemGroups;
import net.flez.bettervanilla.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.flez.bettervanilla.screen.ModScreenHandlers;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
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
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.RECOVERY_COMPASS, builder -> builder.add(DataComponentTypes.MAX_DAMAGE, 5)));
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_OAK_LOG, ModBlocks.FIREPROOF_STRIPPED_OAK_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_OAK_WOOD, ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_SPRUCE_LOG, ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_SPRUCE_WOOD, ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_DARK_OAK_LOG, ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_DARK_OAK_WOOD, ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_JUNGLE_LOG, ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_JUNGLE_WOOD, ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_ACACIA_LOG, ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_ACACIA_WOOD, ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_MANGROVE_LOG, ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_MANGROVE_WOOD, ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_BAMBOO_BLOCK, ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_BIRCH_LOG, ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG);
        StrippableBlockRegistry.register(ModBlocks.FIREPROOF_BIRCH_WOOD, ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD);
        StrippableBlockRegistry.register(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroup();
        ModEvents.registerBlockInteractions();
        ModEvents.registerArmorProtection();
        ModEvents.registerCauldronAfterBreak();
        ModEvents.registerRecoveryCompassUsage();
        ModBlockEntities.registerBlockEntities();
        ModBlockEntities.registerTrappedChestEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModBlockEntities.registerBlockEntities();
        ModDataComponents.register();
        ModEntities.registerModEntites();
    }
}