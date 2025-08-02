package net.flez.bettervanilla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.client.renderer.AmethystShieldRenderer;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.client.CustomBlockRenderer;
import net.flez.bettervanilla.item.ModItems;
import net.flez.bettervanilla.util.ModModelPredicates;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class BetterVanillaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SIT_ENTITY, CustomBlockRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_TRAPDOOR, RenderLayer.getCutout());
        ModModelPredicates.registerModelPredicates();
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.AMETHYST_SHIELD,
                (stack, mode, matrices, vertexConsumers, light, overlay) -> {
                    MinecraftClient client = MinecraftClient.getInstance();
                    new AmethystShieldRenderer(
                            client.getBlockEntityRenderDispatcher(),
                            client.getEntityModelLoader()
                    ).render(stack, mode, matrices, vertexConsumers, light, overlay);
                }
        );
    }
}
