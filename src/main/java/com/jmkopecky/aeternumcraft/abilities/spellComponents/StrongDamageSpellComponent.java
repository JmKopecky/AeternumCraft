package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class StrongDamageSpellComponent extends DefaultSpellComponent {

    String componentName = "weakdamage";
    int amplification;


    public StrongDamageSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        if (targetEntity != null) {
            float damage = 20+(amplification*7);
            targetEntity.hurt(DamageSource.playerAttack(caster), damage);
        }
    }
}
