package net.kuliiuu.metalsplus.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN),
                    Map.entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES),
                    Map.entry(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS),
                    Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.MOSSY_COBBLESTONE, Blocks.COBBLESTONE),
                    Map.entry(Blocks.MOSSY_STONE_BRICKS, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.COBBLESTONE_SLAB),
                    Map.entry(Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.COBBLESTONE_STAIRS),
                    Map.entry(Blocks.MOSSY_COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL),
                    Map.entry(Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.STONE_BRICK_SLAB),
                    Map.entry(Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.STONE_BRICK_STAIRS),
                    Map.entry(Blocks.MOSSY_STONE_BRICK_WALL, Blocks.STONE_BRICK_WALL),
                    Map.entry(Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_STONE_BRICKS),
                    Map.entry(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS)
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()), item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }
        else{
            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_PACKED_MUD_BREAK, SoundCategory.BLOCKS);
        }

        return ActionResult.SUCCESS;
    }
}
