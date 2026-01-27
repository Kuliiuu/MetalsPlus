package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registry;
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
        List<ItemConvertible> ADAMANTIUM_SMELTABLE = List.of(ModItems.RAW_ADAMANTIUM, ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        List<ItemConvertible> LIGNITE_SMELTABLE = List.of(ModBlocks.LIGNITE_COAL_ORE, ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE);
        List<ItemConvertible> BRONZE_SMELTABLE = List.of(ModItems.BRONZE_DUST);
        List<ItemConvertible> OSMIUM_SMELTABLE = List.of(ModItems.RAW_OSMIUM);

        // Torch from lignite
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.TORCH, 3)
                .pattern("L  ")
                .pattern("S  ")
                .pattern("   ")
                .input('L', ModItems.LIGNITE_COAL)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LIGNITE_COAL), conditionsFromItem(ModItems.LIGNITE_COAL))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "torch_from_lignite_coal_recipe"));
        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LIGNITE_COAL, RecipeCategory.MISC, ModBlocks.LIGNITE_COAL_BLOCK);

        /* =========================================================
         * ████████╗██╗███╗   ██╗
         * ╚══██╔══╝██║████╗  ██║
         *    ██║   ██║██╔██╗ ██║
         *    ██║   ██║██║╚██╗██║
         *    ██║   ██║██║ ╚████║
         *    ╚═╝   ╚═╝╚═╝  ╚═══╝
         * ========================================================= */
        // Tin Booster
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TIN_BOOSTER)
                .pattern("BIB")
                .pattern("III")
                .pattern("BIB")
                .input('B', ModBlocks.TIN_BLOCK)
                .input('I', ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_booster_recipe"));

        offerNuggetAndIngotRecipes(recipeExporter, ModItems.TIN_INGOT, ModItems.TIN_NUGGET, "tin_ingot", "tin_nugget");
        createDustFromIngotRecipe(recipeExporter, ModItems.TIN_INGOT, ModItems.TIN_DUST, "tin_dust_recipe");

        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.MISC, ModBlocks.TIN_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_TIN, RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK);

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, TIN_SMELTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 200, "tin_ingot_from_smelting");
        offerBlasting(recipeExporter, TIN_SMELTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 100, "tin_ingot_from_blasting");

        //Tools
        sword(recipeExporter, ModItems.TIN_SWORD, ModItems.TIN_INGOT, "tin_sword_recipe");
        axe(recipeExporter, ModItems.TIN_AXE, ModItems.TIN_INGOT, "tin_axe_recipe");
        pickaxe(recipeExporter, ModItems.TIN_PICKAXE, ModItems.TIN_INGOT, "tin_pickaxe_recipe");
        shovel(recipeExporter, ModItems.TIN_SHOVEL, ModItems.TIN_INGOT, "tin_shovel_recipe");
        hoe(recipeExporter, ModItems.TIN_HOE, ModItems.TIN_INGOT, "tin_hoe_recipe");

        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.TIN_INGOT) .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.TIN_INGOT) .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.TIN_INGOT) .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.TIN_INGOT) .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "tin_boots_recipe"));

        /* =========================================================
         *  ██████╗ ██████╗ ██████╗ ██████╗ ███████╗██████╗
         * ██╔════╝██╔═══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
         * ██║     ██║   ██║██████╔╝██████╔╝█████╗  ██████╔╝
         * ██║     ██║   ██║██╔═══╝ ██╔═══╝ ██╔══╝  ██╔══██╗
         * ╚██████╗╚██████╔╝██║     ██║     ███████╗██║  ██║
         *  ╚═════╝ ╚═════╝ ╚═╝     ╚═╝     ╚══════╝╚═╝  ╚═╝
         * ========================================================= */

        offerNuggetAndIngotRecipes(recipeExporter, Items.COPPER_INGOT, ModItems.COPPER_NUGGET, "copper_ingot", "copper_nugget");
        createDustFromIngotRecipe(recipeExporter, Items.COPPER_INGOT, ModItems.COPPER_DUST, "copper_dust_recipe");

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, LIGNITE_SMELTABLE, RecipeCategory.MISC, ModItems.LIGNITE_COAL, 0.25f, 200, "lignite_from_smelting");
        offerBlasting(recipeExporter, LIGNITE_SMELTABLE, RecipeCategory.MISC, ModItems.LIGNITE_COAL, 0.25f, 100, "lignite_from_blasting");

        //Tools
        sword(recipeExporter, ModItems.COPPER_SWORD, Items.COPPER_INGOT, "copper_sword_recipe");
        axe(recipeExporter, ModItems.COPPER_AXE, Items.COPPER_INGOT, "copper_axe_recipe");
        pickaxe(recipeExporter, ModItems.COPPER_PICKAXE, Items.COPPER_INGOT, "copper_pickaxe_recipe");
        shovel(recipeExporter, ModItems.COPPER_SHOVEL, Items.COPPER_INGOT, "copper_shovel_recipe");
        hoe(recipeExporter, ModItems.COPPER_HOE, Items.COPPER_INGOT, "copper_hoe_recipe");

        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', Items.COPPER_INGOT) .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', Items.COPPER_INGOT) .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.COPPER_INGOT) .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.COPPER_INGOT) .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "copper_boots_recipe"));

        /* =========================================================
         * ██████╗ ██████╗  ██████╗ ███╗   ██╗███████╗███████╗
         * ██╔══██╗██╔══██╗██╔═══██╗████╗  ██║╚══███╔╝██╔════╝
         * ██████╔╝██████╔╝██║   ██║██╔██╗ ██║  ███╔╝ █████╗
         * ██╔══██╗██╔══██╗██║   ██║██║╚██╗██║ ███╔╝  ██╔══╝
         * ██████╔╝██║  ██║╚██████╔╝██║ ╚████║███████╗███████╗
         * ========================================================= */

        offerNuggetAndIngotRecipes(recipeExporter, ModItems.BRONZE_INGOT, ModItems.BRONZE_NUGGET, "bronze_ingot", "bronze_nugget");
        createDustFromIngotRecipe(recipeExporter, ModItems.BRONZE_INGOT, ModItems.BRONZE_DUST, "bronze_dust_recipe");
        // Bronze dust from ingot
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_DUST)
                .pattern("C  ")
                .pattern("B  ")
                .pattern("   ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_dust_from_ingot_recipe"));

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, BRONZE_SMELTABLE, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 200, "bronze_ingot_from_smelting");
        offerBlasting(recipeExporter, BRONZE_SMELTABLE, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 100, "bronze_ingot_from_blasting");

        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.BRONZE_INGOT, RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK);

        //Tools
        sword(recipeExporter, ModItems.BRONZE_SWORD, ModItems.BRONZE_INGOT, "bronze_sword_recipe");
        axe(recipeExporter, ModItems.BRONZE_AXE, ModItems.BRONZE_INGOT, "bronze_axe_recipe");
        pickaxe(recipeExporter, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_INGOT, "bronze_pickaxe_recipe");
        shovel(recipeExporter, ModItems.BRONZE_SHOVEL, ModItems.BRONZE_INGOT, "bronze_shovel_recipe");
        hoe(recipeExporter, ModItems.BRONZE_HOE, ModItems.BRONZE_INGOT, "bronze_hoe_recipe");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOW)
                .pattern("BST")
                .pattern("SBT")
                .pattern("BST")
                .input('S', Items.STICK)
                .input('B', ModItems.BRONZE_INGOT)
                .input('T', Items.STRING).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_bow_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("BSB")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "chisel_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HAMMER)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('D', ModBlocks.BRONZE_BLOCK)
                .input('S', Items.STICK).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_hammer_recipe"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.BRONZE_INGOT) .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_helmet_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.BRONZE_INGOT) .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_chestplate_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BRONZE_INGOT) .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_leggings_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BRONZE_INGOT) .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)) .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "bronze_boots_recipe"));

        /* =========================================================
         *  ██████╗ ███████╗███╗   ███╗██╗██╗   ██╗███╗   ███╗
         * ██╔═══██╗██╔════╝████╗ ████║██║██║   ██║████╗ ████║
         * ██║   ██║███████╗██╔████╔██║██║██║   ██║██╔████╔██║
         * ██║   ██║╚════██║██║╚██╔╝██║██║██║   ██║██║╚██╔╝██║
         * ╚██████╔╝███████║██║ ╚═╝ ██║██║╚██████╔╝██║ ╚═╝ ██║
         *  ╚═════╝ ╚══════╝╚═╝     ╚═╝╚═╝ ╚═════╝ ╚═╝     ╚═╝
         * ========================================================= */

        //Smithing Upgrade
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OSMIUM_UPGRADE_TEMPLATE)
                .pattern("DID")
                .pattern("IUI")
                .pattern("DID")
                .input('D', Blocks.DEEPSLATE)
                .input('I', ModItems.OSMIUM_INGOT)
                .input('U', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_upgrade_template_recipe"));

        offerNuggetAndIngotRecipes(recipeExporter, ModItems.OSMIUM_INGOT, ModItems.OSMIUM_NUGGET, "osmium_ingot", "osmium_nugget");

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, OSMIUM_SMELTABLE, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, 0.25f, 200, "osmium_ingot_from_smelting");
        offerBlasting(recipeExporter, OSMIUM_SMELTABLE, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, 0.25f, 100, "osmium_ingot_from_blasting");

        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.OSMIUM_INGOT, RecipeCategory.MISC, ModBlocks.OSMIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_OSMIUM, RecipeCategory.MISC, ModBlocks.RAW_OSMIUM_BLOCK);

        //Tools
        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_SWORD,
                ModItems.OSMIUM_INGOT, RecipeCategory.TOOLS, ModItems.OSMIUM_SWORD, "osmium_sword_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_AXE,
                ModItems.OSMIUM_INGOT, RecipeCategory.TOOLS, ModItems.OSMIUM_AXE, "osmium_axe_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_PICKAXE,
                ModItems.OSMIUM_INGOT, RecipeCategory.TOOLS, ModItems.OSMIUM_PICKAXE, "osmium_pickaxe_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_SHOVEL,
                ModItems.OSMIUM_INGOT, RecipeCategory.TOOLS, ModItems.OSMIUM_SHOVEL, "osmium_shovel_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_HOE,
                ModItems.OSMIUM_INGOT, RecipeCategory.TOOLS, ModItems.OSMIUM_HOE, "osmium_hoe_smithing");

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OSMIUM_HAMMER)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" B ")
                .input('B', ModItems.OSMIUM_INGOT)
                .input('D', ModBlocks.OSMIUM_BLOCK)
                .input('S', Items.STICK).criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT)).offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_hammer_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OSMIUM_BOW)
                .pattern("BST")
                .pattern("SBT")
                .pattern("BST")
                .input('S', Items.STICK)
                .input('B', ModItems.OSMIUM_INGOT)
                .input('T', Items.STRING).criterion(hasItem(ModItems.OSMIUM_INGOT), conditionsFromItem(ModItems.OSMIUM_INGOT)).offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "osmium_bow_recipe"));

        //Armor
        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_HELMET,
                ModItems.OSMIUM_INGOT, RecipeCategory.COMBAT, ModItems.OSMIUM_HELMET, "osmium_helmet_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_CHESTPLATE,
                ModItems.OSMIUM_INGOT, RecipeCategory.COMBAT, ModItems.OSMIUM_CHESTPLATE, "osmium_chestplate_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_LEGGINGS,
                ModItems.OSMIUM_INGOT, RecipeCategory.COMBAT, ModItems.OSMIUM_LEGGINGS, "osmium_leggings_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.OSMIUM_UPGRADE_TEMPLATE, Items.NETHERITE_BOOTS,
                ModItems.OSMIUM_INGOT, RecipeCategory.COMBAT, ModItems.OSMIUM_BOOTS, "osmium_boots_smithing");
        /* =========================================================
         *  █████╗ ██████╗  █████╗ ███╗   ███╗ █████╗ ███╗   ██╗████████╗██╗██╗   ██╗███╗   ███╗
         * ██╔══██╗██╔══██╗██╔══██╗████╗ ████║██╔══██╗████╗  ██║╚══██╔══╝██║██║   ██║████╗ ████║
         * ███████║██║  ██║███████║██╔████╔██║███████║██╔██╗ ██║   ██║   ██║██║   ██║██╔████╔██║
         * ██╔══██║██║  ██║██╔══██║██║╚██╔╝██║██╔══██║██║╚██╗██║   ██║   ██║██║   ██║██║╚██╔╝██║
         * ██║  ██║██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║██║ ╚████║   ██║   ██║╚██████╔╝██║ ╚═╝ ██║
         * ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝     ╚═╝
         * ========================================================= */

        //Smithing Upgrade
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE)
                .pattern("DID")
                .pattern("IUI")
                .pattern("DID")
                .input('D', Blocks.DEEPSLATE)
                .input('I', ModItems.ADAMANTIUM_INGOT)
                .input('U', ModItems.OSMIUM_UPGRADE_TEMPLATE)
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, "adamantium_upgrade_template_recipe"));
        offerNuggetAndIngotRecipes(recipeExporter, ModItems.ADAMANTIUM_INGOT, ModItems.ADAMANTIUM_NUGGET, "adamantium_ingot", "adamantium_nugget");

        // --- Smelting / Blasting ---
        offerSmelting(recipeExporter, ADAMANTIUM_SMELTABLE, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT, 0.25f, 400, "adamantium_ingot_from_smelting");
        offerBlasting(recipeExporter, ADAMANTIUM_SMELTABLE, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT, 0.25f, 200, "adamantium_ingot_from_blasting");

        // --- Compacting Recipes ---
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT, RecipeCategory.MISC, ModBlocks.ADAMANTIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_ADAMANTIUM, RecipeCategory.MISC, ModBlocks.RAW_ADAMANTIUM_BLOCK);

        //Tools
        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_SWORD,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.TOOLS, ModItems.ADAMANTIUM_SWORD, "adamantium_sword_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_AXE,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.TOOLS, ModItems.ADAMANTIUM_AXE, "adamantium_axe_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_PICKAXE,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.TOOLS, ModItems.ADAMANTIUM_PICKAXE, "adamantium_pickaxe_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_SHOVEL,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.TOOLS, ModItems.ADAMANTIUM_SHOVEL, "adamantium_shovel_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_HOE,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.TOOLS, ModItems.ADAMANTIUM_HOE, "adamantium_hoe_smithing");

        //Armor
        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_HELMET,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.COMBAT, ModItems.ADAMANTIUM_HELMET, "adamantium_helmet_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_CHESTPLATE,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.COMBAT, ModItems.ADAMANTIUM_CHESTPLATE, "adamantium_chestplate_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_LEGGINGS,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.COMBAT, ModItems.ADAMANTIUM_LEGGINGS, "adamantium_leggings_smithing");

        offerSmithingUpgrade(recipeExporter, ModItems.ADAMANTIUM_UPGRADE_TEMPLATE, ModItems.OSMIUM_BOOTS,
                ModItems.ADAMANTIUM_INGOT, RecipeCategory.COMBAT, ModItems.ADAMANTIUM_BOOTS, "adamantium_boots_smithing");
    }

    /* =========================================================
     * ██╗  ██╗███████╗██╗     ██████╗ ███████╗██████╗
     * ██║  ██║██╔════╝██║     ██╔══██╗██╔════╝██╔══██╗
     * ███████║█████╗  ██║     ██████╔╝█████╗  ██████╔╝
     * ██╔══██║██╔══╝  ██║     ██╔═══╝ ██╔══╝  ██╔══██╗
     * ██║  ██║███████╗███████╗██║     ███████╗██║  ██║
     * ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝
     * ========================================================= */
    private void createDustFromIngotRecipe(RecipeExporter recipeExporter, Item ingot, Item dust, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, dust)
                .pattern("C  ")
                .pattern("B  ")
                .pattern("   ")
                .input('B', ingot)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(recipeExporter, Identifier.of(MetalsPlus.MOD_ID, name));
    }
    private void offerSmithingUpgrade(
            RecipeExporter exporter,
            Item template,
            Item base,
            Item addition,
            RecipeCategory category,
            Item result,
            String name
    ) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template),
                        Ingredient.ofItems(base),
                        Ingredient.ofItems(addition),
                        category,
                        result
                )
                .criterion("has_" + addition.getTranslationKey().replace("item.", ""),
                        conditionsFromItem(addition))
                .offerTo(exporter, Identifier.of(MetalsPlus.MOD_ID, name));
    }

    private void offerToolRecipe(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name,
            String row1,
            String row2,
            String row3
    ) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern(row1)
                .pattern(row2)
                .pattern(row3)
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter, Identifier.of(MetalsPlus.MOD_ID, name));
    } private void sword(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name
    ) {
        offerToolRecipe(exporter, result, material, name,
                " B ",
                " B ",
                " S ");
    } private void axe(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name
    ) {
        offerToolRecipe(exporter, result, material, name,
                "BB ",
                "BS ",
                " S ");
    } private void pickaxe(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name
    ) {
        offerToolRecipe(exporter, result, material, name,
                "BBB",
                " S ",
                " S ");
    } private void shovel(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name
    ) {
        offerToolRecipe(exporter, result, material, name,
                " B ",
                " S ",
                " S ");
    } private void hoe(
            RecipeExporter exporter,
            Item result,
            Item material,
            String name
    ) {
        offerToolRecipe(exporter, result, material, name,
                "BB ",
                " S ",
                " S ");
    }

    private void offerNuggetAndIngotRecipes(
            RecipeExporter exporter,
            ItemConvertible ingot,
            ItemConvertible nugget,
            String ingotName,
            String nuggetName
    ) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, nugget, 9)
                .input(ingot)
                .criterion("has_" + ingotName, conditionsFromItem(ingot))
                .offerTo(exporter, Identifier.of(MetalsPlus.MOD_ID, nuggetName + "_from_" + ingotName));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ingot)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', nugget)
                .criterion("has_" + nuggetName, conditionsFromItem(nugget))
                .offerTo(exporter, Identifier.of(MetalsPlus.MOD_ID, ingotName + "_from_" + nuggetName));
    }


}
