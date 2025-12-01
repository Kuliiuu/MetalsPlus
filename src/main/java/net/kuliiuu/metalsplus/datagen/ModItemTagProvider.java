package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kuliiuu.metalsplus.item.ModItems;
import net.kuliiuu.metalsplus.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.FUEL_ITEMS)
                .add(ModItems.LIGNITE_COAL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.COPPER_SWORD)
                .add(ModItems.TIN_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.TIN_AXE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.BRONZE_HAMMER)
                .add(ModItems.TIN_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.TIN_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.COPPER_HOE)
                .add(ModItems.TIN_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.BRONZE_BOOTS)

                .add(ModItems.TIN_HELMET)
                .add(ModItems.TIN_CHESTPLATE)
                .add(ModItems.TIN_LEGGINGS)
                .add(ModItems.TIN_BOOTS)

                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.TIN_HELMET)
                .add(ModItems.COPPER_HELMET);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.TIN_BOOTS)
                .add(ModItems.COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.TIN_CHESTPLATE)
                .add(ModItems.COPPER_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.TIN_LEGGINGS)
                .add(ModItems.COPPER_LEGGINGS);
    }
}
