package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.ModItems;
import net.kuliiuu.metalsplus.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.tag.BlockTags.NEEDS_IRON_TOOL;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.LIGNITE_COAL_BLOCK)
                .add(ModBlocks.LIGNITE_COAL_ORE)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_BOOSTER)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.LIGNITE_COAL_BLOCK)
                .add(ModBlocks.LIGNITE_COAL_ORE)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_BOOSTER)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.FUEL_BLOCKS)
                .add(ModBlocks.LIGNITE_COAL_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .add(
                        Blocks.GOLD_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.DIAMOND_ORE,
                        Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.EMERALD_ORE,
                        Blocks.DEEPSLATE_EMERALD_ORE,
                        Blocks.REDSTONE_ORE,
                        Blocks.DEEPSLATE_REDSTONE_ORE
                );

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_TIN_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
    }

}
