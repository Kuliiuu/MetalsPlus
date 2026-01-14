package net.kuliiuu.metalsplus.world;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> LIGNITE_COAL_ORE_PLACED_KEY = registerKey("lignite_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> OSMIUM_ORE_PLACED_KEY = registerKey("osmium_ore_placed");
    public static final RegistryKey<PlacedFeature> ADAMANTIUM_ORE_PLACED_KEY = registerKey("adamantium_ore_placed");

    public static final RegistryKey<PlacedFeature> RASPBERRY_BUSH_PLACED_KEY = registerKey("raspberry_bush_placed");
    public static final RegistryKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");
    public static final RegistryKey<PlacedFeature> BLACKBERRY_BUSH_PLACED_KEY = registerKey("blackberry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(120))));
        register(context, LIGNITE_COAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIGNITE_COAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(13,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(280))));
        register(context, ADAMANTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ADAMANTIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(-50))));

        register(context, OSMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OSMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(-38))));

        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(52), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLACKBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLACKBERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(52), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, RASPBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RASPBERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(52), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MetalsPlus.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
