package net.flez.bettervanilla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.flez.bettervanilla.block.ModBlocks;
import net.flez.bettervanilla.entity.ModEntities;
import net.flez.bettervanilla.entity.client.BlazingArrowEntityRenderer;
import net.flez.bettervanilla.entity.client.SitEntityRenderer;
import net.flez.bettervanilla.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Items;

public class BetterVanillaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlazingArrowEntityRenderer.registerModArrows();
        EntityRendererRegistry.register(ModEntities.SIT_ENTITY, SitEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BLAZING_ARROW_ENTITY, BlazingArrowEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETHYST_TRAPDOOR, RenderLayer.getCutout());
        ModModelPredicates.registerModelPredicates();
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.CAKE, builder -> builder.add(DataComponentTypes.MAX_STACK_SIZE, 64)));
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.POTION, builder -> builder.add(DataComponentTypes.MAX_STACK_SIZE, 16)));
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.SPLASH_POTION, builder -> builder.add(DataComponentTypes.MAX_STACK_SIZE, 16)));
        DefaultItemComponentEvents.MODIFY.register(modifyContext ->
                modifyContext.modify(Items.LINGERING_POTION, builder -> builder.add(DataComponentTypes.MAX_STACK_SIZE, 16)));
    }
}
