package com.jmkopecky.aeternumcraft.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.HashMap;

public class DefaultSpellComponent {
    HashMap<String, Double> defaultDamageValues = new HashMap<String, Double>();
    double manaBaseCost;
    int amplification;

    public DefaultSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    public DefaultSpellComponent() {
    }

    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        //New method for casting spells
    }


}
