package net.kuliiuu.metalsplus.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class TinBooster extends Block {

    private final Map<ServerPlayerEntity, Integer> lastEffectTick = new HashMap<>();

    public TinBooster(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (!world.isClient && entity instanceof ServerPlayerEntity player) {

            if (world instanceof ServerWorld serverWorld) {
                int currentTick = (int) serverWorld.getTime();
                int lastTick = lastEffectTick.getOrDefault(player, -100);

                if (currentTick - lastTick >= 80) {

                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1800, 0, false, true));

                    for (int i = 0; i < 10; i++) {
                        double offsetX = (serverWorld.random.nextDouble() - 0.5) * 0.8;
                        double offsetY = serverWorld.random.nextDouble() * 0.5 + 0.5;
                        double offsetZ = (serverWorld.random.nextDouble() - 0.5) * 0.8;

                        serverWorld.spawnParticles(
                                ParticleTypes.HAPPY_VILLAGER,
                                player.getX() + offsetX,
                                player.getY() + offsetY,
                                player.getZ() + offsetZ,
                                1, 0, 0, 0, 0
                        );
                    }

                    lastEffectTick.put(player, currentTick);
                }
            }
        }
    }
}
