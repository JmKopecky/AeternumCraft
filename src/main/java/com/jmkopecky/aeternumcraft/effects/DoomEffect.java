package com.jmkopecky.aeternumcraft.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class DoomEffect extends MobEffect {

    protected DoomEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.getEffect(this).getDuration()==5) {
            if (livingEntity.getMaxHealth()<50) {
                if (livingEntity.getHealth() > (livingEntity.getMaxHealth() / (2*amplifier))) {
                    livingEntity.hurt(DamageSource.MAGIC, livingEntity.getHealth()-(livingEntity.getMaxHealth() / (2*amplifier)));
                }
            } else {
                if (livingEntity.getHealth()>((livingEntity.getMaxHealth()/20)*amplifier)) {
                    livingEntity.hurt(DamageSource.MAGIC, ((livingEntity.getMaxHealth()/20)*amplifier));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
