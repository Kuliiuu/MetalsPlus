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
                    }).build());

    public static void registerItemGroups() {
        MetalsPlus.LOGGER.info("Registering Item Groups - " + MetalsPlus.MOD_ID);
    }
}
