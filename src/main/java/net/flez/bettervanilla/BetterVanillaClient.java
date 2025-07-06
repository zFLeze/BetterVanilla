package net.flez.bettervanilla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.client.CustomBlockRenderer;

public class BetterVanillaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SIT_ENTITY, CustomBlockRenderer::new);
    }
}
