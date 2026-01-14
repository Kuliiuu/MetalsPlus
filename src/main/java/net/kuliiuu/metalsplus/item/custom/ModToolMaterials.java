package net.kuliiuu.metalsplus.item.custom;

import com.google.common.base.Suppliers;
import net.kuliiuu.metalsplus.item.ModItems;
import net.kuliiuu.metalsplus.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    TIN(ModTags.Blocks.INCORRECT_FOR_TIN_TOOL, 140, 6.5F, 1.0F, 9, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 190, 3.0F, 1.0F, 22, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    OSMIUM(ModTags.Blocks.INCORRECT_FOR_OSMIUM_TOOL, 3045, 10.0F, 5.0F, 20, () -> Ingredient.ofItems(ModItems.OSMIUM_INGOT)),
    ADAMANTIUM(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOL, 5420, 12.0F, 6.5F, 40, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT)),
    BRONZE(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL, 225, 5.0F, 1.5F, 14, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
