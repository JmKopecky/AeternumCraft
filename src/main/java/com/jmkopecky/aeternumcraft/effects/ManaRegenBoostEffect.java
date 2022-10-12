package com.jmkopecky.aeternumcraft.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ManaRegenBoostEffect extends MobEffect {
    protected ManaRegenBoostEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    //this effect does nothing on itself, instead it is checked for in the mana regen system.
    //this effect increases the amount of mana that gets regenerated each time that we attempt to regenerate mana.
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
