package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
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
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        if (EntityHitResult != null) {
            float damage = 20+(amplification*7);
            EntityHitResult.getEntity().hurt(DamageSource.playerAttack((Player) shooter), damage);
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        float damage = 20+(amplification*7);
        player.hurt(DamageSource.playerAttack(player), damage);
    }
}
