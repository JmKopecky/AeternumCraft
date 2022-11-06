package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class StasisSpellComponent extends DefaultSpellComponent {

    static String componentName = "stasis";
    int amplification;



    public StasisSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult entityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        int duration = 200+(amplification*40);

        if (entityHitResult != null) {
            LivingEntity target = (LivingEntity) entityHitResult.getEntity();
            target.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, amplification+1));
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        int duration = 200+(amplification*40);

        player.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, amplification+1));
    }
}
