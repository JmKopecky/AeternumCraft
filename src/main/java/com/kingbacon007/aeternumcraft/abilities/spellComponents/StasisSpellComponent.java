package com.kingbacon007.aeternumcraft.abilities.spellComponents;

import com.kingbacon007.aeternumcraft.abilities.DefaultSpellComponent;
import com.kingbacon007.aeternumcraft.effects.EffectsRegister;
import com.kingbacon007.aeternumcraft.effects.StasisEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class StasisSpellComponent extends DefaultSpellComponent {

    String componentName = "stasis";
    int amplification;

    public StasisSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult entityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        int duration = 200+(amplification*40);

        if (entityHitResult != null) {
            LivingEntity target = (LivingEntity) entityHitResult.getEntity();
            target.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, 1));
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        int duration = 200+(amplification*40);

        player.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, 1));
    }
}
