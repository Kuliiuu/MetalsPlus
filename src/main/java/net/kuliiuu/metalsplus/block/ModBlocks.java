package net.kuliiuu.metalsplus.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(3f, 4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(4f, 5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new Block(
            AbstractBlock.Settings.create()
                    .strength(3f, 3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(3.5f, 4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block TIN_ORE = registerBlock("tin_ore", new Block(
            AbstractBlock.Settings.create()
                    .strength(2.5f, 2.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MetalsPlus.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MetalsPlus.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        MetalsPlus.LOGGER.info("Registering Mod Blocks - " + MetalsPlus.MOD_ID);
        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.TIN_BLOCK);
            entries.add(ModBlocks.BRONZE_BLOCK);
            entries.add(ModBlocks.RAW_TIN_BLOCK);
            entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
            entries.add(ModBlocks.TIN_ORE);

        });
         */
    }
}
