package net.flez.bettervanilla.datagen;

import net.flez.bettervanilla.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.FIREPROOF_OAK_PLANKS)
                .add(ModBlocks.FIREPROOF_OAK_LOG)
                .add(ModBlocks.FIREPROOF_OAK_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_OAK_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD)
                .add(ModBlocks.FIREPROOF_OAK_STAIRS)
                .add(ModBlocks.FIREPROOF_OAK_SLAB)
                .add(ModBlocks.FIREPROOF_OAK_FENCE)
                .add(ModBlocks.FIREPROOF_OAK_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_OAK_DOOR)
                .add(ModBlocks.FIREPROOF_OAK_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_OAK_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_OAK_BUTTON)

                .add(ModBlocks.FIREPROOF_SPRUCE_PLANKS)
                .add(ModBlocks.FIREPROOF_SPRUCE_LOG)
                .add(ModBlocks.FIREPROOF_SPRUCE_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD)
                .add(ModBlocks.FIREPROOF_SPRUCE_STAIRS)
                .add(ModBlocks.FIREPROOF_SPRUCE_SLAB)
                .add(ModBlocks.FIREPROOF_SPRUCE_FENCE)
                .add(ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_SPRUCE_DOOR)
                .add(ModBlocks.FIREPROOF_SPRUCE_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_SPRUCE_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_SPRUCE_BUTTON)

                .add(ModBlocks.FIREPROOF_DARK_OAK_PLANKS)
                .add(ModBlocks.FIREPROOF_DARK_OAK_LOG)
                .add(ModBlocks.FIREPROOF_DARK_OAK_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD)
                .add(ModBlocks.FIREPROOF_DARK_OAK_STAIRS)
                .add(ModBlocks.FIREPROOF_DARK_OAK_SLAB)
                .add(ModBlocks.FIREPROOF_DARK_OAK_FENCE)
                .add(ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_DARK_OAK_DOOR)
                .add(ModBlocks.FIREPROOF_DARK_OAK_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_DARK_OAK_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_DARK_OAK_BUTTON)

                .add(ModBlocks.FIREPROOF_JUNGLE_PLANKS)
                .add(ModBlocks.FIREPROOF_JUNGLE_LOG)
                .add(ModBlocks.FIREPROOF_JUNGLE_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD)
                .add(ModBlocks.FIREPROOF_JUNGLE_STAIRS)
                .add(ModBlocks.FIREPROOF_JUNGLE_SLAB)
                .add(ModBlocks.FIREPROOF_JUNGLE_FENCE)
                .add(ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_JUNGLE_DOOR)
                .add(ModBlocks.FIREPROOF_JUNGLE_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_JUNGLE_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_JUNGLE_BUTTON)

                .add(ModBlocks.FIREPROOF_CHERRY_PLANKS)
                .add(ModBlocks.FIREPROOF_CHERRY_LOG)
                .add(ModBlocks.FIREPROOF_CHERRY_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD)
                .add(ModBlocks.FIREPROOF_CHERRY_STAIRS)
                .add(ModBlocks.FIREPROOF_CHERRY_SLAB)
                .add(ModBlocks.FIREPROOF_CHERRY_FENCE)
                .add(ModBlocks.FIREPROOF_CHERRY_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_CHERRY_DOOR)
                .add(ModBlocks.FIREPROOF_CHERRY_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_CHERRY_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_CHERRY_BUTTON)

                .add(ModBlocks.FIREPROOF_BAMBOO_PLANKS)
                .add(ModBlocks.FIREPROOF_BAMBOO_BLOCK)
                .add(ModBlocks.FIREPROOF_BAMBOO_MOSAIC)
                .add(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK)
                .add(ModBlocks.FIREPROOF_BAMBOO_STAIRS)
                .add(ModBlocks.FIREPROOF_BAMBOO_SLAB)
                .add(ModBlocks.FIREPROOF_BAMBOO_FENCE)
                .add(ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_BAMBOO_DOOR)
                .add(ModBlocks.FIREPROOF_BAMBOO_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_BAMBOO_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_BAMBOO_BUTTON)

                .add(ModBlocks.FIREPROOF_MANGROVE_PLANKS)
                .add(ModBlocks.FIREPROOF_MANGROVE_LOG)
                .add(ModBlocks.FIREPROOF_MANGROVE_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD)
                .add(ModBlocks.FIREPROOF_MANGROVE_STAIRS)
                .add(ModBlocks.FIREPROOF_MANGROVE_SLAB)
                .add(ModBlocks.FIREPROOF_MANGROVE_FENCE)
                .add(ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_MANGROVE_DOOR)
                .add(ModBlocks.FIREPROOF_MANGROVE_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_MANGROVE_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_MANGROVE_BUTTON)

                .add(ModBlocks.FIREPROOF_ACACIA_PLANKS)
                .add(ModBlocks.FIREPROOF_ACACIA_LOG)
                .add(ModBlocks.FIREPROOF_ACACIA_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD)
                .add(ModBlocks.FIREPROOF_ACACIA_STAIRS)
                .add(ModBlocks.FIREPROOF_ACACIA_SLAB)
                .add(ModBlocks.FIREPROOF_ACACIA_FENCE)
                .add(ModBlocks.FIREPROOF_ACACIA_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_ACACIA_DOOR)
                .add(ModBlocks.FIREPROOF_ACACIA_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_ACACIA_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_ACACIA_BUTTON)

                .add(ModBlocks.FIREPROOF_BIRCH_PLANKS)
                .add(ModBlocks.FIREPROOF_BIRCH_LOG)
                .add(ModBlocks.FIREPROOF_BIRCH_WOOD)
                .add(ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD)
                .add(ModBlocks.FIREPROOF_BIRCH_STAIRS)
                .add(ModBlocks.FIREPROOF_BIRCH_SLAB)
                .add(ModBlocks.FIREPROOF_BIRCH_FENCE)
                .add(ModBlocks.FIREPROOF_BIRCH_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_BIRCH_DOOR)
                .add(ModBlocks.FIREPROOF_BIRCH_TRAPDOOR)
                .add(ModBlocks.FIREPROOF_BIRCH_PRESSURE_PLATE)
                .add(ModBlocks.FIREPROOF_BIRCH_BUTTON);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.FIREPROOF_OAK_FENCE)
                .add(ModBlocks.FIREPROOF_SPRUCE_FENCE)
                .add(ModBlocks.FIREPROOF_DARK_OAK_FENCE)
                .add(ModBlocks.FIREPROOF_JUNGLE_FENCE)
                .add(ModBlocks.FIREPROOF_ACACIA_FENCE)
                .add(ModBlocks.FIREPROOF_BIRCH_FENCE)
                .add(ModBlocks.FIREPROOF_MANGROVE_FENCE)
                .add(ModBlocks.FIREPROOF_CHERRY_FENCE)
                .add(ModBlocks.FIREPROOF_BAMBOO_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.FIREPROOF_OAK_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_ACACIA_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_CHERRY_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE)
                .add(ModBlocks.FIREPROOF_BIRCH_FENCE_GATE);

    }
}
