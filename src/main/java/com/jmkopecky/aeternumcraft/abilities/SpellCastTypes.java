package com.jmkopecky.aeternumcraft.abilities;

import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellBurstProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellScatterBurstProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellScatterProjectile;
import com.jmkopecky.aeternumcraft.entity.EntityRegister;
import com.jmkopecky.aeternumcraft.util.Logger;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public enum SpellCastTypes {

    PROJECTILE("projectile", "Projectile", 1.0F),
    SELF("self", "Self", 0.75F),
    BURSTPROJECTILE("burstprojectile", "Burst Projectile", 1.25F),
    SCATTERPROJECTILE("scatterprojectile", "Scatter Projectile", 1.4F),
    SCATTERBURSTPROJECTILE("scatterburstprojectile", "Scatter Burst Projectile", 1.75F),
    LASER("laser", "Laser", 1.75F);


    private float manaCostMultiplier;
    private String mainName;
    private String displayName;

    SpellCastTypes(String mainName, String displayName, float manaCostMultiplier) {
        this.manaCostMultiplier = manaCostMultiplier;
        this.mainName = mainName;
        this.displayName = displayName;
    }

    public float getManaCostMultiplier() {
        return this.manaCostMultiplier;
    }

    public String getMainName() {
        return this.mainName;
    }
    public String getDisplayName() {
        return this.displayName;
    }

    public static SpellCastTypes resolveSpellCastTypeFromName(String name) {
        return SpellCastTypes.valueOf(name.toUpperCase());
    }

    public static void castSpell(Player caster, SpellCastTypes type, AbilityComponentDataType slot, @Nullable int scatterCount) {
        switch (type) {
            case SELF -> {
                slot.runComponents(caster, null, null);
            }
            case PROJECTILE -> {
                SpellProjectile spell = new SpellProjectile(EntityRegister.SPELL_PROJECTILE.get(), caster.level, caster);
                spell.shootFromRotation(caster, caster.getXRot(), caster.getYRot(), 0.0F, 4F, 0.2F);
                caster.level.addFreshEntity(spell);
            }
            case BURSTPROJECTILE -> {
                SpellBurstProjectile spell = new SpellBurstProjectile(EntityRegister.SPELL_BURST_PROJECTILE.get(), caster.level, caster);
                spell.shootFromRotation(caster, caster.getXRot(), caster.getYRot(), 0.0F, 3.6F, 0.3F);
                caster.level.addFreshEntity(spell);
            }
            case SCATTERPROJECTILE -> {
                SpellScatterProjectile spell = new SpellScatterProjectile(EntityRegister.SPELL_SCATTER_PROJECTILE.get(), caster.level, caster, scatterCount);
                spell.shootFromRotation(caster, caster.getXRot(), caster.getYRot(), 0.0F, 3.6F, 0.5F);
                caster.level.addFreshEntity(spell);
            }
            case SCATTERBURSTPROJECTILE -> {
                SpellScatterBurstProjectile spell = new SpellScatterBurstProjectile(EntityRegister.SPELL_SCATTER_BURST_PROJECTILE.get(), caster.level, caster, scatterCount);
                spell.shootFromRotation(caster, caster.getXRot(), caster.getYRot(), 0.0F, 3.4F, 0.8F);
                caster.level.addFreshEntity(spell);
            }
            case LASER -> {
                //Do the laser spell attack
            }
            default -> Logger.log("Tried to cast a spell of an unknown spell type", Logger.WARNING);
        }
    }
}
