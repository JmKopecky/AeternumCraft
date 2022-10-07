package com.kingbacon007.aeternumcraft.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class DrainHealthEffect extends MobEffect {
    protected DrainHealthEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    //This effect drains the targets current health by 10% x amplification.
    int tickCount = 0;
    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (tickCount >= 20) {
            float damageReductionAmplifier = (float) (0.1 * amplifier);
            float damage = livingEntity.getHealth()*damageReductionAmplifier;
            livingEntity.hurt(DamageSource.MAGIC, damage);
            tickCount = 0;
        } else {
            tickCount = tickCount +1;
        }

        if (livingEntity.getEffect(this).getDuration()==2) {
            tickCount = 0;
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
