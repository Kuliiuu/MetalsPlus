package net.kuliiuu.metalsplus.item;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item BRONZE_DUST = registerItem("bronze_dust", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new Item.Settings()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MetalsPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MetalsPlus.LOGGER.info("Registering Mod Items - " + MetalsPlus.MOD_ID);
    }
}
