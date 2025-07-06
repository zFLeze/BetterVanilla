package net.flez.bettervanilla.entity.client;

import net.flez.bettervanilla.entity.custom.CustomBlockSitEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class CustomBlockRenderer extends EntityRenderer<CustomBlockSitEntity> {
    public CustomBlockRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(CustomBlockSitEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(CustomBlockSitEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
