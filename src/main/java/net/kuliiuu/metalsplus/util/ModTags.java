package net.kuliiuu.metalsplus.util;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FUEL_BLOCKS = createTag("fuel_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MetalsPlus.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FUEL_ITEMS = createTag("fuel_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MetalsPlus.MOD_ID, name));
        }
    }
}
