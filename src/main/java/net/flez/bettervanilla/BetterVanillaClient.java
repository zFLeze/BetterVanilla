package net.flez.bettervanilla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.client.SitEntityRenderer;
import net.flez.bettervanilla.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Items;

public class BetterVanillaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SIT_ENTITY, SitEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_TRAPDOOR, RenderLayer.getCutout());
        ModModelPredicates.registerModelPredicates();
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.TOTEM_OF_UNDYING, builder -> builder.add(DataComponentTypes.MAX_STACK_SIZE, 64)));
    }
}
