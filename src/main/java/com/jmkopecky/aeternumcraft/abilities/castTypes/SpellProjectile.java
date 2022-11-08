package com.jmkopecky.aeternumcraft.abilities.castTypes;


import ca.weblite.objc.Client;
import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.particle.ModParticles;
import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import com.jmkopecky.aeternumcraft.util.Logger;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class SpellProjectile extends AbstractArrow {

    public SpellProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public SpellProjectile(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
    }

    public SpellProjectile(EntityType<? extends AbstractArrow> p_36717_, Level level, LivingEntity shooter) {
        super(p_36717_, shooter, level);
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

