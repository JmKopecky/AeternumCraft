package com.jmkopecky.aeternumcraft.enchantment;

import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

public class StasisPulseEnchantment extends Enchantment {
    public StasisPulseEnchantment(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity defender, Entity attacker, int level) {
        Random randomGen = new Random();
        if ((randomGen.nextFloat()*10)<= (0.5*level)) {
            int duration = 10*level;
            //Proc on attacker
            ((LivingEntity) attacker).addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration+20, 1));
            Level defenderLevel = defender.level;
            double radius = 3+level;
            List<LivingEntity> targets = defenderLevel.getEntitiesOfClass(LivingEntity.class, new AABB(defender.getX()-radius, defender.getY()-radius, defender.getZ()-radius, defender.getX()+radius, defender.getY()+radius, defender.getZ()+radius));
            for (LivingEntity target:targets) {
                if (target != defender) {
                    target.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, 1));
                }
            }
        }
        super.doPostHurt(defender, attacker, level);
    }
}
