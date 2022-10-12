package com.jmkopecky.aeternumcraft.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class SmiteStrikeEnchantment extends Enchantment {
    public SmiteStrikeEnchantment(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
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
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        Random random = new Random();
        float chanceToStrike = (float) (0.25 + (level * 0.1));
        if (!attacker.level.isClientSide) {
            ServerLevel world = (ServerLevel) attacker.level;
            BlockPos pos = target.blockPosition();
            for (int i = 0; i < level; i++) {
                if (random.nextFloat()<chanceToStrike) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
                }
            }

        }


        super.doPostAttack(attacker, target, level);
    }
}
