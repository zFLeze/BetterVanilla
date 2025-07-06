package net.flez.bettervanilla.datagen;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flez.bettervanilla.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> SITTABLE_STAIRS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(BetterVanilla.MOD_ID, "sittable_stairs"));
    public static final TagKey<Block> SITTABLE_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(BetterVanilla.MOD_ID, "sittable_logs"));

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(SITTABLE_STAIRS)
                .add(ModBlocks.FIREPROOF_OAK_STAIRS)
                .add(ModBlocks.FIREPROOF_SPRUCE_STAIRS)
                .add(ModBlocks.FIREPROOF_DARK_OAK_STAIRS)
                .add(ModBlocks.FIREPROOF_ACACIA_STAIRS)
                .add(ModBlocks.FIREPROOF_JUNGLE_STAIRS)
                .add(ModBlocks.FIREPROOF_MANGROVE_STAIRS)
                .add(ModBlocks.FIREPROOF_CHERRY_STAIRS)
                .add(ModBlocks.FIREPROOF_BIRCH_STAIRS)
                .add(ModBlocks.FIREPROOF_BAMBOO_STAIRS)

                .add(Blocks.OAK_STAIRS)
                .add(Blocks.SPRUCE_STAIRS)
                .add(Blocks.DARK_OAK_STAIRS)
                .add(Blocks.ACACIA_STAIRS)
                .add(Blocks.JUNGLE_STAIRS)
                .add(Blocks.MANGROVE_STAIRS)
                .add(Blocks.CHERRY_STAIRS)
                .add(Blocks.BIRCH_STAIRS)
                .add(Blocks.BAMBOO_STAIRS);


                getOrCreateTagBuilder(SITTABLE_LOGS)
                .add(Blocks.OAK_LOG)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.STRIPPED_CHERRY_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.STRIPPED_BIRCH_LOG)

                .add(ModBlocks.FIREPROOF_OAK_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_OAK_LOG)
                .add(ModBlocks.FIREPROOF_SPRUCE_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG)
                .add(ModBlocks.FIREPROOF_DARK_OAK_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG)
                .add(ModBlocks.FIREPROOF_ACACIA_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG)
                .add(ModBlocks.FIREPROOF_JUNGLE_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG)
                .add(ModBlocks.FIREPROOF_CHERRY_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG)
                .add(ModBlocks.FIREPROOF_BIRCH_LOG)
                .add(ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG);


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

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .forceAddTag(BlockTags.INCORRECT_FOR_STONE_TOOL);

    }
}
