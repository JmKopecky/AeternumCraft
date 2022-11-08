package com.jmkopecky.aeternumcraft.abilities;

import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import com.jmkopecky.aeternumcraft.util.Logger;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.List;

public class SpellBurstProjectile extends SpellProjectile {
    public SpellBurstProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public SpellBurstProjectile(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
    }

    public SpellBurstProjectile(EntityType<? extends AbstractArrow> p_36717_, Level level, LivingEntity shooter) {
        super(p_36717_, level, shooter);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);


        //level.sendParticles()
        if (this.getOwner() != null && this.getOwner() instanceof Player shooter) {
            shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {
                double radius = 4.0;
                List<LivingEntity> targets = shooter.getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(
                        shooter.getX()-radius, shooter.getY()-radius, shooter.getZ()-radius,
                        shooter.getX()+radius, shooter.getY()+radius, shooter.getZ()+radius));
                for (LivingEntity target:targets) {

                }
            });
        } else {
            Logger.log("Shooter is null or not a player in entityhitresult", Logger.WARNING);
        }
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (this.getOwner() != null && this.getOwner() instanceof Player shooter) {
            shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {

            });
        } else {
            Logger.log("Shooter is null or not a player in blockhitresult", Logger.WARNING);
        }
        this.discard();
    }

}
