package net.flez.bettervanilla.block.entity;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<ModTrappedChestBlockEntity> TRAPPED_CHEST_BLOCK_ENTITY;

    public static void registerTrappedChestEntities() {
        TRAPPED_CHEST_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(BetterVanilla.MOD_ID, "trapped_chest"),
                BlockEntityType.Builder.create(
                        ModTrappedChestBlockEntity::new,
                        ModBlocks.TRAPPED_SPRUCE_CHEST,
                        ModBlocks.TRAPPED_DARK_OAK_CHEST,
                        ModBlocks.TRAPPED_JUNGLE_CHEST,
                        ModBlocks.TRAPPED_ACACIA_CHEST,
                        ModBlocks.TRAPPED_MANGROVE_CHEST,
                        ModBlocks.TRAPPED_CHERRY_CHEST,
                        ModBlocks.TRAPPED_BAMBOO_CHEST,
                        ModBlocks.TRAPPED_BIRCH_CHEST,
                        ModBlocks.TRAPPED_CRIMSON_CHEST,
                        ModBlocks.TRAPPED_WARPED_CHEST

                ).build(null)
        );
        System.out.println("Registering TRAPPED_CHEST_BLOCK_ENTITY for: " + ModBlocks.TRAPPED_JUNGLE_CHEST);
    }


    public static void registerBlockEntities() {
        BetterVanilla.LOGGER.info("Registering Block Entities for " + BetterVanilla.MOD_ID);
    }
}
