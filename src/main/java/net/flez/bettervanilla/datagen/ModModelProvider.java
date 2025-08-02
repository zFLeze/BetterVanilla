package net.flez.bettervanilla.datagen;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.block.custom.AmethystLampBlock;
import net.flez.bettervanilla.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void registerLogPair(BlockStateModelGenerator blockStateModelGenerator,
                                Block log, Block wood,
                                Block strippedLog, Block strippedWood) {
        blockStateModelGenerator.registerLog(log).log(log).wood(wood);
        blockStateModelGenerator.registerLog(strippedLog).log(strippedLog).wood(strippedWood);
    }



    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool amethystBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS);
        BlockStateModelGenerator.BlockTexturePool fireproofOakPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_OAK_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofSprucePlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_SPRUCE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofDarkOakPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_DARK_OAK_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofJunglePlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_JUNGLE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofCherryPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_CHERRY_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofAcaciaPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_ACACIA_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofMangrovePlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_MANGROVE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofBambooPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_BAMBOO_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fireproofBirchPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIREPROOF_BIRCH_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIREPROOF_BAMBOO_MOSAIC);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_AMETHYST_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_AMETHYST_BLOCK);

        amethystBricksPool.stairs(ModBlocks.AMETHYST_BRICK_STAIRS);
        amethystBricksPool.slab(ModBlocks.AMETHYST_BRICK_SLAB);
        amethystBricksPool.wall(ModBlocks.AMETHYST_BRICK_WALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AMETHYST_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerDoor(ModBlocks.AMETHYST_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.AMETHYST_TRAPDOOR);
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL
                .upload(ModBlocks.AMETHYST_LAMP, blockStateModelGenerator.modelCollector);

        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(
                ModBlocks.AMETHYST_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.AMETHYST_LAMP).coordinate(BlockStateModelGenerator.createBooleanModelMap(
                        AmethystLampBlock.LIT, lampOnIdentifier, lampOffIdentifier)));


        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.SPRUCE_CRAFTING_TABLE, Blocks.SPRUCE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.DARK_OAK_CRAFTING_TABLE, Blocks.DARK_OAK_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.JUNGLE_CRAFTING_TABLE, Blocks.JUNGLE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.ACACIA_CRAFTING_TABLE, Blocks.ACACIA_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.MANGROVE_CRAFTING_TABLE, Blocks.MANGROVE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.CHERRY_CRAFTING_TABLE, Blocks.CHERRY_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.BAMBOO_CRAFTING_TABLE, Blocks.BAMBOO_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.BIRCH_CRAFTING_TABLE, Blocks.BIRCH_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.CRIMSON_CRAFTING_TABLE, Blocks.CRIMSON_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.WARPED_CRAFTING_TABLE, Blocks.WARPED_PLANKS, TextureMap::frontSideWithCustomBottom);

        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.SPRUCE_CHEST), Blocks.SPRUCE_PLANKS).includeWithoutItem(ModBlocks.SPRUCE_CHEST, ModBlocks.TRAPPED_SPRUCE_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.DARK_OAK_CHEST), Blocks.DARK_OAK_PLANKS).includeWithoutItem(ModBlocks.DARK_OAK_CHEST, ModBlocks.TRAPPED_DARK_OAK_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.JUNGLE_CHEST), Blocks.JUNGLE_PLANKS).includeWithoutItem(ModBlocks.JUNGLE_CHEST, ModBlocks.TRAPPED_JUNGLE_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.ACACIA_CHEST), Blocks.ACACIA_PLANKS).includeWithoutItem(ModBlocks.ACACIA_CHEST, ModBlocks.TRAPPED_ACACIA_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.MANGROVE_CHEST), Blocks.MANGROVE_PLANKS).includeWithoutItem(ModBlocks.MANGROVE_CHEST, ModBlocks.TRAPPED_MANGROVE_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.CHERRY_CHEST), Blocks.CHERRY_PLANKS).includeWithoutItem(ModBlocks.CHERRY_CHEST, ModBlocks.TRAPPED_CHERRY_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.BAMBOO_CHEST), Blocks.BAMBOO_PLANKS).includeWithoutItem(ModBlocks.BAMBOO_CHEST, ModBlocks.TRAPPED_BAMBOO_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.BIRCH_CHEST), Blocks.BIRCH_PLANKS).includeWithoutItem(ModBlocks.BIRCH_CHEST, ModBlocks.TRAPPED_BIRCH_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.CRIMSON_CHEST), Blocks.CRIMSON_PLANKS).includeWithoutItem(ModBlocks.CRIMSON_CHEST, ModBlocks.TRAPPED_CRIMSON_CHEST);
        blockStateModelGenerator.registerBuiltin(ModelIds.getBlockModelId(ModBlocks.WARPED_CHEST), Blocks.WARPED_PLANKS).includeWithoutItem(ModBlocks.WARPED_CHEST, ModBlocks.TRAPPED_WARPED_CHEST);

        fireproofOakPlanksPool.stairs(ModBlocks.FIREPROOF_OAK_STAIRS);
        fireproofOakPlanksPool.slab(ModBlocks.FIREPROOF_OAK_SLAB);
        fireproofOakPlanksPool.fence(ModBlocks.FIREPROOF_OAK_FENCE);
        fireproofOakPlanksPool.fenceGate(ModBlocks.FIREPROOF_OAK_FENCE_GATE);
        fireproofOakPlanksPool.pressurePlate(ModBlocks.FIREPROOF_OAK_PRESSURE_PLATE);
        fireproofOakPlanksPool.button(ModBlocks.FIREPROOF_OAK_BUTTON);

        fireproofSprucePlanksPool.stairs(ModBlocks.FIREPROOF_SPRUCE_STAIRS);
        fireproofSprucePlanksPool.slab(ModBlocks.FIREPROOF_SPRUCE_SLAB);
        fireproofSprucePlanksPool.fence(ModBlocks.FIREPROOF_SPRUCE_FENCE);
        fireproofSprucePlanksPool.fenceGate(ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE);
        fireproofSprucePlanksPool.pressurePlate(ModBlocks.FIREPROOF_SPRUCE_PRESSURE_PLATE);
        fireproofSprucePlanksPool.button(ModBlocks.FIREPROOF_SPRUCE_BUTTON);

        fireproofDarkOakPlanksPool.stairs(ModBlocks.FIREPROOF_DARK_OAK_STAIRS);
        fireproofDarkOakPlanksPool.slab(ModBlocks.FIREPROOF_DARK_OAK_SLAB);
        fireproofDarkOakPlanksPool.fence(ModBlocks.FIREPROOF_DARK_OAK_FENCE);
        fireproofDarkOakPlanksPool.fenceGate(ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE);
        fireproofDarkOakPlanksPool.pressurePlate(ModBlocks.FIREPROOF_DARK_OAK_PRESSURE_PLATE);
        fireproofDarkOakPlanksPool.button(ModBlocks.FIREPROOF_DARK_OAK_BUTTON);

        fireproofJunglePlanksPool.stairs(ModBlocks.FIREPROOF_JUNGLE_STAIRS);
        fireproofJunglePlanksPool.slab(ModBlocks.FIREPROOF_JUNGLE_SLAB);
        fireproofJunglePlanksPool.fence(ModBlocks.FIREPROOF_JUNGLE_FENCE);
        fireproofJunglePlanksPool.fenceGate(ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE);
        fireproofJunglePlanksPool.pressurePlate(ModBlocks.FIREPROOF_JUNGLE_PRESSURE_PLATE);
        fireproofJunglePlanksPool.button(ModBlocks.FIREPROOF_JUNGLE_BUTTON);

        fireproofAcaciaPlanksPool.stairs(ModBlocks.FIREPROOF_ACACIA_STAIRS);
        fireproofAcaciaPlanksPool.slab(ModBlocks.FIREPROOF_ACACIA_SLAB);
        fireproofAcaciaPlanksPool.fence(ModBlocks.FIREPROOF_ACACIA_FENCE);
        fireproofAcaciaPlanksPool.fenceGate(ModBlocks.FIREPROOF_ACACIA_FENCE_GATE);
        fireproofAcaciaPlanksPool.pressurePlate(ModBlocks.FIREPROOF_ACACIA_PRESSURE_PLATE);
        fireproofAcaciaPlanksPool.button(ModBlocks.FIREPROOF_ACACIA_BUTTON);

        fireproofMangrovePlanksPool.stairs(ModBlocks.FIREPROOF_MANGROVE_STAIRS);
        fireproofMangrovePlanksPool.slab(ModBlocks.FIREPROOF_MANGROVE_SLAB);
        fireproofMangrovePlanksPool.fence(ModBlocks.FIREPROOF_MANGROVE_FENCE);
        fireproofMangrovePlanksPool.fenceGate(ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE);
        fireproofMangrovePlanksPool.pressurePlate(ModBlocks.FIREPROOF_MANGROVE_PRESSURE_PLATE);
        fireproofMangrovePlanksPool.button(ModBlocks.FIREPROOF_MANGROVE_BUTTON);

        fireproofCherryPlanksPool.stairs(ModBlocks.FIREPROOF_CHERRY_STAIRS);
        fireproofCherryPlanksPool.slab(ModBlocks.FIREPROOF_CHERRY_SLAB);
        fireproofCherryPlanksPool.fence(ModBlocks.FIREPROOF_CHERRY_FENCE);
        fireproofCherryPlanksPool.fenceGate(ModBlocks.FIREPROOF_CHERRY_FENCE_GATE);
        fireproofCherryPlanksPool.pressurePlate(ModBlocks.FIREPROOF_CHERRY_PRESSURE_PLATE);
        fireproofCherryPlanksPool.button(ModBlocks.FIREPROOF_CHERRY_BUTTON);

        fireproofBambooPlanksPool.stairs(ModBlocks.FIREPROOF_BAMBOO_STAIRS);
        fireproofBambooPlanksPool.slab(ModBlocks.FIREPROOF_BAMBOO_SLAB);
        fireproofBambooPlanksPool.fence(ModBlocks.FIREPROOF_BAMBOO_FENCE);
        fireproofBambooPlanksPool.fenceGate(ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE);
        fireproofBambooPlanksPool.pressurePlate(ModBlocks.FIREPROOF_BAMBOO_PRESSURE_PLATE);
        fireproofBambooPlanksPool.button(ModBlocks.FIREPROOF_BAMBOO_BUTTON);


        fireproofBirchPlanksPool.stairs(ModBlocks.FIREPROOF_BIRCH_STAIRS);
        fireproofBirchPlanksPool.slab(ModBlocks.FIREPROOF_BIRCH_SLAB);
        fireproofBirchPlanksPool.fence(ModBlocks.FIREPROOF_BIRCH_FENCE);
        fireproofBirchPlanksPool.fenceGate(ModBlocks.FIREPROOF_BIRCH_FENCE_GATE);
        fireproofBirchPlanksPool.pressurePlate(ModBlocks.FIREPROOF_BIRCH_PRESSURE_PLATE);
        fireproofBirchPlanksPool.button(ModBlocks.FIREPROOF_BIRCH_BUTTON);


        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_OAK_LOG,
                ModBlocks.FIREPROOF_OAK_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_OAK_LOG,
                ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_SPRUCE_LOG,
                ModBlocks.FIREPROOF_SPRUCE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_DARK_OAK_LOG,
                ModBlocks.FIREPROOF_DARK_OAK_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG,
                ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_JUNGLE_LOG,
                ModBlocks.FIREPROOF_JUNGLE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_ACACIA_LOG,
                ModBlocks.FIREPROOF_ACACIA_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG,
                ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_MANGROVE_LOG,
                ModBlocks.FIREPROOF_MANGROVE_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG,
                ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_CHERRY_LOG,
                ModBlocks.FIREPROOF_CHERRY_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG,
                ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD);

        registerLogPair(blockStateModelGenerator,
                ModBlocks.FIREPROOF_BIRCH_LOG,
                ModBlocks.FIREPROOF_BIRCH_WOOD,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG,
                ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD);

        blockStateModelGenerator.registerLog(ModBlocks.FIREPROOF_BAMBOO_BLOCK)
                .log(ModBlocks.FIREPROOF_BAMBOO_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK)
                .log(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AMETHYST_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXIDIZED_COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXIDIZED_COPPER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_DUST, Models.GENERATED);


//        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_BOOTS));


    }
}