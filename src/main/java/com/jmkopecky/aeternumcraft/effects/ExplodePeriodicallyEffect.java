package com.jmkopecky.aeternumcraft.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;

import java.util.Random;

public class ExplodePeriodicallyEffect extends MobEffect {
    protected ExplodePeriodicallyEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level.isClientSide) {
            ServerLevel world = (ServerLevel) livingEntity.getLevel();
            if (livingEntity.getEffect(this).getDuration() % 100 == 0) {
                Random random = new Random();
                if (random.nextFloat() >= (0.90/amplifier)) {
                    float damage = (float) (1.0 + amplifier);
                    boolean doesCauseFire;
                    if (amplifier >= 4) {
                        doesCauseFire = true;
                    } else {
                        doesCauseFire = false;
                    }
                    world.explode(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), damage, doesCauseFire, Explosion.BlockInteraction.BREAK);
                }
                if (livingEntity.getEffect(this).getDuration() == 5) {
                    if (amplifier >= 4) {
                        float damage = (float) (6.0 + amplifier);
                        boolean doesCauseFire = true;
                        world.explode(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), damage, doesCauseFire, Explosion.BlockInteraction.BREAK);
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
