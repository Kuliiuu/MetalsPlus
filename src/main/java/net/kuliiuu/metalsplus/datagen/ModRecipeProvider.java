package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> TIN_SMELTABLE = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        List<ItemConvertible> LIGNITE_SMELTABLE = List.of(ModBlocks.LIGNITE_COAL_ORE, ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);
        List<ItemConvertible> BRONZE_SMELTABLE = List.of(ModItems.BRONZE_DUST);
        List<ItemConvertible> OSMIUM_SMELTABLE = List.of(ModItems.RAW_OSMIUM);

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, TIN_SMELTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 200, "tin_ingot_from_smelting");
        offerBlasting(recipeExporter, TIN_SMELTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 200, "tin_ingot_from_blasting");

        offerSmelting(recipeExporter, LIGNITE_SMELTABLE, RecipeCategory.MISC, ModItems.LIGNITE_COAL, 0.25f, 200, "lignite_from_smelting");
        offerBlasting(recipeExporter, LIGNITE_SMELTABLE, RecipeCategory.MISC, ModItems.LIGNITE_COAL, 0.25f, 200, "lignite_from_blasting");

        offerSmelting(recipeExporter, BRONZE_SMELTABLE, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 200, "bronze_ingot_from_smelting");
        offerBlasting(recipeExporter, BRONZE_SMELTABLE, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 200, "bronze_ingot_from_blasting");

        offerSmelting(recipeExporter, OSMIUM_SMELTABLE, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, 0.25f, 200, "osmium_ingot_from_smelting");
        offerBlasting(recipeExporter, OSMIUM_SMELTABLE, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, 0.25f, 200, "osmium_ingot_from_blasting");

        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.MISC, ModBlocks.TIN_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_TIN, RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, RecipeCategory.MISC, ModBlocks.OSMIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_OSMIUM, RecipeCategory.MISC, ModBlocks.RAW_OSMIUM_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.BRONZE_INGOT, RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LIGNITE_COAL, RecipeCategory.MISC, ModBlocks.LIGNITE_COAL_BLOCK);

        // --- Custom Recipes ---

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOW)
                .pattern("BST")
                .pattern("SBT")
                .pattern("BST")
                .input('S', Items.STICK)
                .input('B', ModItems.BRONZE_INGOT)
                .input('T', Items.STRING)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_bow_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_BOW)
                .pattern("BST")
                .pattern("SBT")
                .pattern("BST")
                .input('S', Items.STICK)
                .input('B', ModItems.OSMIUM_INGOT)
                .input('T', Items.STRING)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_bow_recipe"));

        // Osmium nugget
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OSMIUM_NUGGET, 9)
                .input(ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_nugget_from_ingot"));

        // Osmium ingot from nugget
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OSMIUM_INGOT)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_ingot_from_nugget"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_sword_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_AXE)
                .pattern("BB ")
                .pattern("BS ")
                .pattern(" S ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_axe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_pickaxe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_shovel_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_HOE)
                .pattern("BB ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_hoe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_HAMMER)
                .pattern("DND")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('N', Items.NETHERITE_INGOT)
                .input('D', ModBlocks.OSMIUM_BLOCK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_hammer_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.OSMIUM_INGOT)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_boots_recipe"));

        // Tin Booster
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TIN_BOOSTER)
                .pattern("BIB")
                .pattern("III")
                .pattern("BIB")
                .input('B', ModBlocks.TIN_BLOCK)
                .input('I', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_booster_recipe"));

        // Torch from lignite
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.TORCH, 3)
                .pattern("L  ")
                .pattern("S  ")
                .pattern("   ")
                .input('L', ModItems.LIGNITE_COAL)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LIGNITE_COAL), conditionsFromItem(ModItems.LIGNITE_COAL))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "torch_from_lignite_coal_recipe"));

        // Bronze dust
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_DUST, 3)
                .pattern("CC ")
                .pattern("CT ")
                .pattern("   ")
                .input('T', ModItems.TIN_DUST)
                .input('C', ModItems.COPPER_DUST)
                .criterion(hasItem(ModItems.TIN_DUST), conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_dust_mixing"));

        // Bronze dust from ingot
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_DUST)
                .pattern("C  ")
                .pattern("B  ")
                .pattern("   ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_dust_from_ingot_recipe"));

        // Tin dust
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_DUST)
                .pattern("C  ")
                .pattern("B  ")
                .pattern("   ")
                .input('B', ModItems.TIN_INGOT)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_dust_from_ingot_recipe"));

        // Tin nugget
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_NUGGET, 9)
                .input(ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_nugget_from_ingot"));

        // Bronze nugget
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_NUGGET, 9)
                .input(ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_nugget_from_ingot"));

        // Tin ingot from nugget
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', ModItems.TIN_NUGGET)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_ingot_from_nugget"));

        // Bronze ingot from nugget
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_INGOT)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', ModItems.BRONZE_NUGGET)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_ingot_from_nugget"));


        // Copper dust
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_DUST)
                .pattern("C  ")
                .pattern("B  ")
                .pattern("   ")
                .input('B', Items.COPPER_INGOT)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_dust_recipe"));

        // Chisel
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("BSB")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "chisel_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_sword_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern("BB ")
                .pattern("BS ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_axe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_pickaxe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_shovel_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern("BB ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_hoe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HAMMER)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('D', ModBlocks.BRONZE_BLOCK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_hammer_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_sword_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_AXE)
                .pattern("BB ")
                .pattern("BS ")
                .pattern(" S ")
                .input('B', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_axe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_pickaxe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_shovel_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_HOE)
                .pattern("BB ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_hoe_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_sword_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .pattern("BB ")
                .pattern("BS ")
                .pattern(" S ")
                .input('B', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_axe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_pickaxe_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_shovel_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .pattern("BB ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_hoe_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_boots_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_boots_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_boots_recipe"));


    }
}
