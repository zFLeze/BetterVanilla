package net.flez.bettervanilla.entity;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.entity.custom.BlazingArrowEntity;
import net.flez.bettervanilla.entity.custom.SitEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SitEntity> SIT_ENTITY =
                    Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(BetterVanilla.MOD_ID, "sit_entity"),
                    EntityType.Builder.<SitEntity>create(SitEntity::new, SpawnGroup.MISC)
                            .disableSummon()
                            .disableSaving()
                            .dimensions(0.001f, 0.001f)
                            .build()
            );

    public static final EntityType<BlazingArrowEntity> BLAZING_ARROW_ENTITY =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(BetterVanilla.MOD_ID, "blazing_arrow_entity"),
                    EntityType.Builder.<BlazingArrowEntity>create(BlazingArrowEntity::new, SpawnGroup.MISC)
                            .dimensions(0.5F, 0.5F)
                            .maxTrackingRange(4)
                            .trackingTickInterval(20)
                            .build()
            );


    public static void registerModEntites() {
        BetterVanilla.LOGGER.info("Registering Entites for " + BetterVanilla.MOD_ID);
    }
}
