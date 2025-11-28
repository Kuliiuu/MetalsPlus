package net.kuliiuu.metalsplus;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.item.ModItemGroups;
import net.kuliiuu.metalsplus.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetalsPlus implements ModInitializer {
	public static final String MOD_ID = "metalsplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        FuelRegistry.INSTANCE.add(ModItems.LIGNITE_COAL, 1200);
        FuelRegistry.INSTANCE.add(ModBlocks.LIGNITE_COAL_BLOCK, 12000);
	}
}