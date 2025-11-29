package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.ModItems;
import net.kuliiuu.metalsplus.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

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
    }
}
