package com.jmkopecky.aeternumcraft.abilities.spellComponents;

import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;

import javax.annotation.Nullable;

public class DetonateSmallSpellComponent extends DefaultSpellComponent {

    String componentName = "DetonateSmall";
    int amplification;


    public DetonateSmallSpellComponent(int amplification) {
        this.amplification = amplification;
    }


    @Override
    public void triggerSpell(Player caster, @Nullable LivingEntity targetEntity, @Nullable BlockPos blockPos) {
        float explosionRadius = 2+amplification;
        if (targetEntity != null) {
            targetEntity.getLevel().explode(null, targetEntity.getX(), targetEntity.getY(), targetEntity.getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
        } else if (blockPos != null) {
            caster.getLevel().explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
        }
    }
}
