package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider {
    public ModRegistryDataGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup, Entries entries) {
        entries.addAll(lookup.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return "MetalsPlus Dynamic Registry Data";
    }
}
