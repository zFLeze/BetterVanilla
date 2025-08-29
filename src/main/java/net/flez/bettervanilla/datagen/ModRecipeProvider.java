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
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
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

        // Resolve items by naming convention: bettervanilla:fireproof_<wood>_<part>
        private static ItemConvertible ic(String path) {
            return Registries.ITEM.get(Identifier.of(BetterVanilla.MOD_ID, path));
        }

        // Generate for a single wood family (e.g., "oak", "spruce", ...)
        public static void generateFireproofWoodSet(RecipeExporter exporter, String wood) {
            final String base = "fireproof_" + wood;

            // core ingredients
            ItemConvertible LOG             = ic(base + "_log");
            ItemConvertible WOOD            = ic(base + "_wood");
            ItemConvertible STRIPPED_LOG    = ic("stripped_" + base + "_log");
            ItemConvertible STRIPPED_WOOD   = ic("stripped_" + base + "_wood");
            ItemConvertible PLANKS          = ic(base + "_planks");

            // blocks/items
            ItemConvertible STAIRS          = ic(base + "_stairs");
            ItemConvertible SLAB            = ic(base + "_slab");
            ItemConvertible FENCE           = ic(base + "_fence");
            ItemConvertible FENCE_GATE      = ic(base + "_fence_gate");
            ItemConvertible BUTTON          = ic(base + "_button");
            ItemConvertible PRESSURE_PLATE  = ic(base + "_pressure_plate");

             ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PLANKS, 4)
                    .input(LOG)
                    .criterion(hasItem(LOG), conditionsFromItem(LOG))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_planks_from_log"));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PLANKS, 4)
                    .input(WOOD)
                    .criterion(hasItem(WOOD), conditionsFromItem(WOOD))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_planks_from_wood"));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PLANKS, 4)
                    .input(STRIPPED_LOG)
                    .criterion(hasItem(STRIPPED_LOG), conditionsFromItem(STRIPPED_LOG))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_planks_from_stripped_log"));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PLANKS, 4)
                    .input(STRIPPED_WOOD)
                    .criterion(hasItem(STRIPPED_WOOD), conditionsFromItem(STRIPPED_WOOD))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_planks_from_stripped_wood"));

            // --- STAIRS ---
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STAIRS, 4)
                    .pattern("P  ")
                    .pattern("PP ")
                    .pattern("PPP")
                    .input('P', PLANKS)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_stairs"));

            // --- SLAB ---
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SLAB, 6)
                    .pattern("PPP")
                    .input('P', PLANKS)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_slab"));

            // --- FENCE ---
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, FENCE, 3)
                    .pattern("P#P")
                    .pattern("P#P")
                    .input('P', PLANKS)
                    .input('#', Items.STICK)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_fence"));

            // --- FENCE GATE ---
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, FENCE_GATE)
                    .pattern("#P#")
                    .pattern("#P#")
                    .input('P', PLANKS)
                    .input('#', Items.STICK)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_fence_gate"));

            // --- BUTTON ---
            ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BUTTON)
                    .input(PLANKS)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_button"));

            // --- PRESSURE PLATE ---
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, PRESSURE_PLATE)
                    .pattern("PP")
                    .input('P', PLANKS)
                    .criterion(hasItem(PLANKS), conditionsFromItem(PLANKS))
                    .offerTo(exporter, Identifier.of(BetterVanilla.MOD_ID, "normal_" + wood + "_pressure_plate"));
        }

        // Call this once from your RecipeProvider#generate
        public static void generateAllFireproofWoodSets(RecipeExporter exporter) {
            String[] woods = { "oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry"};
            for (String w : woods) {
                generateFireproofWoodSet(exporter, w);
            }
        }


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        generateAllFireproofWoodSets(recipeExporter);
        //  CUSTOM  CRAFTING  RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_AXE)
                .pattern("CC ")
                .pattern("SC ")
                .pattern("S  ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                .pattern("C C")
                .pattern("C C")
                .pattern("   ")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "copper_boots"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.OXIDIZED_COPPER)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.OXIDIZED_COPPER_INGOT)
                .criterion(hasItem(ModItems.OXIDIZED_COPPER_INGOT), conditionsFromItem(ModItems.OXIDIZED_COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "oxidized_copper_block_from_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OXIDIZED_COPPER_INGOT, 9)
                .input(Blocks.OXIDIZED_COPPER)
                .criterion(hasItem(Blocks.OXIDIZED_COPPER), conditionsFromItem(Blocks.OXIDIZED_COPPER))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "oxidized_copper_ingots_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NAME_TAG, 1)
                .input(Items.PAPER)
                .input(Items.STRING)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "name_tag"));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.IRON_HORSE_ARMOR)
                .pattern("  I")
                .pattern("III")
                .pattern("I I")
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "iron_horse_armor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GOLDEN_HORSE_ARMOR)
                .pattern("  G")
                .pattern("GGG")
                .pattern("G G")
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "gold_horse_armor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND_HORSE_ARMOR)
                .pattern("  D")
                .pattern("DDD")
                .pattern("D D")
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "diamond_horse_armor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_LAMP.asItem())
                        .pattern(" A ")
                        .pattern("ARA")
                        .pattern(" A ")
                        .input('A', Items.AMETHYST_SHARD)
                        .input('R', Blocks.REDSTONE_LAMP)
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .criterion(hasItem(Items.REDSTONE_LAMP), conditionsFromItem(Blocks.REDSTONE_LAMP))
                        .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "amethyst_lamp"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_DOOR)
                        .pattern(" AA")
                        .pattern(" AA")
                        .pattern(" AA")
                .input('A', ModBlocks.AMETHYST_BRICKS)
                .criterion(hasItem(ModBlocks.AMETHYST_BRICKS.asItem()), conditionsFromItem(ModBlocks.AMETHYST_BRICKS.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "amethyst_door"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TRAPDOOR)
                        .pattern("AA ")
                        .pattern("AA ")
                        .pattern("   ")
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "amethyst_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_SLAB, 6)
                        .pattern("AAA")
                        .pattern("   ")
                        .pattern("   ")
                .input('A', ModBlocks.AMETHYST_BRICKS)
                .criterion(hasItem(ModBlocks.AMETHYST_BRICKS.asItem()), conditionsFromItem(ModBlocks.AMETHYST_BRICKS.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "crafted_amethyst_slab"));

        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_WALL, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, Blocks.AMETHYST_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_SLAB, ModBlocks.AMETHYST_BRICKS, 2);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_AMETHYST_BLOCK, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_STAIRS, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_PILLAR, ModBlocks.AMETHYST_BRICKS);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TRAPDOOR, ModBlocks.AMETHYST_BRICKS, 4);
        offerSmelting(recipeExporter, List.of((ModBlocks.AMETHYST_BRICKS.asItem())), RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CRACKED_AMETHYST_BRICKS.asItem(), 0.5f, 200, "cracked_amethyst_bricks");


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD)
                .input(Blocks.AMETHYST_BLOCK)
                .criterion(hasItem(Blocks.AMETHYST_BLOCK.asItem()), conditionsFromItem(Blocks.AMETHYST_BLOCK.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "amethyst_shard"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.SPRUCE_PLANKS)
                .criterion(hasItem(Blocks.SPRUCE_PLANKS), conditionsFromItem(Blocks.SPRUCE_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "spruce_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.DARK_OAK_PLANKS)
                .criterion(hasItem(Blocks.DARK_OAK_PLANKS), conditionsFromItem(Blocks.DARK_OAK_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "dark_oak_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.ACACIA_PLANKS)
                .criterion(hasItem(Blocks.ACACIA_PLANKS), conditionsFromItem(Blocks.ACACIA_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "acacia_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.JUNGLE_PLANKS)
                .criterion(hasItem(Blocks.JUNGLE_PLANKS), conditionsFromItem(Blocks.JUNGLE_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "jungle_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.MANGROVE_PLANKS)
                .criterion(hasItem(Blocks.MANGROVE_PLANKS), conditionsFromItem(Blocks.MANGROVE_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "mangrove_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.CHERRY_PLANKS)
                .criterion(hasItem(Blocks.CHERRY_PLANKS), conditionsFromItem(Blocks.CHERRY_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "cherry_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.BAMBOO_PLANKS)
                .criterion(hasItem(Blocks.BAMBOO_PLANKS), conditionsFromItem(Blocks.BAMBOO_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "bamboo_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.BIRCH_PLANKS)
                .criterion(hasItem(Blocks.BIRCH_PLANKS), conditionsFromItem(Blocks.BIRCH_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "birch_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.CRIMSON_PLANKS)
                .criterion(hasItem(Blocks.CRIMSON_PLANKS), conditionsFromItem(Blocks.CRIMSON_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "crimson_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_CRAFTING_TABLE)
                .pattern("PP ")
                .pattern("PP ")
                .input('P', Blocks.WARPED_PLANKS)
                .criterion(hasItem(Blocks.WARPED_PLANKS), conditionsFromItem(Blocks.WARPED_PLANKS))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "warped_crafting_table"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .pattern("SSS")
                .pattern(" I ")
                .pattern(" I ")
                .input('S', Items.STONE)
                .input('I', Items.STICK)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "stone_pickaxe"));



//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.OAK_PLANKS)
//                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "oak_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.SPRUCE_PLANKS)
//                .criterion(hasItem(Items.SPRUCE_PLANKS), conditionsFromItem(Items.SPRUCE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "spruce_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.DARK_OAK_PLANKS)
//                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "dark_oak_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.JUNGLE_PLANKS)
//                .criterion(hasItem(Items.JUNGLE_PLANKS), conditionsFromItem(Items.JUNGLE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "jungle_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.ACACIA_PLANKS)
//                .criterion(hasItem(Items.ACACIA_PLANKS), conditionsFromItem(Items.ACACIA_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "acacia_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.MANGROVE_PLANKS)
//                .criterion(hasItem(Items.MANGROVE_PLANKS), conditionsFromItem(Items.MANGROVE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "mangrove_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.CHERRY_PLANKS)
//                .criterion(hasItem(Items.CHERRY_PLANKS), conditionsFromItem(Items.CHERRY_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "cherry_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.BAMBOO_PLANKS)
//                .criterion(hasItem(Items.BAMBOO_PLANKS), conditionsFromItem(Items.BAMBOO_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "bamboo_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.BIRCH_PLANKS)
//                .criterion(hasItem(Items.BIRCH_PLANKS), conditionsFromItem(Items.BIRCH_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "birch_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.STONE)
//                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "stone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.COBBLESTONE)
//                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "cobblestone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_COBBLESTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.MOSSY_COBBLESTONE)
//                .criterion(hasItem(Items.MOSSY_COBBLESTONE), conditionsFromItem(Items.MOSSY_COBBLESTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "mossy_cobblestone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.STONE_BRICK_STAIRS)
//                .criterion(hasItem(Items.STONE_BRICKS), conditionsFromItem(Items.STONE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "stone_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSSY_STONE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.MOSSY_STONE_BRICKS)
//                .criterion(hasItem(Items.MOSSY_STONE_BRICKS), conditionsFromItem(Items.MOSSY_STONE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "mossy_stone_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.ANDESITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.ANDESITE)
//                .criterion(hasItem(Items.ANDESITE), conditionsFromItem(Items.ANDESITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "andesite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_ANDESITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_ANDESITE)
//                .criterion(hasItem(Items.POLISHED_ANDESITE), conditionsFromItem(Items.POLISHED_ANDESITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_andesite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.DIORITE)
//                .criterion(hasItem(Items.DIORITE), conditionsFromItem(Items.DIORITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "diorite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DIORITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_DIORITE)
//                .criterion(hasItem(Items.POLISHED_DIORITE), conditionsFromItem(Items.POLISHED_DIORITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_diorite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.GRANITE)
//                .criterion(hasItem(Items.GRANITE), conditionsFromItem(Items.GRANITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "granite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_GRANITE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_GRANITE)
//                .criterion(hasItem(Items.POLISHED_GRANITE), conditionsFromItem(Items.POLISHED_GRANITE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_granite_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.SANDSTONE)
//                .criterion(hasItem(Items.SANDSTONE), conditionsFromItem(Items.SANDSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "sandstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_SANDSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.SMOOTH_SANDSTONE)
//                .criterion(hasItem(Items.SMOOTH_SANDSTONE), conditionsFromItem(Items.SMOOTH_SANDSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "smooth_sandstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.RED_SANDSTONE)
//                .criterion(hasItem(Items.RED_SANDSTONE), conditionsFromItem(Items.RED_SANDSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "red_sandstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_RED_SANDSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.SMOOTH_RED_SANDSTONE)
//                .criterion(hasItem(Items.SMOOTH_RED_SANDSTONE), conditionsFromItem(Items.SMOOTH_RED_SANDSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "smooth_red_sandstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.QUARTZ_BLOCK)
//                .criterion(hasItem(Items.QUARTZ_BLOCK), conditionsFromItem(Items.QUARTZ_BLOCK))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "quartz_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_QUARTZ_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.SMOOTH_QUARTZ)
//                .criterion(hasItem(Items.SMOOTH_QUARTZ), conditionsFromItem(Items.SMOOTH_QUARTZ))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "smooth_quartz_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.BRICKS)
//                .criterion(hasItem(Items.BRICKS), conditionsFromItem(Items.BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "bricks_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.MUD_BRICKS)
//                .criterion(hasItem(Items.MUD_BRICKS), conditionsFromItem(Items.MUD_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "mud_bricks_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.TUFF_BRICKS)
//                .criterion(hasItem(Items.TUFF_BRICKS), conditionsFromItem(Items.TUFF_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "tuff_bricks_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_TUFF_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_TUFF)
//                .criterion(hasItem(Items.POLISHED_TUFF), conditionsFromItem(Items.POLISHED_TUFF))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_tuff_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.NETHER_BRICKS)
//                .criterion(hasItem(Items.NETHER_BRICKS), conditionsFromItem(Items.NETHER_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "nether_bricks_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_NETHER_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.RED_NETHER_BRICKS)
//                .criterion(hasItem(Items.RED_NETHER_BRICKS), conditionsFromItem(Items.RED_NETHER_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "red_nether_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.BLACKSTONE)
//                .criterion(hasItem(Items.BLACKSTONE), conditionsFromItem(Items.BLACKSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "blackstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_BLACKSTONE)
//                .criterion(hasItem(Items.POLISHED_BLACKSTONE), conditionsFromItem(Items.POLISHED_BLACKSTONE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_blackstone_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_BLACKSTONE_BRICKS)
//                .criterion(hasItem(Items.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Items.POLISHED_BLACKSTONE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_blackstone_bricks_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.COBBLED_DEEPSLATE)
//                .criterion(hasItem(Items.COBBLED_DEEPSLATE), conditionsFromItem(Items.COBBLED_DEEPSLATE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "cobbled_deepslate_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.DEEPSLATE_BRICKS)
//                .criterion(hasItem(Items.DEEPSLATE_BRICKS), conditionsFromItem(Items.DEEPSLATE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "deepslate_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_DEEPSLATE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.POLISHED_DEEPSLATE)
//                .criterion(hasItem(Items.POLISHED_DEEPSLATE), conditionsFromItem(Items.POLISHED_DEEPSLATE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "polished_deepslate_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_TILE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.DEEPSLATE_TILES)
//                .criterion(hasItem(Items.DEEPSLATE_TILES), conditionsFromItem(Items.DEEPSLATE_TILES))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "deepslate_tile_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.CUT_COPPER)
//                .criterion(hasItem(Items.CUT_COPPER), conditionsFromItem(Items.CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.EXPOSED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.EXPOSED_CUT_COPPER)
//                .criterion(hasItem(Items.EXPOSED_CUT_COPPER), conditionsFromItem(Items.EXPOSED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "exposed_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WEATHERED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.WEATHERED_CUT_COPPER)
//                .criterion(hasItem(Items.WEATHERED_CUT_COPPER), conditionsFromItem(Items.WEATHERED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "weathered_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.OXIDIZED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.OXIDIZED_CUT_COPPER)
//                .criterion(hasItem(Items.OXIDIZED_CUT_COPPER), conditionsFromItem(Items.OXIDIZED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "oxidized_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.WAXED_CUT_COPPER)
//                .criterion(hasItem(Items.WAXED_CUT_COPPER), conditionsFromItem(Items.WAXED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "waxed_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.WAXED_EXPOSED_CUT_COPPER)
//                .criterion(hasItem(Items.WAXED_EXPOSED_CUT_COPPER), conditionsFromItem(Items.WAXED_EXPOSED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "waxed_exposed_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.WAXED_WEATHERED_CUT_COPPER)
//                .criterion(hasItem(Items.WAXED_WEATHERED_CUT_COPPER), conditionsFromItem(Items.WAXED_WEATHERED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "waxed_weathered_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.WAXED_OXIDIZED_CUT_COPPER)
//                .criterion(hasItem(Items.WAXED_OXIDIZED_CUT_COPPER), conditionsFromItem(Items.WAXED_OXIDIZED_CUT_COPPER))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "waxed_oxidized_cut_copper_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.END_STONE_BRICKS)
//                .criterion(hasItem(Items.END_STONE_BRICKS), conditionsFromItem(Items.END_STONE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "end_stone_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.PRISMARINE)
//                .criterion(hasItem(Items.PRISMARINE), conditionsFromItem(Items.PRISMARINE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "prismarine_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.DARK_PRISMARINE)
//                .criterion(hasItem(Items.DARK_PRISMARINE), conditionsFromItem(Items.DARK_PRISMARINE))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "dark_prismarine_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.PRISMARINE_BRICKS)
//                .criterion(hasItem(Items.PRISMARINE_BRICKS), conditionsFromItem(Items.PRISMARINE_BRICKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "prismarine_brick_stairs"));
//
//         ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_STAIRS, 3)
//                .pattern("P  ")
//                .pattern("PP ")
//                .pattern("   ")
//                .input('P', Items.PURPUR_BLOCK)
//                .criterion(hasItem(Items.PURPUR_BLOCK), conditionsFromItem(Items.PURPUR_BLOCK))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "purpur_stairs"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICK_STAIRS, 3)
//                .pattern("A  ")
//                .pattern("AA ")
//                .pattern("   ")
//                .input('A', ModBlocks.AMETHYST_BRICKS)
//                .criterion(hasItem(ModBlocks.AMETHYST_BRICKS.asItem()), conditionsFromItem(ModBlocks.AMETHYST_BRICKS.asItem()))
//                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "crafted_amethyst_stairs"));
//
//
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.OAK_PLANKS)
//                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "oak_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SPRUCE_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.SPRUCE_PLANKS)
//                .criterion(hasItem(Items.SPRUCE_PLANKS), conditionsFromItem(Items.SPRUCE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "spruce_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_OAK_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.DARK_OAK_PLANKS)
//                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "dark_oak_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNGLE_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.JUNGLE_PLANKS)
//                .criterion(hasItem(Items.JUNGLE_PLANKS), conditionsFromItem(Items.JUNGLE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "jungle_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.ACACIA_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.ACACIA_PLANKS)
//                .criterion(hasItem(Items.ACACIA_PLANKS), conditionsFromItem(Items.ACACIA_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "acacia_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.CHERRY_PLANKS)
//                .criterion(hasItem(Items.CHERRY_PLANKS), conditionsFromItem(Items.CHERRY_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "cherry_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.MANGROVE_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.MANGROVE_PLANKS)
//                .criterion(hasItem(Items.MANGROVE_PLANKS), conditionsFromItem(Items.MANGROVE_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "mangrove_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.BAMBOO_PLANKS)
//                .criterion(hasItem(Items.BAMBOO_PLANKS), conditionsFromItem(Items.BAMBOO_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "bamboo_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', Items.BIRCH_PLANKS)
//                .criterion(hasItem(Items.BIRCH_PLANKS), conditionsFromItem(Items.BIRCH_PLANKS))
//                .offerTo(recipeExporter, Identifier.of("minecraft", "birch_trapdoor"));
//
//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TRAPDOOR, 8)
//                .pattern("PPP")
//                .pattern("PPP")
//                .input('P', ModBlocks.AMETHYST_BRICKS)
//                .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
//                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "crafted_amethyst_trapdoor"));








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
                ModBlocks.FIREPROOF_BIRCH_PLANKS.asItem(),
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



        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, 4)
                .pattern("AA ")
                .pattern("AA ")
                .pattern("   ")
                .input('A', Blocks.AMETHYST_BLOCK)
                .criterion(hasItem(Blocks.AMETHYST_BLOCK.asItem()), conditionsFromItem(Blocks.AMETHYST_BLOCK.asItem()))
                .offerTo(recipeExporter, Identifier.of(BetterVanilla.MOD_ID, "amethyst_bricks"));

    }
}
