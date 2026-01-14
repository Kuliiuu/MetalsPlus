package net.kuliiuu.metalsplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kuliiuu.metalsplus.block.ModBlocks;
import net.kuliiuu.metalsplus.block.custom.BlackberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.BlueberryBushBlock;
import net.kuliiuu.metalsplus.block.custom.RaspberryBushBlock;
import net.kuliiuu.metalsplus.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.OSMIUM_BLOCK);
        addDrop(ModBlocks.ADAMANTIUM_BLOCK);
        addDrop(ModBlocks.LIGNITE_COAL_BLOCK);
        addDrop(ModBlocks.RAW_TIN_BLOCK);
        addDrop(ModBlocks.RAW_ADAMANTIUM_BLOCK);
        addDrop(ModBlocks.RAW_OSMIUM_BLOCK);
        addDrop(ModBlocks.TIN_BOOSTER);

        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));

        addDrop(ModBlocks.OSMIUM_ORE, oreDrops(ModBlocks.OSMIUM_ORE, ModItems.RAW_OSMIUM));
        addDrop(ModBlocks.DEEPSLATE_OSMIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_OSMIUM_ORE, ModItems.RAW_OSMIUM));

        addDrop(ModBlocks.ADAMANTIUM_ORE, oreDrops(ModBlocks.ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM));
        addDrop(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM));

        addDrop(ModBlocks.LIGNITE_COAL_ORE, multipleOreDrops(ModBlocks.LIGNITE_COAL_ORE, ModItems.LIGNITE_COAL, 1, 3));
        addDrop(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_LIGNITE_COAL_ORE, ModItems.LIGNITE_COAL, 1, 3));

        this.addDrop(ModBlocks.BLUEBERRY_BUSH,
                block -> this.applyExplosionDecay(block, LootTable.builder()
                        .pool(LootPool.builder().
                                conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 3))
                                )
                                .with(ItemEntry.builder(ModItems.BLUEBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 2))
                                )
                                .with(ItemEntry.builder(ModItems.BLUEBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        this.addDrop(ModBlocks.RASPBERRY_BUSH,
                block -> this.applyExplosionDecay(block, LootTable.builder()
                        .pool(LootPool.builder().
                                conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.RASPBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(RaspberryBushBlock.AGE, 3))
                                )
                                .with(ItemEntry.builder(ModItems.RASPBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.RASPBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(RaspberryBushBlock.AGE, 2))
                                )
                                .with(ItemEntry.builder(ModItems.RASPBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        this.addDrop(ModBlocks.BLACKBERRY_BUSH,
                block -> this.applyExplosionDecay(block, LootTable.builder()
                        .pool(LootPool.builder().
                                conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLACKBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlackberryBushBlock.AGE, 3))
                                )
                                .with(ItemEntry.builder(ModItems.BLACKBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLACKBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlackberryBushBlock.AGE, 2))
                                )
                                .with(ItemEntry.builder(ModItems.BLACKBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
    }


    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
