package net.kuliiuu.metalsplus.block;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.custom.BlackberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.BlueberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.RaspberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.TinBooster;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //Normal Blocks
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
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(3.5f, 4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block OSMIUM_BLOCK = registerBlock("osmium_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(60f, 600f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_OSMIUM_BLOCK = registerBlock("raw_osmium_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(65f, 600f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block TIN_BOOSTER = registerBlock("tin_booster", new TinBooster(
            AbstractBlock.Settings.create()
                    .strength(3f, 4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block LIGNITE_COAL_BLOCK = registerBlock("lignite_coal_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(3, 3)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));


    public static final Block BLACKBERRY_BUSH = registerBlockWithoutBlockItem("blackberry_bush",
            new BlackberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block RASPBERRY_BUSH = registerBlockWithoutBlockItem("raspberry_bush",
            new RaspberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
            new BlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    // Ores
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(3f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(2.5f, 2.5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_LIGNITE_COAL_ORE = registerBlock("deepslate_lignite_coal_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(3f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block LIGNITE_COAL_ORE = registerBlock("lignite_coal_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(4.5f, 3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_OSMIUM_ORE = registerBlock("deepslate_osmium_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(35f, 600f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block OSMIUM_ORE = registerBlock("osmium_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(45f, 600f).requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MetalsPlus.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MetalsPlus.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MetalsPlus.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        MetalsPlus.LOGGER.info("Registering Mod Blocks - " + MetalsPlus.MOD_ID);
    }
}
