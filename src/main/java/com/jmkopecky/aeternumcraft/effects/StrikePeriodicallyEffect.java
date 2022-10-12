package com.jmkopecky.aeternumcraft.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;

import java.util.Random;

public class StrikePeriodicallyEffect extends MobEffect {
    protected StrikePeriodicallyEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }
    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level.isClientSide) {
            if (livingEntity.getEffect(this).getDuration() % 50 == 0) {
                Random random = new Random();
                if (random.nextFloat() >= (0.75/amplifier)) {
                    ServerLevel world = (ServerLevel) livingEntity.getLevel();
                    BlockPos position = livingEntity.blockPosition();
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, position, MobSpawnType.TRIGGERED, true, true);
                }
                if (livingEntity.getEffect(this).getDuration() == 5) {
                    if (amplifier >= 3) {
                        ServerLevel world = (ServerLevel) livingEntity.getLevel();
                        BlockPos position = livingEntity.blockPosition();
                        for (int i = 0; i <= (amplifier*2); i++) {
                            EntityType.LIGHTNING_BOLT.spawn(world, null, null, position, MobSpawnType.TRIGGERED, true, true);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
