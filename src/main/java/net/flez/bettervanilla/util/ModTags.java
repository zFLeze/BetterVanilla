package net.flez.bettervanilla.util;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.BetterVanilla;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LOG = createTag("log");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BetterVanilla.MOD_ID, name));
        }
    }
    public static class Items {

        }
    }

