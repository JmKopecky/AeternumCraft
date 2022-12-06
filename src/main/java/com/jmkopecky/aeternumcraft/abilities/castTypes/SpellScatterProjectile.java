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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.Random;

public class SpellScatterProjectile extends SpellProjectile {


    int initialBounceCount;

    public SpellScatterProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public SpellScatterProjectile(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
    }

    public SpellScatterProjectile(EntityType<? extends AbstractArrow> p_36717_, Level level, LivingEntity shooter, int initialBounceCount) {
        super(p_36717_, level, shooter);
        this.initialBounceCount = initialBounceCount;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        //level.sendParticles()
        if (this.getOwner() != null && this.getOwner() instanceof Player shooter) {
            shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {
                shooterAbility.getAbilityChain(shooterAbility.getCurrentSlot()).runComponents(shooter, (LivingEntity) hitResult.getEntity(), null);
            });
        } else {
            Logger.log("Shooter is null or not a player in entityhitresult", Logger.WARNING);
        }
        //Create multiple projectiles, decrement the bouncecount by one, shoot them in random directions.
        if (this.getOwner() != null) {
            Random random = new Random();
            int projectileCount = random.nextInt(3, 7);
            for (int i = 0; i < projectileCount; i++) {
                if (initialBounceCount > 0) {
                    SpellScatterProjectile projectile = new SpellScatterProjectile(EntityRegister.SPELL_SCATTER_PROJECTILE.get(), this.getLevel(), (LivingEntity) this.getOwner(), initialBounceCount - 1);
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
                shooterAbility.getAbilityChain(shooterAbility.getCurrentSlot()).runComponents(shooter, null, hitResult.getBlockPos());
            });
        } else {
            Logger.log("Shooter is null or not a player in blockhitresult", Logger.WARNING);
        }
        if (this.getOwner() != null) {
            Random random = new Random();
            int projectileCount = random.nextInt(3, 7);
            if  (initialBounceCount >0) {
                for (int i = 0; i < projectileCount; i++) {
                    SpellScatterProjectile projectile = new SpellScatterProjectile(EntityRegister.SPELL_SCATTER_PROJECTILE.get(), this.getLevel(), (LivingEntity) this.getOwner(), initialBounceCount - 1);
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

