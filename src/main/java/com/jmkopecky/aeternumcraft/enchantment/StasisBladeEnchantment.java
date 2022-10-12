package com.jmkopecky.aeternumcraft.enchantment;

import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class StasisBladeEnchantment extends Enchantment {
    public StasisBladeEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... applicableSlots) {
        super(rarity, category, applicableSlots);
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
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        LivingEntity livingTarget = (LivingEntity) target;
        int duration = level * 10;
        Random random = new Random();
        if (random.nextFloat()>0.75/level) {
            livingTarget.addEffect(new MobEffectInstance(EffectsRegister.STASIS.get(), duration, 1));
        }
        super.doPostAttack(attacker, target, level);
    }
}
