package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.block.custom.BlackberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.BlueberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.RaspberryBushBlock;
import net.kuliiuu.metalsplus.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGNITE_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BOOSTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGNITE_COAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_OSMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OSMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OSMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_OSMIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ADAMANTIUM_BLOCK);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLACKBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                BlackberryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.RASPBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                RaspberryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLUEBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                BlueberryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIGNITE_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_BOOTS));


        itemModelGenerator.register(ModItems.OSMIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OSMIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_OSMIUM, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OSMIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OSMIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OSMIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OSMIUM_BOOTS));

        itemModelGenerator.register(ModItems.OSMIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OSMIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OSMIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OSMIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OSMIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OSMIUM_HAMMER, Models.HANDHELD);


        itemModelGenerator.register(ModItems.ADAMANTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ADAMANTIUM, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_BOOTS));

        itemModelGenerator.register(ModItems.ADAMANTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_HOE, Models.HANDHELD);
    }
}
