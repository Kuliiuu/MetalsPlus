package net.kuliiuu.metalsplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.custom.ChiselItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup METAL_PLUS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MetalsPlus.MOD_ID, "metal_plus_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TIN_NUGGET))
                    .displayName(Text.translatable("itemgroup.metalsplus.metal_plus_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BRONZE_DUST);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_NUGGET);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.COPPER_DUST);
                        entries.add(ModItems.COPPER_NUGGET);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.TIN_NUGGET);
                        entries.add(ModItems.TIN_DUST);
                        entries.add(ModItems.LIGNITE_COAL);

                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModItems.BRONZE_HAMMER);

                        entries.add(ModItems.TIN_SWORD);
                        entries.add(ModItems.TIN_AXE);
                        entries.add(ModItems.TIN_PICKAXE);
                        entries.add(ModItems.TIN_SHOVEL);
                        entries.add(ModItems.TIN_HOE);

                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_HOE);

                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);

                        entries.add(ModItems.TIN_HELMET);
                        entries.add(ModItems.TIN_CHESTPLATE);
                        entries.add(ModItems.TIN_LEGGINGS);
                        entries.add(ModItems.TIN_BOOTS);

                        entries.add(ModItems.COPPER_HELMET);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_BOOTS);

                        entries.add(ModItems.OSMIUM_INGOT);
                        entries.add(ModItems.OSMIUM_NUGGET);
                        entries.add(ModItems.RAW_OSMIUM);

                        entries.add(ModItems.OSMIUM_SWORD);
                        entries.add(ModItems.OSMIUM_AXE);
                        entries.add(ModItems.OSMIUM_PICKAXE);
                        entries.add(ModItems.OSMIUM_SHOVEL);
                        entries.add(ModItems.OSMIUM_HOE);
                        entries.add(ModItems.OSMIUM_HAMMER);

                        entries.add(ModItems.OSMIUM_HELMET);
                        entries.add(ModItems.OSMIUM_CHESTPLATE);
                        entries.add(ModItems.OSMIUM_LEGGINGS);
                        entries.add(ModItems.OSMIUM_BOOTS);


                        entries.add(ModItems.BRONZE_BOW);
                        entries.add(ModItems.OSMIUM_BOW);

                        entries.add(ModItems.BLACKBERRIES);
                        entries.add(ModItems.BLUEBERRIES);
                        entries.add(ModItems.RASPBERRIES);
                    }).build());

    public static final ItemGroup METAL_PLUS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MetalsPlus.MOD_ID, "metal_plus_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK))
                    .displayName(Text.translatable("itemgroup.metalsplus.metal_plus_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.TIN_BOOSTER);
                        entries.add(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);
                        entries.add(ModBlocks.LIGNITE_COAL_ORE);
                        entries.add(ModBlocks.LIGNITE_COAL_BLOCK);

                        entries.add(ModBlocks.OSMIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_OSMIUM_ORE);
                        entries.add(ModBlocks.RAW_OSMIUM_BLOCK);
                        entries.add(ModBlocks.OSMIUM_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        MetalsPlus.LOGGER.info("Registering Item Groups - " + MetalsPlus.MOD_ID);
    }
}
