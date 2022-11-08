package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class StasisExtendedSpellComponent extends DefaultSpellComponent {

    static String componentName = "extendedstasis";
    int amplification;


    public StasisExtendedSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        int duration = 600+(amplification*100);
        if (targetEntity != null) {
            targetEntity.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, amplification+1));
        }
    }

}
