package net.flez.bettervanilla.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> COPPER_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(BetterVanilla.MOD_ID, "copper_tools"));
    public static final TagKey<Item> COPPER_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(BetterVanilla.MOD_ID, "copper_armor"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.COPPER_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS);

        getOrCreateTagBuilder(ModItemTagProvider.COPPER_TOOLS)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.COPPER_HOE)
                .add(ModItems.COPPER_SWORD);

        getOrCreateTagBuilder(ModItemTagProvider.COPPER_ARMOR)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS);

    }
}
