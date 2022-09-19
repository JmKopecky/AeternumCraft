package com.kingbacon007.aeternumcraft.abilities.spellComponents;

import com.kingbacon007.aeternumcraft.abilities.DefaultSpellComponent;
import com.kingbacon007.aeternumcraft.effects.EffectsRegister;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
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
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        float damage = 5 +(amplification*5);
        int duration = 200+(amplification*200);
        int effectScale = 1+amplification;
        if (EntityHitResult!=null) {
            LivingEntity target = (LivingEntity) EntityHitResult.getEntity();
            target.hurt(DamageSource.playerAttack((Player) shooter), damage);
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        float damage = 5 +(amplification*5);
        int duration = 200+(amplification*200);
        int effectScale = 1+amplification;
        player.hurt(DamageSource.playerAttack(player), damage);
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
    }
}
