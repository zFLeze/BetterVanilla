package net.flez.bettervanilla.item;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

    public class ModItemGroups {
        public static final ItemGroup FIREPROOF_WOOD_BLOCKS = Registry.register(
                Registries.ITEM_GROUP, Identifier.of(BetterVanilla.MOD_ID, "fireproof_wood_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.FIREPROOF_OAK_LOG))
                        .displayName(Text.translatable("itemgroup.bettervanilla.fireproof_wood_blocks"))
                        .entries((displayContext, entries) -> {
                            //  Oak
                            entries.add(ModBlocks.FIREPROOF_OAK_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_OAK_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_OAK_LOG);
                            entries.add(ModBlocks.FIREPROOF_OAK_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_OAK_WOOD);
                            entries.add(ModBlocks.FIREPROOF_OAK_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_OAK_SLAB);
                            entries.add(ModBlocks.FIREPROOF_OAK_FENCE);
                            entries.add(ModBlocks.FIREPROOF_OAK_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_OAK_DOOR);
                            entries.add(ModBlocks.FIREPROOF_OAK_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_OAK_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_OAK_BUTTON);

                            //  Spruce
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_LOG);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_SPRUCE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_SLAB);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_FENCE);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_DOOR);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_SPRUCE_BUTTON);

                            //  Birch
                            entries.add(ModBlocks.FIREPROOF_BIRCH_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_BIRCH_LOG);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_BIRCH_WOOD);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_SLAB);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_FENCE);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_DOOR);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_BIRCH_BUTTON);

                            //  Jungle
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_LOG);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_JUNGLE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_SLAB);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_FENCE);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_DOOR);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_JUNGLE_BUTTON);


                            //  Acacia
                            entries.add(ModBlocks.FIREPROOF_ACACIA_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_ACACIA_LOG);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_ACACIA_WOOD);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_SLAB);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_FENCE);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_DOOR);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_ACACIA_BUTTON);

                            //  Dark Oak
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_LOG);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_DARK_OAK_WOOD);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_SLAB);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_FENCE);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_DOOR);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_DARK_OAK_BUTTON);

                            //  Mangrove
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_LOG);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_MANGROVE_WOOD);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_SLAB);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_FENCE);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_DOOR);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_MANGROVE_BUTTON);

                            //  Cherry
                            entries.add(ModBlocks.FIREPROOF_CHERRY_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_LOG);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_CHERRY_LOG);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_WOOD);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_CHERRY_WOOD);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_SLAB);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_FENCE);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_DOOR);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_CHERRY_BUTTON);

                            //  Bamboo
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_PLANKS);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_BLOCK);
                            entries.add(ModBlocks.FIREPROOF_STRIPPED_BAMBOO_BLOCK);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_MOSAIC);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_STAIRS);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_SLAB);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_FENCE);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_FENCE_GATE);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_DOOR);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_TRAPDOOR);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_PRESSURE_PLATE);
                            entries.add(ModBlocks.FIREPROOF_BAMBOO_BUTTON);
                        }).build());

        public static void registerItemGroup() {
            BetterVanilla.LOGGER.info("Registering Item groups for " + BetterVanilla.MOD_ID);
        }
    }