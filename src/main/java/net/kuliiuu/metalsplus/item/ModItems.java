package net.kuliiuu.metalsplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MetalsPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MetalsPlus.LOGGER.info("Registering Mod Items - " + MetalsPlus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COPPER_NUGGET);
            entries.add(TIN_NUGGET);
        });
        }
}
