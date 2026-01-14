package net.kuliiuu.metalsplus.item;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> BRONZE_ARMOR_MATERIAL = registerArmorMaterials("bronze",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MetalsPlus.MOD_ID, "bronze"))), 0.2f,0));

    public static final RegistryEntry<ArmorMaterial> TIN_ARMOR_MATERIAL = registerArmorMaterials("tin",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 3);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.TIN_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MetalsPlus.MOD_ID, "tin"))), 0,0));

    public static final RegistryEntry<ArmorMaterial> COPPER_ARMOR_MATERIAL = registerArmorMaterials("copper",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 3);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MetalsPlus.MOD_ID, "copper"))), 0,0));

    public static final RegistryEntry<ArmorMaterial> OSMIUM_ARMOR_MATERIAL = registerArmorMaterials("osmium",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 14);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.OSMIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MetalsPlus.MOD_ID, "osmium"))), 4.2f,0.15f));

    public static final RegistryEntry<ArmorMaterial> ADAMANTIUM_ARMOR_MATERIAL = registerArmorMaterials("adamantium",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 7);
                map.put(ArmorItem.Type.LEGGINGS, 10);
                map.put(ArmorItem.Type.CHESTPLATE, 12);
                map.put(ArmorItem.Type.HELMET, 7);
                map.put(ArmorItem.Type.BODY, 17);
            }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MetalsPlus.MOD_ID, "adamantium"))), 5f,0.2f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterials(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MetalsPlus.MOD_ID, name), material.get());
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.ofVanilla(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.ofVanilla(id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}
