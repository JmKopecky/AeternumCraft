package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class EscapistShiftSpellComponent extends DefaultSpellComponent {

    String componentName = "escapistshift";
    int amplification;


    public EscapistShiftSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        if (targetEntity != null) {
            int duration = 100+(amplification*50);
            int effectScale = 1+amplification;
            targetEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, duration, effectScale+1));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale+1));
        }
    }
}
