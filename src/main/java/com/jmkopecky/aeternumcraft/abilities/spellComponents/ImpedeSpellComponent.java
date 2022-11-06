package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class ImpedeSpellComponent extends DefaultSpellComponent {

    String componentName = "impede";
    int amplification;


    public ImpedeSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        int duration = 200+(amplification*200);
        int effectStrength = 1+amplification;
        if (EntityHitResult != null) {
            LivingEntity target = (LivingEntity) EntityHitResult.getEntity();
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectStrength));
        }

    }
    @Override
    public void triggerAbilityComponentSelf(Player player) {
        int duration = 200+(amplification*200);
        int effectStrength = 1+amplification;
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, effectStrength));
    }
}
