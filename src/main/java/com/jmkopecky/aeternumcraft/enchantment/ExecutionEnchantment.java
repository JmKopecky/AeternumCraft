package com.jmkopecky.aeternumcraft.enchantment;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class ExecutionEnchantment extends Enchantment {
    public ExecutionEnchantment(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        LivingEntity livingTarget = (LivingEntity) target;
        float healthPercent = livingTarget.getHealth()/livingTarget.getMaxHealth();
        if (healthPercent < 0.25 + (level * 0.05)) {
            float attackerWeaponDamage = attacker.getItemInHand(InteractionHand.MAIN_HAND).getDamageValue();
            float lowerDamageRange = (float) (attackerWeaponDamage * 0.25);
            float higherDamageRange = (float) (attackerWeaponDamage * 0.75);
            Random random = new Random();
            float damage = random.nextFloat(lowerDamageRange, higherDamageRange);
            livingTarget.hurtTime = 0;
            livingTarget.hurt(DamageSource.mobAttack(attacker), damage);
        }
    }
}
