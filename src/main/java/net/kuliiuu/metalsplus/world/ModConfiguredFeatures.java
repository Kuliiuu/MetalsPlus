package net.kuliiuu.metalsplus.world;

import net.kuliiuu.metalsplus.MetalsPlus;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.block.custom.BlackberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.BlueberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.RaspberryBushBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIGNITE_COAL_ORE_KEY = registerKey("lignite_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OSMIUM_ORE_KEY = registerKey("osmium_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RASPBERRY_BUSH_KEY = registerKey("raspberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH_KEY = registerKey("blackberry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldLigniteCoalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.LIGNITE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldOsmiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.OSMIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_OSMIUM_ORE.getDefaultState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 6));
        register(context, LIGNITE_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldLigniteCoalOres, 10));
        register(context, OSMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldOsmiumOres, 3));

        register(context,BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueberryBushBlock.AGE,3))),
                        List.of(Blocks.GRASS_BLOCK)
                ));

        register(context,BLACKBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKBERRY_BUSH.getDefaultState().with(BlackberryBushBlock.AGE,3))),
                        List.of(Blocks.GRASS_BLOCK)
                ));

        register(context,RASPBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RASPBERRY_BUSH.getDefaultState().with(RaspberryBushBlock.AGE,3))),
                        List.of(Blocks.GRASS_BLOCK)
                ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MetalsPlus.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}