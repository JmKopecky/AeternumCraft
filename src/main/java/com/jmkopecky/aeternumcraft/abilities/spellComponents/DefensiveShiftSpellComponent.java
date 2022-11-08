package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class DefensiveShiftSpellComponent extends DefaultSpellComponent {

    String componentName = "defensiveshift";
    int amplification;


    public DefensiveShiftSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        if (targetEntity != null) {
            int duration = 200+(amplification*100);
            int effectScale = 1+amplification;
            targetEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, effectScale+1));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
        }
    }
}
