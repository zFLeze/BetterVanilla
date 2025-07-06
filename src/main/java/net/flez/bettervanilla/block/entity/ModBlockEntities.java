package net.flez.bettervanilla.block.entity;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.block.entity.custom.BatteryBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<BatteryBlockEntity> BATERRY_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterVanilla.MOD_ID, "battery_be"),
                    BlockEntityType.Builder.create(BatteryBlockEntity::new, ModBlocks.BATERRY_BLOCK).build(null));

    public static void registerBlockEntities() {
        BetterVanilla.LOGGER.info("Registering Block Entities for " + BetterVanilla.MOD_ID);
    }
}
