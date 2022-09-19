package com.kingbacon007.aeternumcraft.abilities.spellComponents;

import com.kingbacon007.aeternumcraft.abilities.DefaultSpellComponent;
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
        float explosionRadius = 3+amplification;
        if (entityHitResult != null) {
            Explosion explosion = new Explosion(shooter.level, shooter, entityHitResult.getEntity().getX(), entityHitResult.getEntity().getY(), entityHitResult.getEntity().getZ(), explosionRadius, false, Explosion.BlockInteraction.BREAK);
            explosion.explode();
            explosion.finalizeExplosion(true);
            explosion.clearToBlow();
        } else if (blockHitResult != null) {
            Explosion explosion = new Explosion(shooter.level, shooter, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ(), explosionRadius, false, Explosion.BlockInteraction.BREAK);
            explosion.explode();
            explosion.finalizeExplosion(true);
            explosion.clearToBlow();
        }
    }

    @Override
    public void triggerAbilityComponentSelf(Player player) {
        float explosionRadius = 3+amplification;
        Explosion explosion = new Explosion(player.level, player, player.getX(), player.getY(), player.getZ(), explosionRadius, false, Explosion.BlockInteraction.BREAK);
        explosion.explode();
        explosion.finalizeExplosion(true);
        explosion.clearToBlow();
    }
}
