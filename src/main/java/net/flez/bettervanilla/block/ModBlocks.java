package net.flez.bettervanilla.block;

import net.flez.bettervanilla.BetterVanilla;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flez.bettervanilla.block.custom.BatteryBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BATERRY_BLOCK = registerBlock("battery_block",
            new BatteryBlock(AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .nonOpaque()));



    public static final Block FIREPROOF_OAK_LOG = registerBlock("fireproof_oak_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_WOOD = registerBlock("fireproof_oak_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_OAK_LOG = registerBlock("fireproof_stripped_oak_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_OAK_WOOD = registerBlock("fireproof_stripped_oak_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_PLANKS = registerBlock("fireproof_oak_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_STAIRS = registerBlock("fireproof_oak_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_OAK_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_SLAB = registerBlock("fireproof_oak_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_BUTTON = registerBlock("fireproof_oak_button",
            new ButtonBlock(BlockSetType.OAK, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_PRESSURE_PLATE = registerBlock("fireproof_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_FENCE = registerBlock("fireproof_oak_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_FENCE_GATE = registerBlock("fireproof_oak_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_DOOR = registerBlock("fireproof_oak_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_OAK_TRAPDOOR = registerBlock("fireproof_oak_trapdoor",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));






    public static final Block FIREPROOF_SPRUCE_LOG = registerBlock("fireproof_spruce_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_WOOD = registerBlock("fireproof_spruce_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_SPRUCE_LOG = registerBlock("fireproof_stripped_spruce_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_SPRUCE_WOOD = registerBlock("fireproof_stripped_spruce_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_PLANKS = registerBlock("fireproof_spruce_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_STAIRS = registerBlock("fireproof_spruce_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_SPRUCE_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_SLAB = registerBlock("fireproof_spruce_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_DOOR = registerBlock("fireproof_spruce_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_TRAPDOOR = registerBlock("fireproof_spruce_trapdoor",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_BUTTON = registerBlock("fireproof_spruce_button",
            new ButtonBlock(BlockSetType.SPRUCE, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_PRESSURE_PLATE = registerBlock("fireproof_spruce_pressure_plate",
            new PressurePlateBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_FENCE = registerBlock("fireproof_spruce_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_SPRUCE_FENCE_GATE = registerBlock("fireproof_spruce_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));










    public static final Block FIREPROOF_DARK_OAK_LOG = registerBlock("fireproof_dark_oak_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_WOOD = registerBlock("fireproof_dark_oak_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_DARK_OAK_LOG = registerBlock("fireproof_stripped_dark_oak_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_DARK_OAK_WOOD = registerBlock("fireproof_stripped_dark_oak_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_PLANKS = registerBlock("fireproof_dark_oak_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_STAIRS = registerBlock("fireproof_dark_oak_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_DARK_OAK_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_SLAB = registerBlock("fireproof_dark_oak_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_DOOR = registerBlock("fireproof_dark_oak_door",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_TRAPDOOR = registerBlock("fireproof_dark_oak_trapdoor",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_BUTTON = registerBlock("fireproof_dark_oak_button",
            new ButtonBlock(BlockSetType.DARK_OAK, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_PRESSURE_PLATE = registerBlock("fireproof_dark_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_FENCE = registerBlock("fireproof_dark_oak_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_DARK_OAK_FENCE_GATE = registerBlock("fireproof_dark_oak_fence_gate",
            new FenceGateBlock(WoodType.DARK_OAK, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));





    public static final Block FIREPROOF_ACACIA_PLANKS = registerBlock("fireproof_acacia_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_LOG = registerBlock("fireproof_acacia_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_WOOD = registerBlock("fireproof_acacia_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_ACACIA_LOG = registerBlock("fireproof_stripped_acacia_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_ACACIA_WOOD = registerBlock("fireproof_stripped_acacia_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_STAIRS = registerBlock("fireproof_acacia_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_ACACIA_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_SLAB = registerBlock("fireproof_acacia_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_DOOR = registerBlock("fireproof_acacia_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_TRAPDOOR = registerBlock("fireproof_acacia_trapdoor",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_BUTTON = registerBlock("fireproof_acacia_button",
            new ButtonBlock(BlockSetType.ACACIA, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_PRESSURE_PLATE = registerBlock("fireproof_acacia_pressure_plate",
            new PressurePlateBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_FENCE = registerBlock("fireproof_acacia_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_ACACIA_FENCE_GATE = registerBlock("fireproof_acacia_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));





    public static final Block FIREPROOF_CHERRY_PLANKS = registerBlock("fireproof_cherry_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_LOG = registerBlock("fireproof_cherry_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_WOOD = registerBlock("fireproof_cherry_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_CHERRY_LOG = registerBlock("fireproof_stripped_cherry_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_CHERRY_WOOD = registerBlock("fireproof_stripped_cherry_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_STAIRS = registerBlock("fireproof_cherry_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_CHERRY_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_SLAB = registerBlock("fireproof_cherry_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_DOOR = registerBlock("fireproof_cherry_door",
            new DoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_TRAPDOOR = registerBlock("fireproof_cherry_trapdoor",
            new DoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_BUTTON = registerBlock("fireproof_cherry_button",
            new ButtonBlock(BlockSetType.CHERRY, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_PRESSURE_PLATE = registerBlock("fireproof_cherry_pressure_plate",
            new PressurePlateBlock(BlockSetType.CHERRY, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_FENCE = registerBlock("fireproof_cherry_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_CHERRY_FENCE_GATE = registerBlock("fireproof_cherry_fence_gate",
            new FenceGateBlock(WoodType.CHERRY, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));




    public static final Block FIREPROOF_BAMBOO_PLANKS = registerBlock("fireproof_bamboo_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_BLOCK = registerBlock("fireproof_bamboo_block",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_BAMBOO_BLOCK = registerBlock("fireproof_stripped_bamboo_block",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_MOSAIC = registerBlock("fireproof_bamboo_mosaic",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_STAIRS = registerBlock("fireproof_bamboo_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_BAMBOO_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_SLAB = registerBlock("fireproof_bamboo_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_DOOR = registerBlock("fireproof_bamboo_door",
            new DoorBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_TRAPDOOR = registerBlock("fireproof_bamboo_trapdoor",
            new DoorBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_BUTTON = registerBlock("fireproof_bamboo_button",
            new ButtonBlock(BlockSetType.BAMBOO, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_PRESSURE_PLATE = registerBlock("fireproof_bamboo_pressure_plate",
            new PressurePlateBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_FENCE = registerBlock("fireproof_bamboo_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BAMBOO_FENCE_GATE = registerBlock("fireproof_bamboo_fence_gate",
            new FenceGateBlock(WoodType.BAMBOO, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));





    public static final Block FIREPROOF_BIRCH_LOG = registerBlock("fireproof_birch_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_WOOD = registerBlock("fireproof_birch_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_BIRCH_LOG = registerBlock("fireproof_stripped_birch_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_BIRCH_WOOD = registerBlock("fireproof_stripped_birch_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_PLANKS = registerBlock("fireproof_birch_planks",
            new Block(AbstractBlock.Settings.create().strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_STAIRS = registerBlock("fireproof_birch_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_BIRCH_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_SLAB = registerBlock("fireproof_birch_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_DOOR = registerBlock("fireproof_birch_door",
            new DoorBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_TRAPDOOR = registerBlock("fireproof_birch_trapdoor",
            new DoorBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_BUTTON = registerBlock("fireproof_birch_button",
            new ButtonBlock(BlockSetType.BIRCH, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_PRESSURE_PLATE = registerBlock("fireproof_birch_pressure_plate",
            new PressurePlateBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_FENCE = registerBlock("fireproof_birch_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_BIRCH_FENCE_GATE = registerBlock("fireproof_birch_fence_gate",
            new FenceGateBlock(WoodType.BIRCH, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));




    public static final Block FIREPROOF_JUNGLE_LOG = registerBlock("fireproof_jungle_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_WOOD = registerBlock("fireproof_jungle_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_JUNGLE_LOG = registerBlock("fireproof_stripped_jungle_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_JUNGLE_WOOD = registerBlock("fireproof_stripped_jungle_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_PLANKS = registerBlock("fireproof_jungle_planks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_STAIRS = registerBlock("fireproof_jungle_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_JUNGLE_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_SLAB = registerBlock("fireproof_jungle_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_BUTTON = registerBlock("fireproof_jungle_button",
            new ButtonBlock(BlockSetType.JUNGLE, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_PRESSURE_PLATE = registerBlock("fireproof_jungle_pressure_plate",
            new PressurePlateBlock(BlockSetType.JUNGLE, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_FENCE = registerBlock("fireproof_jungle_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_JUNGLE_FENCE_GATE = registerBlock("fireproof_jungle_fence_gate",
            new FenceGateBlock(WoodType.JUNGLE, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));






    public static final Block FIREPROOF_MANGROVE_LOG = registerBlock("fireproof_mangrove_log",
            new PillarBlock(AbstractBlock.Settings.create()
            .strength(2f, 2f)
            .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_WOOD = registerBlock("fireproof_mangrove_wood",
            new PillarBlock(AbstractBlock.Settings.create()
            .strength(2f, 2f)
            .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_MANGROVE_LOG = registerBlock("fireproof_stripped_mangrove_log",
            new PillarBlock(AbstractBlock.Settings.create()
            .strength(2f, 2f)
            .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_STRIPPED_MANGROVE_WOOD = registerBlock("fireproof_stripped_mangrove_wood",
            new PillarBlock(AbstractBlock.Settings.create()
            .strength(2f, 2f)
            .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_PLANKS = registerBlock("fireproof_mangrove_planks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_STAIRS = registerBlock("fireproof_mangrove_stairs",
            new StairsBlock(ModBlocks.FIREPROOF_MANGROVE_PLANKS
                    .getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_SLAB = registerBlock("fireproof_mangrove_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_DOOR = registerBlock("fireproof_mangrove_door",
            new DoorBlock(BlockSetType.MANGROVE, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_TRAPDOOR = registerBlock("fireproof_mangrove_trapdoor",
            new DoorBlock(BlockSetType.MANGROVE, AbstractBlock.Settings.create()
                    .strength(3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_BUTTON = registerBlock("fireproof_mangrove_button",
            new ButtonBlock(BlockSetType.MANGROVE, 15, AbstractBlock.Settings.create()
                    .strength(0.5f, 1.5f)
                    .noCollision()
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_PRESSURE_PLATE = registerBlock("fireproof_mangrove_pressure_plate",
            new PressurePlateBlock(BlockSetType.MANGROVE, AbstractBlock.Settings.create()
                    .strength(0.5f, 2.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_FENCE = registerBlock("fireproof_mangrove_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block FIREPROOF_MANGROVE_FENCE_GATE = registerBlock("fireproof_mangrove_fence_gate",
            new FenceGateBlock(WoodType.MANGROVE, AbstractBlock.Settings.create()
                    .strength(2f, 3f)
                    .sounds(BlockSoundGroup.WOOD)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BetterVanilla.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BetterVanilla.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BetterVanilla.LOGGER.info("Registering blocks for " + BetterVanilla.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(FIREPROOF_OAK_PLANKS);
            entries.add(FIREPROOF_OAK_LOG);
            entries.add(FIREPROOF_OAK_WOOD);
            entries.add(FIREPROOF_STRIPPED_OAK_LOG);
            entries.add(FIREPROOF_STRIPPED_OAK_WOOD);
            entries.add(FIREPROOF_OAK_STAIRS);
            entries.add(FIREPROOF_OAK_SLAB);
            entries.add(FIREPROOF_OAK_DOOR);
            entries.add(FIREPROOF_OAK_TRAPDOOR);
            entries.add(FIREPROOF_OAK_FENCE);
            entries.add(FIREPROOF_OAK_FENCE_GATE);
            entries.add(FIREPROOF_OAK_PRESSURE_PLATE);
            entries.add(FIREPROOF_OAK_BUTTON);

            entries.add(FIREPROOF_SPRUCE_PLANKS);
            entries.add(FIREPROOF_SPRUCE_LOG);
            entries.add(FIREPROOF_SPRUCE_WOOD);
            entries.add(FIREPROOF_STRIPPED_SPRUCE_LOG);
            entries.add(FIREPROOF_STRIPPED_SPRUCE_WOOD);
            entries.add(FIREPROOF_SPRUCE_STAIRS);
            entries.add(FIREPROOF_SPRUCE_SLAB);
            entries.add(FIREPROOF_SPRUCE_DOOR);
            entries.add(FIREPROOF_SPRUCE_TRAPDOOR);
            entries.add(FIREPROOF_SPRUCE_FENCE);
            entries.add(FIREPROOF_SPRUCE_FENCE_GATE);
            entries.add(FIREPROOF_SPRUCE_PRESSURE_PLATE);
            entries.add(FIREPROOF_SPRUCE_BUTTON);

            entries.add(FIREPROOF_BIRCH_PLANKS);
            entries.add(FIREPROOF_BIRCH_LOG);
            entries.add(FIREPROOF_BIRCH_WOOD);
            entries.add(FIREPROOF_STRIPPED_BIRCH_LOG);
            entries.add(FIREPROOF_STRIPPED_BIRCH_WOOD);
            entries.add(FIREPROOF_BIRCH_STAIRS);
            entries.add(FIREPROOF_BIRCH_SLAB);
            entries.add(FIREPROOF_BIRCH_DOOR);
            entries.add(FIREPROOF_BIRCH_TRAPDOOR);
            entries.add(FIREPROOF_BIRCH_FENCE);
            entries.add(FIREPROOF_BIRCH_FENCE_GATE);
            entries.add(FIREPROOF_BIRCH_PRESSURE_PLATE);
            entries.add(FIREPROOF_BIRCH_BUTTON);

            entries.add(FIREPROOF_DARK_OAK_PLANKS);
            entries.add(FIREPROOF_DARK_OAK_LOG);
            entries.add(FIREPROOF_DARK_OAK_WOOD);
            entries.add(FIREPROOF_STRIPPED_DARK_OAK_LOG);
            entries.add(FIREPROOF_STRIPPED_DARK_OAK_WOOD);
            entries.add(FIREPROOF_DARK_OAK_STAIRS);
            entries.add(FIREPROOF_DARK_OAK_SLAB);
            entries.add(FIREPROOF_DARK_OAK_DOOR);
            entries.add(FIREPROOF_DARK_OAK_TRAPDOOR);
            entries.add(FIREPROOF_DARK_OAK_FENCE);
            entries.add(FIREPROOF_DARK_OAK_FENCE_GATE);
            entries.add(FIREPROOF_DARK_OAK_PRESSURE_PLATE);
            entries.add(FIREPROOF_DARK_OAK_BUTTON);

            entries.add(FIREPROOF_ACACIA_PLANKS);
            entries.add(FIREPROOF_ACACIA_LOG);
            entries.add(FIREPROOF_ACACIA_WOOD);
            entries.add(FIREPROOF_STRIPPED_ACACIA_LOG);
            entries.add(FIREPROOF_STRIPPED_ACACIA_WOOD);
            entries.add(FIREPROOF_ACACIA_STAIRS);
            entries.add(FIREPROOF_ACACIA_SLAB);
            entries.add(FIREPROOF_ACACIA_DOOR);
            entries.add(FIREPROOF_ACACIA_TRAPDOOR);
            entries.add(FIREPROOF_ACACIA_FENCE);
            entries.add(FIREPROOF_ACACIA_FENCE_GATE);
            entries.add(FIREPROOF_ACACIA_PRESSURE_PLATE);
            entries.add(FIREPROOF_ACACIA_BUTTON);

            entries.add(FIREPROOF_CHERRY_PLANKS);
            entries.add(FIREPROOF_CHERRY_LOG);
            entries.add(FIREPROOF_CHERRY_WOOD);
            entries.add(FIREPROOF_STRIPPED_CHERRY_LOG);
            entries.add(FIREPROOF_STRIPPED_CHERRY_WOOD);
            entries.add(FIREPROOF_CHERRY_STAIRS);
            entries.add(FIREPROOF_CHERRY_SLAB);
            entries.add(FIREPROOF_CHERRY_DOOR);
            entries.add(FIREPROOF_CHERRY_TRAPDOOR);
            entries.add(FIREPROOF_CHERRY_FENCE);
            entries.add(FIREPROOF_CHERRY_FENCE_GATE);
            entries.add(FIREPROOF_CHERRY_PRESSURE_PLATE);
            entries.add(FIREPROOF_CHERRY_BUTTON);

            entries.add(FIREPROOF_BAMBOO_PLANKS);
            entries.add(FIREPROOF_BAMBOO_BLOCK);
            entries.add(FIREPROOF_STRIPPED_BAMBOO_BLOCK);
            entries.add(FIREPROOF_BAMBOO_MOSAIC);
            entries.add(FIREPROOF_BAMBOO_STAIRS);
            entries.add(FIREPROOF_BAMBOO_SLAB);
            entries.add(FIREPROOF_BAMBOO_DOOR);
            entries.add(FIREPROOF_BAMBOO_TRAPDOOR);
            entries.add(FIREPROOF_BAMBOO_FENCE);
            entries.add(FIREPROOF_BAMBOO_FENCE_GATE);
            entries.add(FIREPROOF_BAMBOO_PRESSURE_PLATE);
            entries.add(FIREPROOF_BAMBOO_BUTTON);

            entries.add(FIREPROOF_JUNGLE_PLANKS);
            entries.add(FIREPROOF_JUNGLE_LOG);
            entries.add(FIREPROOF_JUNGLE_WOOD);
            entries.add(FIREPROOF_STRIPPED_JUNGLE_LOG);
            entries.add(FIREPROOF_STRIPPED_JUNGLE_WOOD);
            entries.add(FIREPROOF_JUNGLE_STAIRS);
            entries.add(FIREPROOF_JUNGLE_SLAB);
            entries.add(FIREPROOF_JUNGLE_FENCE);
            entries.add(FIREPROOF_JUNGLE_FENCE_GATE);
            entries.add(FIREPROOF_JUNGLE_PRESSURE_PLATE);
            entries.add(FIREPROOF_JUNGLE_BUTTON);

            entries.add(FIREPROOF_MANGROVE_PLANKS);
            entries.add(FIREPROOF_MANGROVE_LOG);
            entries.add(FIREPROOF_MANGROVE_WOOD);
            entries.add(FIREPROOF_STRIPPED_MANGROVE_LOG);
            entries.add(FIREPROOF_STRIPPED_MANGROVE_WOOD);
            entries.add(FIREPROOF_MANGROVE_STAIRS);
            entries.add(FIREPROOF_MANGROVE_SLAB);
            entries.add(FIREPROOF_MANGROVE_DOOR);
            entries.add(FIREPROOF_MANGROVE_TRAPDOOR);
            entries.add(FIREPROOF_MANGROVE_FENCE);
            entries.add(FIREPROOF_MANGROVE_FENCE_GATE);
            entries.add(FIREPROOF_MANGROVE_PRESSURE_PLATE);
            entries.add(FIREPROOF_MANGROVE_BUTTON);
        });
    }
}
