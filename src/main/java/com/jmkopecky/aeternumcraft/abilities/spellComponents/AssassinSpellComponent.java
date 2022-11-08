package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class AssassinSpellComponent extends DefaultSpellComponent {

    String componentName = "assassinshift";
    int amplification;



    public AssassinSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        if (targetEntity != null) {
            int duration = 200+(amplification*100);
            int effectScale = 1+amplification;
            targetEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, duration, effectScale+1));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(EffectsRegister.ManaExhaustion.get(), duration, effectScale));
        }
    }
}
