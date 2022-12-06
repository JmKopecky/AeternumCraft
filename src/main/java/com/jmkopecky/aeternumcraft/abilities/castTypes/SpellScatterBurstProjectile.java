package com.jmkopecky.aeternumcraft.abilities.castTypes;


import com.jmkopecky.aeternumcraft.entity.EntityRegister;
import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import com.jmkopecky.aeternumcraft.util.Logger;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;
import java.util.Random;

public class SpellScatterBurstProjectile extends SpellProjectile {


    int initialBounceCount;

    public SpellScatterBurstProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public SpellScatterBurstProjectile(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
    }

    public SpellScatterBurstProjectile(EntityType<? extends AbstractArrow> p_36717_, Level level, LivingEntity shooter, int initialBounceCount) {
        super(p_36717_, level, shooter);
        this.initialBounceCount = initialBounceCount;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        //level.sendParticles()
        if (this.getOwner() != null && this.getOwner() instanceof Player shooter) {
            shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {
                double radius = 4.0;
                List<LivingEntity> targets = hitResult.getEntity().getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(
                        hitResult.getEntity().getX()-radius, hitResult.getEntity().getY()-radius, hitResult.getEntity().getZ()-radius,
                        hitResult.getEntity().getX()+radius, hitResult.getEntity().getY()+radius, hitResult.getEntity().getZ()+radius));
                if (!targets.isEmpty()) {
                    for (LivingEntity target:targets) {
                        shooterAbility.getAbilityChain(shooterAbility.getCurrentSlot()).runComponents(shooter, target, null);
                    }
                }});
        } else {
            Logger.log("Shooter is null or not a player in entityhitresult", Logger.WARNING);
        }
        //Create multiple projectiles, decrement the bouncecount by one, shoot them in random directions.
        if (this.getOwner() != null) {
            Random random = new Random();
            int projectileCount = random.nextInt(3, 7);
            for (int i = 0; i < projectileCount; i++) {
                if (initialBounceCount > 0) {
                    SpellScatterBurstProjectile projectile = new SpellScatterBurstProjectile(EntityRegister.SPELL_SCATTER_BURST_PROJECTILE.get(), this.getLevel(), (LivingEntity) this.getOwner(), initialBounceCount - 1);
                    projectile.shootFromRotation(this.getOwner(), random.nextFloat(-180, 180), random.nextFloat(-180, 180), random.nextFloat(-180, 180), 2.5F, 0.9F);
                    this.getLevel().addFreshEntity(projectile);
                }
            }
        }
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        if (this.getOwner() != null && this.getOwner() instanceof Player shooter) {
            shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {
                double radius = 4.0;
                List<LivingEntity> targets = shooter.getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(
                        hitResult.getBlockPos().getX()-radius, hitResult.getBlockPos().getY()-radius, hitResult.getBlockPos().getZ()-radius,
                        hitResult.getBlockPos().getX()+radius, hitResult.getBlockPos().getY()+radius, hitResult.getBlockPos().getZ()+radius));
                if (!targets.isEmpty()) {
                    for (LivingEntity target:targets) {
                        shooterAbility.getAbilityChain(shooterAbility.getCurrentSlot()).runComponents(shooter, target, null);
                    }
                }});
        } else {
            Logger.log("Shooter is null or not a player in blockhitresult", Logger.WARNING);
        }
        if (this.getOwner() != null) {
            Logger.log(String.valueOf(initialBounceCount), Logger.DEBUG);
            Random random = new Random();
            int projectileCount = random.nextInt(3, 7);
            if  (initialBounceCount >0) {
                for (int i = 0; i < projectileCount; i++) {
                    SpellScatterBurstProjectile projectile = new SpellScatterBurstProjectile(EntityRegister.SPELL_SCATTER_BURST_PROJECTILE.get(), this.getLevel(), (LivingEntity) this.getOwner(), initialBounceCount - 1);
                    projectile.setPos(this.getX(), this.getY(), this.getZ());
                    projectile.shootFromRotation(this.getOwner(), random.nextFloat(-180, 180), random.nextFloat(-180, 180), random.nextFloat(-180, 180), 2.5F, 0.9F);
                    this.getLevel().addFreshEntity(projectile);
                }
            }
        }
        this.discard();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}

