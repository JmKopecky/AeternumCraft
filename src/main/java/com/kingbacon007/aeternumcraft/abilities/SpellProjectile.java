package com.kingbacon007.aeternumcraft.abilities;


import com.kingbacon007.aeternumcraft.playerstats.PlayerAbilityProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class SpellProjectile extends AbstractArrow {

    LivingEntity shooter;
    public SpellProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public SpellProjectile(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
    }

    public SpellProjectile(EntityType<? extends AbstractArrow> p_36717_, LivingEntity shooter, Level p_36719_) {
        super(p_36717_, shooter, p_36719_);
        this.shooter = (LivingEntity) getOwner();
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        //run all code on the abilityComponentChain.
        shooter.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(shooterAbility -> {
            shooterAbility.getAbilityChain(shooterAbility.getCurrentSlot()).runAllComponentsProjectile(hitResult, shooter);
        });
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
