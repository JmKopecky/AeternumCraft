package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class CrippleSpellComponent extends DefaultSpellComponent {

    String componentName = "cripple";
    int amplification;



    public CrippleSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        if (targetEntity != null) {
            float damage = 5 +(amplification*5);
            int duration = 200+(amplification*200);
            int effectScale = 1+amplification;
            targetEntity.hurt(DamageSource.playerAttack(caster), damage);
            targetEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
            targetEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
        }
    }
}
