package net.flez.bettervanilla.item;

import net.flez.bettervanilla.BetterVanilla;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new Item.Settings()));
    public static final Item OXIDIZED_COPPER_DUST = registerItem("oxidized_copper_dust", new Item(new Item.Settings()));
    public static final Item OXIDIZED_COPPER_INGOT = registerItem("oxidized_copper_ingot", new Item(new Item.Settings()));
    public static final Item EMERALD_DUST = registerItem("emerald_dust", new Item(new Item.Settings()));
    public static final Item COAL_DUST = registerItem("coal_dust", new Item(new Item.Settings()));
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));
    public static final Item GOLD_DUST = registerItem("gold_dust", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterVanilla.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterVanilla.LOGGER.info("Registering items for " + BetterVanilla.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COPPER_DUST);
            entries.add(OXIDIZED_COPPER_DUST);
            entries.add(OXIDIZED_COPPER_INGOT);
            entries.add(EMERALD_DUST);
            entries.add(COAL_DUST);
            entries.add(AMETHYST_DUST);
            entries.add(GOLD_DUST);
        });
    }
}
