package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class DoomSpellComponent extends DefaultSpellComponent {

    String componentName = "doom";
    int amplification;

    public DoomSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        if (EntityHitResult != null) {
            LivingEntity target = (LivingEntity) EntityHitResult.getEntity();
            target.addEffect(new MobEffectInstance(EffectsRegister.DOOM.get(), 200, amplification+1));
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        player.addEffect(new MobEffectInstance(EffectsRegister.DOOM.get(), 200, amplification+1));
    }
}
