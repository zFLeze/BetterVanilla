package net.flez.bettervanilla.entity.client;

import net.flez.bettervanilla.entity.custom.SitEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SitEntityRenderer extends EntityRenderer<SitEntity> {
    public SitEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SitEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(SitEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
