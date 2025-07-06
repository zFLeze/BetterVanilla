package net.flez.bettervanilla.entity;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.entity.custom.CustomBlockSitEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<CustomBlockSitEntity> SIT_ENTITY =
                    Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(BetterVanilla.MOD_ID, "sit_entity"),
                    EntityType.Builder.<CustomBlockSitEntity>create(CustomBlockSitEntity::new, SpawnGroup.MISC)
                            .disableSummon()
                            .disableSaving()
                            .dimensions(0.001f, 0.001f)
                            .build()
            );

    public static void registerModEntites() {
        BetterVanilla.LOGGER.info("Registering Entites for " + BetterVanilla.MOD_ID);
    }
}
