package net.kuliiuu.metalsplus.item;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.custom.ChiselItem;
import net.kuliiuu.metalsplus.item.custom.HammerItem;
import net.kuliiuu.metalsplus.item.custom.ModFoodComponents;
import net.kuliiuu.metalsplus.item.custom.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    /*
     ██████╗ ██████╗ ██████╗ ██████╗ ███████╗██████╗
    ██╔════╝██╔═══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
    ██║     ██║   ██║██████╔╝██████╔╝█████╗  ██████╔╝
    ██║     ██║   ██║██╔═══╝ ██╔═══╝ ██╔══╝  ██╔══██╗
    ╚██████╗╚██████╔╝██║     ██║     ███████╗██║  ██║
    */

    /* ############################
    #            ITEMS            #
    ############################ */
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new Item.Settings()));

    /* ############################
    #            ARMOR            #
    ############################ */
    public static final Item COPPER_HELMET = registerCopperArmor("copper_helmet", ArmorItem.Type.HELMET);
    public static final Item COPPER_CHESTPLATE = registerCopperArmor("copper_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final Item COPPER_LEGGINGS = registerCopperArmor("copper_leggings", ArmorItem.Type.LEGGINGS);
    public static final Item COPPER_BOOTS = registerCopperArmor("copper_boots", ArmorItem.Type.BOOTS);

    /* ############################
    #            TOOLS            #
    ############################ */
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,3, -2.4f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER,6, -3.2f))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER,1, -2.8f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER,1.5f, -3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER,0, -3))));

    /*
    ████████╗██╗███╗   ██╗
    ╚══██╔══╝██║████╗  ██║
       ██║   ██║██╔██╗ ██║
       ██║   ██║██║╚██╗██║
       ██║   ██║██║ ╚████║
    */

   /* ############################
    #            ITEMS            #
    ############################ */
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));

    /* ############################
    #            ARMOR            #
    ############################ */
    public static final Item TIN_HELMET =
            registerTinArmor("tin_helmet", ArmorItem.Type.HELMET);
    public static final Item TIN_CHESTPLATE = registerTinArmor("tin_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final Item TIN_LEGGINGS = registerTinArmor("tin_leggings", ArmorItem.Type.LEGGINGS);
    public static final Item TIN_BOOTS = registerTinArmor("tin_boots", ArmorItem.Type.BOOTS);

    /* ############################
    #            TOOLS            #
    ############################ */
    public static final Item TIN_SWORD = registerItem("tin_sword",
            new SwordItem(ModToolMaterials.TIN, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TIN,3, -2.4f))));
    public static final Item TIN_AXE = registerItem("tin_axe",
            new AxeItem(ModToolMaterials.TIN, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TIN,6, -3.2f))));
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe",
            new PickaxeItem(ModToolMaterials.TIN, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TIN,1, -2.8f))));
    public static final Item TIN_SHOVEL = registerItem("tin_shovel",
            new ShovelItem(ModToolMaterials.TIN, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TIN,1.5f, -3f))));
    public static final Item TIN_HOE = registerItem("tin_hoe",
            new HoeItem(ModToolMaterials.TIN, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TIN,0, -3))));

    /*
    ██████╗ ██████╗  ██████╗ ███╗   ██╗███████╗███████╗
    ██╔══██╗██╔══██╗██╔═══██╗████╗  ██║╚══███╔╝██╔════╝
    ██████╔╝██████╔╝██║   ██║██╔██╗ ██║  ███╔╝ █████╗
    ██╔══██╗██╔══██╗██║   ██║██║╚██╗██║ ███╔╝  ██╔══╝
    ██████╔╝██║  ██║╚██████╔╝██║ ╚████║███████╗███████╗
    */

    /* ############################
    #            ITEMS            #
    ############################ */
    public static final Item BRONZE_DUST = registerItem("bronze_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_BOW = registerItem("bronze_bow", new BowItem(new Item.Settings().maxDamage(250)));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(50)));

    /* ############################
    #            ARMOR            #
    ############################ */
    public static final Item BRONZE_HELMET = registerBronzeArmor("bronze_helmet", ArmorItem.Type.HELMET);
    public static final Item BRONZE_CHESTPLATE = registerBronzeArmor("bronze_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final Item BRONZE_LEGGINGS = registerBronzeArmor("bronze_leggings", ArmorItem.Type.LEGGINGS);
    public static final Item BRONZE_BOOTS = registerBronzeArmor("bronze_boots", ArmorItem.Type.BOOTS);

    /* ############################
    #            TOOLS            #
    ############################ */
    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE,3, -2.4f))));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new AxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE,6, -3.2f))));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new PickaxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE,1, -2.8f))));
    public static final Item BRONZE_HAMMER = registerItem("bronze_hammer",
            new HammerItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE,3, -3.5f))));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE,1.5f, -3f))));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new HoeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE,0, -3))));


    /*
     ██████╗ ███████╗███╗   ███╗██╗██╗   ██╗███╗   ███╗
    ██╔═══██╗██╔════╝████╗ ████║██║██║   ██║████╗ ████║
    ██║   ██║███████╗██╔████╔██║██║██║   ██║██╔████╔██║
    ██║   ██║╚════██║██║╚██╔╝██║██║██║   ██║██║╚██╔╝██║
    ╚██████╔╝███████║██║ ╚═╝ ██║██║╚██████╔╝██║ ╚═╝ ██║
    */

    /* ############################
    #            ITEMS            #
    ############################ */
    public static final Item OSMIUM_BOW = registerItem("osmium_bow", new BowItem(new Item.Settings().maxDamage(1500)));
    public static final Item OSMIUM_INGOT = registerItem("osmium_ingot", new Item(new Item.Settings()));
    public static final Item OSMIUM_NUGGET = registerItem("osmium_nugget", new Item(new Item.Settings()));
    public static final Item RAW_OSMIUM = registerItem("raw_osmium", new Item(new Item.Settings()));

    /* ############################
    #            ARMOR            #
    ############################ */
    public static final Item OSMIUM_HELMET = registerOsmiumArmor("osmium_helmet", ArmorItem.Type.HELMET);
    public static final Item OSMIUM_CHESTPLATE = registerOsmiumArmor("osmium_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final Item OSMIUM_LEGGINGS = registerOsmiumArmor("osmium_leggings", ArmorItem.Type.LEGGINGS);
    public static final Item OSMIUM_BOOTS = registerOsmiumArmor("osmium_boots", ArmorItem.Type.BOOTS);

    /* ############################
    #            TOOLS            #
    ############################ */
    public static final Item OSMIUM_SWORD = registerItem("osmium_sword",
            new SwordItem(ModToolMaterials.OSMIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OSMIUM,3, -2.4f))));
    public static final Item OSMIUM_AXE = registerItem("osmium_axe",
            new AxeItem(ModToolMaterials.OSMIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.OSMIUM,6, -3.2f))));
    public static final Item OSMIUM_PICKAXE = registerItem("osmium_pickaxe",
            new PickaxeItem(ModToolMaterials.OSMIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.OSMIUM,1, -2.8f))));
    public static final Item OSMIUM_HAMMER = registerItem("osmium_hammer",
            new HammerItem(ModToolMaterials.OSMIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.OSMIUM,3, -3.5f))));
    public static final Item OSMIUM_SHOVEL = registerItem("osmium_shovel",
            new ShovelItem(ModToolMaterials.OSMIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.OSMIUM,1.5f, -3f))));
    public static final Item OSMIUM_HOE = registerItem("osmium_hoe",
            new HoeItem(ModToolMaterials.OSMIUM, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.OSMIUM,0, -3))));

    /*
     █████╗ ██████╗  █████╗ ███╗   ███╗ █████╗ ███╗   ██╗████████╗██╗██╗   ██╗███╗   ███╗
    ██╔══██╗██╔══██╗██╔══██╗████╗ ████║██╔══██╗████╗  ██║╚══██╔══╝██║██║   ██║████╗ ████║
    ███████║██║  ██║███████║██╔████╔██║███████║██╔██╗ ██║   ██║   ██║██║   ██║██╔████╔██║
    ██╔══██║██║  ██║██╔══██║██║╚██╔╝██║██╔══██║██║╚██╗██║   ██║   ██║██║   ██║██║╚██╔╝██║
    ██║  ██║██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║██║ ╚████║   ██║   ██║╚██████╔╝██║ ╚═╝ ██║
    ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝     ╚═╝
    */

    /* ############################
    #            ITEMS            #
    ############################ */
    public static final Item ADAMANTIUM_INGOT = registerItem("adamantium_ingot", new Item(new Item.Settings()));
    public static final Item ADAMANTIUM_NUGGET = registerItem("adamantium_nugget", new Item(new Item.Settings()));
    public static final Item RAW_ADAMANTIUM = registerItem("raw_adamantium", new Item(new Item.Settings()));

    /* ############################
    #            ARMOR            #
    ############################ */
    public static final Item ADAMANTIUM_HELMET = registerAdamantiumArmor("adamantium_helmet", ArmorItem.Type.HELMET);
    public static final Item ADAMANTIUM_CHESTPLATE = registerAdamantiumArmor("adamantium_chestplate", ArmorItem.Type.CHESTPLATE);
    public static final Item ADAMANTIUM_LEGGINGS = registerAdamantiumArmor("adamantium_leggings", ArmorItem.Type.LEGGINGS);
    public static final Item ADAMANTIUM_BOOTS = registerAdamantiumArmor("adamantium_boots", ArmorItem.Type.BOOTS);

    /* ############################
    #            TOOLS            #
    ############################ */
    public static final Item ADAMANTIUM_SWORD = registerItem("adamantium_sword",
            new SwordItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,3, -2.4f))));
    public static final Item ADAMANTIUM_AXE = registerItem("adamantium_axe",
            new AxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,6, -3.2f))));
    public static final Item ADAMANTIUM_PICKAXE = registerItem("adamantium_pickaxe",
            new PickaxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,1, -2.8f))));
    public static final Item ADAMANTIUM_SHOVEL = registerItem("adamantium_shovel",
            new ShovelItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,1.5f, -3f))));
    public static final Item ADAMANTIUM_HOE = registerItem("adamantium_hoe",
            new HoeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.OSMIUM,0, -3))));


    /*
    ███╗   ███╗██╗███████╗ ██████╗
    ████╗ ████║██║██╔════╝██╔════╝
    ██╔████╔██║██║███████╗██║
    ██║╚██╔╝██║██║╚════██║██║
    ██║ ╚═╝ ██║██║███████║╚██████╗
    */

    public static final Item LIGNITE_COAL = registerItem("lignite_coal", new Item(new Item.Settings()));

    public static final Item BLUEBERRIES = registerItem("blueberries",
            new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLUEBERRIES)));
    public static final Item BLACKBERRIES = registerItem("blackberries",
            new AliasedBlockItem(ModBlocks.BLACKBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLACKBERRIES)));
    public static final Item RASPBERRIES = registerItem("raspberries",
            new AliasedBlockItem(ModBlocks.RASPBERRY_BUSH, new Item.Settings().food(ModFoodComponents.RASPBERRIES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MetalsPlus.MOD_ID, name), item);
    }

    private static Item registerCopperArmor(String name, ArmorItem.Type type) {
        return registerItem(name,
                new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, type, new Item.Settings().maxDamage(type.getMaxDamage(10)))
        );
    }

    private static Item registerBronzeArmor(String name, ArmorItem.Type type) {
        return registerItem(name,
                new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, type, new Item.Settings().maxDamage(type.getMaxDamage(12)))
        );
    }

    private static Item registerOsmiumArmor(String name, ArmorItem.Type type) {
        return registerItem(name,
                new ArmorItem(ModArmorMaterials.OSMIUM_ARMOR_MATERIAL, type, new Item.Settings().maxDamage(type.getMaxDamage(55)))
        );
    }

    private static Item registerAdamantiumArmor(String name, ArmorItem.Type type) {
        return registerItem(name,
                new ArmorItem(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, type, new Item.Settings().maxDamage(type.getMaxDamage(86)))
        );
    }

    private static Item registerTinArmor(String name, ArmorItem.Type type) {
        return registerItem(name,
                new ArmorItem(ModArmorMaterials.TIN_ARMOR_MATERIAL, type, new Item.Settings().maxDamage(type.getMaxDamage(8)))
        );
    }

    public static void registerModItems() {
        MetalsPlus.LOGGER.info("Registering Mod Items - " + MetalsPlus.MOD_ID);
    }
}
