package net.flez.bettervanilla.datagen;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    //  Craft Fireproof Planks from Logs/Woods
    private void offerCraftPlanksRecipe(RecipeExporter exporter, Item logOrWood, Item planks, String name) {
        String logOrWoodName = Registries.ITEM.getId(logOrWood.asItem()).getPath();
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .input(logOrWood)
                .criterion("has_fireproof_log", conditionsFromItem(logOrWood))
                .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, name + "_from_" + logOrWoodName));
    }
    //  Craft Fireproof Wood
    private void offerFireproofLogRecipe(RecipeExporter exporter, Item inputLogOrWood, Item resultFireproofLog, String name) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, resultFireproofLog, 1)
                .input(inputLogOrWood)
                .input(Items.HONEYCOMB)
                .criterion("has_log", conditionsFromItem(inputLogOrWood))
                .criterion("has_honeycomb", conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, name));
    }

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //  CUSTOM  CRAFTING  RECIPE
        //  COPPER SWORD
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "copper_sword"));

        //  COPPER AXE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_AXE)
                .pattern(" CC")
                .pattern(" SC")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "copper_axe"));

        //  COPPER PICKAXE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "copper_pickaxe"));

        // COPPER SHOVEL
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "copper_shovel"));

        //  COPPER HOE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "copper_hoe"));


        //  Oxidized Copper Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.OXIDIZED_COPPER)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.OXIDIZED_COPPER_INGOT)
                .criterion(hasItem(ModItems.OXIDIZED_COPPER_INGOT), conditionsFromItem(ModItems.OXIDIZED_COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "oxidized_copper_block_from_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OXIDIZED_COPPER_INGOT, 9)
                .input(Blocks.OXIDIZED_COPPER)
                .criterion(hasItem(Blocks.OXIDIZED_COPPER), conditionsFromItem(Blocks.OXIDIZED_COPPER))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "oxidized_copper_ingots_from_block"));

        //  Nametag Recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NAME_TAG, 1)
                .input(Items.PAPER)
                .input(Items.STRING)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(recipeExporter, Identifier.of("vanillaplus", "name_tag"));

        //  Saddles Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SADDLE, 1)
                        .pattern("LLL")
                        .pattern("LIL")
                        .pattern("S S")
                        .input('L', Items.LEATHER)
                        .input('I', Items.IRON_INGOT)
                        .input('S', Items.STRING)
                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                        .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "saddle"));

        //  Fireproof Logs, Planks And Wood Blocks
        //  PLANKS
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_PLANKS, 1)
                .input(Items.OAK_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_PLANKS, 1)
                .input(Items.SPRUCE_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_PLANKS), conditionsFromItem(Items.SPRUCE_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_PLANKS, 1)
                .input(Items.BIRCH_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_PLANKS), conditionsFromItem(Items.BIRCH_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_PLANKS, 1)
                .input(Items.JUNGLE_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_PLANKS), conditionsFromItem(Items.JUNGLE_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_PLANKS, 1)
                .input(Items.ACACIA_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_PLANKS), conditionsFromItem(Items.ACACIA_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_PLANKS, 1)
                .input(Items.DARK_OAK_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_PLANKS, 1)
                .input(Items.MANGROVE_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_PLANKS), conditionsFromItem(Items.MANGROVE_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_CHERRY_PLANKS, 1)
                .input(Items.CHERRY_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.CHERRY_PLANKS), conditionsFromItem(Items.CHERRY_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_cherry_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_PLANKS, 1)
                .input(Items.BAMBOO_PLANKS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_PLANKS), conditionsFromItem(Items.BAMBOO_PLANKS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_planks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_MOSAIC, 1)
                .input(Items.BAMBOO_MOSAIC)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_MOSAIC), conditionsFromItem(Items.BAMBOO_MOSAIC))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_mosaic"));

        //  NON BLOCK BLOCKS
        //  OAK
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_STAIRS, 1)
                .input(Items.OAK_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_STAIRS), conditionsFromItem(Items.OAK_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_SLAB, 1)
                .input(Items.OAK_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_SLAB), conditionsFromItem(Items.OAK_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_FENCE, 1)
                .input(Items.OAK_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_FENCE), conditionsFromItem(Items.OAK_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_FENCE_GATE, 1)
                .input(Items.OAK_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_FENCE_GATE), conditionsFromItem(Items.OAK_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_PRESSURE_PLATE, 1)
                .input(Items.OAK_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_PRESSURE_PLATE), conditionsFromItem(Items.OAK_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_OAK_BUTTON, 1)
                .input(Items.OAK_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_BUTTON), conditionsFromItem(Items.OAK_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_oak_button"));

        //  SPRUCE
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_STAIRS, 1)
                .input(Items.SPRUCE_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_STAIRS), conditionsFromItem(Items.SPRUCE_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_SLAB, 1)
                .input(Items.SPRUCE_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_SLAB), conditionsFromItem(Items.SPRUCE_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_FENCE, 1)
                .input(Items.SPRUCE_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_FENCE), conditionsFromItem(Items.SPRUCE_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE, 1)
                .input(Items.SPRUCE_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_FENCE_GATE), conditionsFromItem(Items.SPRUCE_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_PRESSURE_PLATE, 1)
                .input(Items.SPRUCE_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_PRESSURE_PLATE), conditionsFromItem(Items.SPRUCE_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_SPRUCE_BUTTON, 1)
                .input(Items.SPRUCE_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.SPRUCE_BUTTON), conditionsFromItem(Items.SPRUCE_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_spruce_button"));

        //  DARK OAK
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_STAIRS, 1)
                .input(Items.DARK_OAK_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.OAK_STAIRS), conditionsFromItem(Items.DARK_OAK_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_SLAB, 1)
                .input(Items.DARK_OAK_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_SLAB), conditionsFromItem(Items.DARK_OAK_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_FENCE, 1)
                .input(Items.DARK_OAK_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_FENCE), conditionsFromItem(Items.DARK_OAK_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE, 1)
                .input(Items.DARK_OAK_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_FENCE_GATE), conditionsFromItem(Items.DARK_OAK_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_PRESSURE_PLATE, 1)
                .input(Items.DARK_OAK_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_PRESSURE_PLATE), conditionsFromItem(Items.DARK_OAK_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_DARK_OAK_BUTTON, 1)
                .input(Items.DARK_OAK_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.DARK_OAK_BUTTON), conditionsFromItem(Items.DARK_OAK_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_dark_oak_button"));

        //  JUNGLE
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_STAIRS, 1)
                .input(Items.JUNGLE_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_STAIRS), conditionsFromItem(Items.JUNGLE_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_SLAB, 1)
                .input(Items.JUNGLE_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_SLAB), conditionsFromItem(Items.JUNGLE_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_FENCE, 1)
                .input(Items.JUNGLE_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_FENCE), conditionsFromItem(Items.JUNGLE_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE, 1)
                .input(Items.JUNGLE_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_FENCE_GATE), conditionsFromItem(Items.JUNGLE_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_PRESSURE_PLATE, 1)
                .input(Items.JUNGLE_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_PRESSURE_PLATE), conditionsFromItem(Items.JUNGLE_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_JUNGLE_BUTTON, 1)
                .input(Items.JUNGLE_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.JUNGLE_BUTTON), conditionsFromItem(Items.JUNGLE_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_jungle_button"));

        //  ACACIA
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_STAIRS, 1)
                .input(Items.ACACIA_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_STAIRS), conditionsFromItem(Items.ACACIA_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_SLAB, 1)
                .input(Items.ACACIA_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_SLAB), conditionsFromItem(Items.ACACIA_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_FENCE, 1)
                .input(Items.ACACIA_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_FENCE), conditionsFromItem(Items.ACACIA_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_FENCE_GATE, 1)
                .input(Items.ACACIA_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_FENCE_GATE), conditionsFromItem(Items.ACACIA_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_PRESSURE_PLATE, 1)
                .input(Items.ACACIA_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_PRESSURE_PLATE), conditionsFromItem(Items.ACACIA_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_ACACIA_BUTTON, 1)
                .input(Items.ACACIA_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.ACACIA_BUTTON), conditionsFromItem(Items.ACACIA_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_acacia_button"));

        //  BIRCH
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_STAIRS, 1)
                .input(Items.BIRCH_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_STAIRS), conditionsFromItem(Items.BIRCH_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_SLAB, 1)
                .input(Items.BIRCH_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_SLAB), conditionsFromItem(Items.BIRCH_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_FENCE, 1)
                .input(Items.BIRCH_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_FENCE), conditionsFromItem(Items.BIRCH_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_FENCE_GATE, 1)
                .input(Items.BIRCH_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_FENCE_GATE), conditionsFromItem(Items.BIRCH_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_PRESSURE_PLATE, 1)
                .input(Items.BIRCH_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_PRESSURE_PLATE), conditionsFromItem(Items.BIRCH_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BIRCH_BUTTON, 1)
                .input(Items.BIRCH_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BIRCH_BUTTON), conditionsFromItem(Items.BIRCH_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_birch_button"));

        //  MANGROVE
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_STAIRS, 1)
                .input(Items.MANGROVE_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_STAIRS), conditionsFromItem(Items.MANGROVE_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_SLAB, 1)
                .input(Items.MANGROVE_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_SLAB), conditionsFromItem(Items.MANGROVE_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_FENCE, 1)
                .input(Items.MANGROVE_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_FENCE), conditionsFromItem(Items.MANGROVE_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE, 1)
                .input(Items.MANGROVE_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_FENCE_GATE), conditionsFromItem(Items.MANGROVE_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_PRESSURE_PLATE, 1)
                .input(Items.MANGROVE_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_PRESSURE_PLATE), conditionsFromItem(Items.MANGROVE_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_MANGROVE_BUTTON, 1)
                .input(Items.MANGROVE_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.MANGROVE_BUTTON), conditionsFromItem(Items.MANGROVE_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_mangrove_button"));

        //  BAMBOO
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_STAIRS, 1)
                .input(Items.BAMBOO_STAIRS)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_STAIRS), conditionsFromItem(Items.BAMBOO_STAIRS))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_SLAB, 1)
                .input(Items.BAMBOO_SLAB)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_SLAB), conditionsFromItem(Items.BAMBOO_SLAB))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_FENCE, 1)
                .input(Items.BAMBOO_FENCE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_FENCE), conditionsFromItem(Items.BAMBOO_FENCE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_fence"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE, 1)
                .input(Items.BAMBOO_FENCE_GATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_FENCE_GATE), conditionsFromItem(Items.BAMBOO_FENCE_GATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_fence_gate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_PRESSURE_PLATE, 1)
                .input(Items.BAMBOO_PRESSURE_PLATE)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_PRESSURE_PLATE), conditionsFromItem(Items.BAMBOO_PRESSURE_PLATE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_pressure_plate"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_BUTTON, 1)
                .input(Items.BAMBOO_BUTTON)
                .input(Items.HONEYCOMB)
                .criterion(hasItem(Items.BAMBOO_BUTTON), conditionsFromItem(Items.BAMBOO_BUTTON))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_button"));



        //  LOGS & WOOD Blocks
        //  Logs & Woods
        //  Oak
        offerFireproofLogRecipe(recipeExporter,
                Items.OAK_LOG,
                ModBlocks.FIREPROOF_OAK_LOG.asItem(),
                "fireproof_oak_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.OAK_WOOD,
                ModBlocks.FIREPROOF_OAK_WOOD.asItem(),
                "fireproof_oak_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_OAK_LOG,
                ModBlocks.FIREPROOF_STRIPPED_OAK_LOG.asItem(),
                "fireproof_stripped_oak_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_OAK_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD.asItem(),
                "fireproof_stripped_oak_wood");




        //  Spruce
        offerFireproofLogRecipe(recipeExporter,
                Items.SPRUCE_LOG,
                ModBlocks.FIREPROOF_SPRUCE_LOG.asItem(),
                "fireproof_spruce_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.SPRUCE_WOOD,
                ModBlocks.FIREPROOF_SPRUCE_WOOD.asItem(),
                "fireproof_spruce_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_SPRUCE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG.asItem(),
                "fireproof_stripped_spruce_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_SPRUCE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD.asItem(),
                "fireproof_stripped_spruce_wood");



        //  DARK OAK
        offerFireproofLogRecipe(recipeExporter,
                Items.DARK_OAK_LOG,
                ModBlocks.FIREPROOF_DARK_OAK_LOG.asItem(),
                "fireproof_dark_oak_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.DARK_OAK_WOOD,
                ModBlocks.FIREPROOF_DARK_OAK_WOOD.asItem(),
                "fireproof_dark_oak_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_DARK_OAK_LOG,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG.asItem(),
                "fireproof_stripped_dark_oak_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_DARK_OAK_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD.asItem(),
                "fireproof_stripped_dark_oak_wood");



        //  JUNGLE
        offerFireproofLogRecipe(recipeExporter,
                Items.JUNGLE_LOG,
                ModBlocks.FIREPROOF_JUNGLE_LOG.asItem(),
                "fireproof_jungle_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.JUNGLE_WOOD,
                ModBlocks.FIREPROOF_JUNGLE_WOOD.asItem(),
                "fireproof_jungle_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_JUNGLE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG.asItem(),
                "fireproof_stripped_jungle_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_JUNGLE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD.asItem(),
                "fireproof_stripped_jungle_wood");



        //  ACACIA
        offerFireproofLogRecipe(recipeExporter,
                Items.ACACIA_LOG,
                ModBlocks.FIREPROOF_ACACIA_LOG.asItem(),
                "fireproof_acacia_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.ACACIA_WOOD,
                ModBlocks.FIREPROOF_ACACIA_WOOD.asItem(),
                "fireproof_acacia_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_ACACIA_LOG,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG.asItem(),
                "fireproof_stripped_acacia_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_ACACIA_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD.asItem(),
                "fireproof_stripped_acacia_wood");



        //  MANGROVE
        offerFireproofLogRecipe(recipeExporter,
                Items.MANGROVE_LOG,
                ModBlocks.FIREPROOF_MANGROVE_LOG.asItem(),
                "fireproof_mangrove_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.MANGROVE_WOOD,
                ModBlocks.FIREPROOF_MANGROVE_WOOD.asItem(),
                "fireproof_mangrove_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_MANGROVE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG.asItem(),
                "fireproof_stripped_mangrove_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_MANGROVE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD.asItem(),
                "fireproof_stripped_mangrove_wood");



        //  CHERRY
        offerFireproofLogRecipe(recipeExporter,
                Items.CHERRY_LOG,
                ModBlocks.FIREPROOF_CHERRY_LOG.asItem(),
                "fireproof_cherry_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.CHERRY_WOOD,
                ModBlocks.FIREPROOF_CHERRY_WOOD.asItem(),
                "fireproof_cherry_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_CHERRY_LOG,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG.asItem(),
                "fireproof_stripped_cherry_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_CHERRY_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD.asItem(),
                "fireproof_stripped_cherry_wood");

        // Birch
        offerFireproofLogRecipe(recipeExporter,
                Items.BIRCH_LOG,
                ModBlocks.FIREPROOF_BIRCH_LOG.asItem(),
                "fireproof_birch_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.BIRCH_WOOD,
                ModBlocks.FIREPROOF_BIRCH_WOOD.asItem(),
                "fireproof_birch_wood");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_BIRCH_LOG,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG.asItem(),
                "fireproof_stripped_birch_log");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_BIRCH_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD.asItem(),
                "fireproof_stripped_birch_wood");

        // Bamboo
        offerFireproofLogRecipe(recipeExporter,
                Items.BAMBOO_BLOCK,
                ModBlocks.FIREPROOF_BAMBOO_BLOCK.asItem(),
                "fireproof_bamboo_block");

        offerFireproofLogRecipe(recipeExporter,
                Items.STRIPPED_BAMBOO_BLOCK,
                ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK.asItem(),
                "fireproof_stripped_bamboo_block");

        //  Log/Wood ---> 4 Planks
        //  OAK

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_OAK_LOG.asItem(),
                ModBlocks.FIREPROOF_OAK_PLANKS.asItem(),
                "fireproof_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_OAK_WOOD.asItem(),
                ModBlocks.FIREPROOF_OAK_PLANKS.asItem(),
                "fireproof_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_OAK_LOG.asItem(),
                ModBlocks.FIREPROOF_OAK_PLANKS.asItem(),
                "fireproof_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD.asItem(),
                ModBlocks.FIREPROOF_OAK_PLANKS.asItem(),
                "fireproof_oak_planks");



        //  SPRUCE
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_SPRUCE_LOG.asItem(),
                ModBlocks.FIREPROOF_SPRUCE_PLANKS.asItem(),
                "fireproof_spruce_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_SPRUCE_WOOD.asItem(),
                ModBlocks.FIREPROOF_SPRUCE_PLANKS.asItem(),
                "fireproof_spruce_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG.asItem(),
                ModBlocks.FIREPROOF_SPRUCE_PLANKS.asItem(),
                "fireproof_spruce_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD.asItem(),
                ModBlocks.FIREPROOF_SPRUCE_PLANKS.asItem(),
                "fireproof_spruce_planks");



        //  DARK OAK
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_DARK_OAK_LOG.asItem(),
                ModBlocks.FIREPROOF_DARK_OAK_PLANKS.asItem(),
                "fireproof_dark_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_DARK_OAK_WOOD.asItem(),
                ModBlocks.FIREPROOF_DARK_OAK_PLANKS.asItem(),
                "fireproof_dark_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG.asItem(),
                ModBlocks.FIREPROOF_DARK_OAK_PLANKS.asItem(),
                "fireproof_dark_oak_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD.asItem(),
                ModBlocks.FIREPROOF_DARK_OAK_PLANKS.asItem(),
                "fireproof_dark_oak_planks");



        //  JUNGLE
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_JUNGLE_LOG.asItem(),
                ModBlocks.FIREPROOF_JUNGLE_PLANKS.asItem(),
                "fireproof_jungle_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_JUNGLE_WOOD.asItem(),
                ModBlocks.FIREPROOF_JUNGLE_PLANKS.asItem(),
                "fireproof_jungle_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG.asItem(),
                ModBlocks.FIREPROOF_JUNGLE_PLANKS.asItem(),
                "fireproof_jungle_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD.asItem(),
                ModBlocks.FIREPROOF_JUNGLE_PLANKS.asItem(),
                "fireproof_jungle_planks");



        //  BIRCH
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_BIRCH_LOG.asItem(),
                ModBlocks.FIREPROOF_BIRCH_PLANKS.asItem(),
                "fireproof_birch_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_BIRCH_WOOD.asItem(),
                ModBlocks.FIREPROOF_SPRUCE_PLANKS.asItem(),
                "fireproof_birch_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG.asItem(),
                ModBlocks.FIREPROOF_BIRCH_PLANKS.asItem(),
                "fireproof_birch_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD.asItem(),
                ModBlocks.FIREPROOF_BIRCH_PLANKS.asItem(),
                "fireproof_birch_planks");



        //  CHERRY
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_CHERRY_LOG.asItem(),
                ModBlocks.FIREPROOF_CHERRY_PLANKS.asItem(),
                "fireproof_cherry_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_CHERRY_WOOD.asItem(),
                ModBlocks.FIREPROOF_CHERRY_PLANKS.asItem(),
                "fireproof_cherry_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG.asItem(),
                ModBlocks.FIREPROOF_CHERRY_PLANKS.asItem(),
                "fireproof_cherry_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD.asItem(),
                ModBlocks.FIREPROOF_CHERRY_PLANKS.asItem(),
                "fireproof_cherry_planks");



        // ACACIA
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_ACACIA_LOG.asItem(),
                ModBlocks.FIREPROOF_ACACIA_PLANKS.asItem(),
                "fireproof_acacia_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_ACACIA_WOOD.asItem(),
                ModBlocks.FIREPROOF_ACACIA_PLANKS.asItem(),
                "fireproof_acacia_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG.asItem(),
                ModBlocks.FIREPROOF_ACACIA_PLANKS.asItem(),
                "fireproof_acacia_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD.asItem(),
                ModBlocks.FIREPROOF_ACACIA_PLANKS.asItem(),
                "fireproof_acacia_planks");



        //  MANGROVE
        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_MANGROVE_LOG.asItem(),
                ModBlocks.FIREPROOF_MANGROVE_PLANKS.asItem(),
                "fireproof_mangrove_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_MANGROVE_WOOD.asItem(),
                ModBlocks.FIREPROOF_MANGROVE_PLANKS.asItem(),
                "fireproof_mangrove_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG.asItem(),
                ModBlocks.FIREPROOF_MANGROVE_PLANKS.asItem(),
                "fireproof_mangrove_planks");

        offerCraftPlanksRecipe(recipeExporter,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD.asItem(),
                ModBlocks.FIREPROOF_MANGROVE_PLANKS.asItem(),
                "fireproof_mangrove_planks");


        //  BAMBOO
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_PLANKS.asItem(), 2)
                .input(ModBlocks.FIREPROOF_BAMBOO_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.FIREPROOF_BAMBOO_BLOCK.asItem()), conditionsFromItem(ModBlocks.FIREPROOF_BAMBOO_BLOCK.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_planks_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIREPROOF_BAMBOO_PLANKS.asItem(), 2)
                .input(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK.asItem()), conditionsFromItem(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "fireproof_bamboo_planks_from_stripped_block"));

    }
}
