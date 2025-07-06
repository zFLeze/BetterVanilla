package net.flez.bettervanilla.item;

import net.flez.bettervanilla.BetterVanilla;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
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

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(
                            ModToolMaterials.COPPER, 3, -2.4f))));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(
                            ModToolMaterials.COPPER, 1.5f, -2.8f))));

    public static final Item COPPER_AXE = registerItem("copper_axe",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AxeItem.createAttributeModifiers(
                            ModToolMaterials.COPPER, 6.5f, -3.1f))));

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    ShovelItem.createAttributeModifiers(
                            ModToolMaterials.COPPER, 1.5f, -2.8f))));

    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    HoeItem.createAttributeModifiers(
                            ModToolMaterials.COPPER, -1.5f, -1.0f))));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(13))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(13))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(13))));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(13))));


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
