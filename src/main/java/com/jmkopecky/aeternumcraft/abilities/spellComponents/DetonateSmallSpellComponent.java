package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

public class DetonateSmallSpellComponent extends DefaultSpellComponent {

    String componentName = "DetonateSmall";
    int amplification;


    public DetonateSmallSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    @Override
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult entityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        float explosionRadius = 2+amplification;
        if (entityHitResult != null) {
            shooter.level.explode(null, entityHitResult.getEntity().getX(), entityHitResult.getEntity().getY(), entityHitResult.getEntity().getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
        } else if (blockHitResult != null) {
            shooter.level.explode(null, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        float explosionRadius = 3+amplification;
        player.level.explode(null, player.getX(), player.getY(), player.getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
    }
}
