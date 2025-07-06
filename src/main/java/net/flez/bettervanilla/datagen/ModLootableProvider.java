package net.flez.bettervanilla.datagen;

import net.flez.bettervanilla.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootableProvider extends FabricBlockLootTableProvider {
    public ModLootableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FIREPROOF_OAK_PLANKS);
        addDrop(ModBlocks.FIREPROOF_OAK_LOG);
        addDrop(ModBlocks.FIREPROOF_OAK_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_OAK_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD);
        addDrop(ModBlocks.FIREPROOF_OAK_STAIRS);
        addDrop(ModBlocks.FIREPROOF_OAK_SLAB, slabDrops(ModBlocks.FIREPROOF_OAK_SLAB));
        addDrop(ModBlocks.FIREPROOF_OAK_FENCE);
        addDrop(ModBlocks.FIREPROOF_OAK_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_OAK_BUTTON);


        addDrop(ModBlocks.FIREPROOF_SPRUCE_PLANKS);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_LOG);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_STAIRS);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_SLAB, slabDrops(ModBlocks.FIREPROOF_SPRUCE_SLAB));
        addDrop(ModBlocks.FIREPROOF_SPRUCE_FENCE);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_SPRUCE_BUTTON);


        addDrop(ModBlocks.FIREPROOF_DARK_OAK_PLANKS);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_LOG);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_STAIRS);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_SLAB, slabDrops(ModBlocks.FIREPROOF_DARK_OAK_SLAB));
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_FENCE);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_DARK_OAK_BUTTON);


        addDrop(ModBlocks.FIREPROOF_BIRCH_PLANKS);
        addDrop(ModBlocks.FIREPROOF_BIRCH_LOG);
        addDrop(ModBlocks.FIREPROOF_BIRCH_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD);
        addDrop(ModBlocks.FIREPROOF_BIRCH_STAIRS);
        addDrop(ModBlocks.FIREPROOF_BIRCH_SLAB, slabDrops(ModBlocks.FIREPROOF_BIRCH_SLAB));
        addDrop(ModBlocks.FIREPROOF_BIRCH_FENCE);
        addDrop(ModBlocks.FIREPROOF_BIRCH_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_BIRCH_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_BIRCH_BUTTON);

        addDrop(ModBlocks.FIREPROOF_JUNGLE_PLANKS);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_LOG);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_STAIRS);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_SLAB, slabDrops(ModBlocks.FIREPROOF_JUNGLE_SLAB));
        addDrop(ModBlocks.FIREPROOF_JUNGLE_FENCE);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_JUNGLE_BUTTON);


        addDrop(ModBlocks.FIREPROOF_CHERRY_PLANKS);
        addDrop(ModBlocks.FIREPROOF_CHERRY_LOG);
        addDrop(ModBlocks.FIREPROOF_CHERRY_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD);
        addDrop(ModBlocks.FIREPROOF_CHERRY_STAIRS);
        addDrop(ModBlocks.FIREPROOF_CHERRY_SLAB, slabDrops(ModBlocks.FIREPROOF_CHERRY_SLAB));
        addDrop(ModBlocks.FIREPROOF_CHERRY_FENCE);
        addDrop(ModBlocks.FIREPROOF_CHERRY_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_CHERRY_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_CHERRY_BUTTON);


        addDrop(ModBlocks.FIREPROOF_MANGROVE_PLANKS);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_LOG);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_WOOD);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_STAIRS);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_SLAB, slabDrops(ModBlocks.FIREPROOF_MANGROVE_SLAB));
        addDrop(ModBlocks.FIREPROOF_MANGROVE_FENCE);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_MANGROVE_BUTTON);


        addDrop(ModBlocks.FIREPROOF_BAMBOO_PLANKS);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_BLOCK);
        addDrop(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_MOSAIC);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_STAIRS);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_SLAB, slabDrops(ModBlocks.FIREPROOF_BAMBOO_SLAB));
        addDrop(ModBlocks.FIREPROOF_BAMBOO_FENCE);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_PRESSURE_PLATE);
        addDrop(ModBlocks.FIREPROOF_BAMBOO_BUTTON);
    }
}
