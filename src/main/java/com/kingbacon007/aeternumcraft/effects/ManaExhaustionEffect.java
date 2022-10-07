package com.kingbacon007.aeternumcraft.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ManaExhaustionEffect extends MobEffect {
    protected ManaExhaustionEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    //effect that does not have any functionality in itself, but is checked for in the functionality of the mana regen system
    //strong values can result in a mana draining effect for the duration of the effect.
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
