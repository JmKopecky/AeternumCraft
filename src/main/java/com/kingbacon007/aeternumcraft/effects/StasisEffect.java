package com.kingbacon007.aeternumcraft.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class StasisEffect extends MobEffect {

    protected StasisEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level.isClientSide) {
            livingEntity.teleportTo(livingEntity.getX(),livingEntity.getY(),livingEntity.getZ());
            livingEntity.setDeltaMovement(0, 0, 0);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
