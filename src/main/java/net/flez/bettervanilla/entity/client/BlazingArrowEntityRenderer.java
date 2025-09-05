package net.flez.bettervanilla.entity.client;

import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class BlazingArrowEntityRenderer extends ArrowEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(BetterVanilla.MOD_ID, "textures/entity/projectiles/blazing_arrow_entity.png");
    public BlazingArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ArrowEntity arrowEntity) {
        System.out.println("RENDERER CALLED");
        return TEXTURE;
    }

    public static void registerModArrows() {
        System.out.println("Registering Mod Arrows for " + BetterVanilla.MOD_ID);
    }
}
