package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
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
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        if (EntityHitResult != null) {
            int duration = 200+(amplification*100);
            int effectScale = 1+amplification;
            LivingEntity target = (LivingEntity) EntityHitResult.getEntity();
            target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, effectScale));
            target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, effectScale+1));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        int duration = 200+(amplification*100);
        int effectScale = 1+amplification;
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, effectScale));
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, effectScale+1));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectScale));
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, effectScale));
    }
}
