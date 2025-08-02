package net.flez.bettervanilla.client.renderer;

import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AmethystShieldRenderer extends BuiltinModelItemRenderer {

    private static final ModelIdentifier MODEL_ID =
            new ModelIdentifier(Identifier.of(BetterVanilla.MOD_ID, "amethyst_shield"), "inventory");

    public AmethystShieldRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelLoader loader) {
        super(null, null);
    }

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        MinecraftClient client = MinecraftClient.getInstance();
        BakedModelManager modelManager = client.getBakedModelManager();
        BakedModel model = modelManager.getModel(MODEL_ID);
        ItemRenderer itemRenderer = client.getItemRenderer();

        itemRenderer.renderItem(stack, mode, false, matrices, vertexConsumers, light, overlay, model);
    }
}
