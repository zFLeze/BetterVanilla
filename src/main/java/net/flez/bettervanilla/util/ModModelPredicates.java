package net.flez.bettervanilla.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.datacomponents.ModDataComponents;
import net.flez.bettervanilla.datagen.ModItemTagProvider;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(
                Identifier.of(BetterVanilla.MOD_ID, "oxidization"),
                (stack, world, entity, seed) -> {
                    Integer stage = stack.get(ModDataComponents.OXIDATION_STAGE);
                    return stage == null ? 0.0F : stage / 3.0F;
                }
        );

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                for (int i = 0; i < player.getInventory().size(); i++) {
                    ItemStack stack = player.getInventory().getStack(i);
                    if (!stack.isIn(ModItemTagProvider.COPPER_TOOLS) && !stack.isIn(ModItemTagProvider.COPPER_ARMOR))
                        continue;

                    Integer stage = stack.get(ModDataComponents.OXIDATION_STAGE);
                    if (stage == null) stage = 0;

                    if (stage < 3 && player.getWorld().random.nextFloat() < (1.0f / 20000.0f)) {
                        stack.set(ModDataComponents.OXIDATION_STAGE, stage + 1);
                    }

                    if (stage == 1) {
                        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal("Exposed " + stack.getItem().getName().getString()));
                    } else if (stage == 2) {
                        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal("Weathered " + stack.getItem().getName().getString()));
                    } else if (stage == 3) {
                        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal("Oxidized " + stack.getItem().getName().getString()));
                    }
                }
            }
        });
    }
}
