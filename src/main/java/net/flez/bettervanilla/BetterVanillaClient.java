package net.flez.bettervanilla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.flez.bettervanilla.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class BetterVanillaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIREPROOF_OAK_TRAPDOOR,
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIREPROOF_OAK_DOOR,
                RenderLayer.getCutout());
    }
}
