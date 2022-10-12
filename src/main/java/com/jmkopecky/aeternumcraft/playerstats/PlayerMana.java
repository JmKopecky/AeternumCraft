package com.jmkopecky.aeternumcraft.playerstats;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {

    private float MANA_COUNT = 0F;
    private final float MIN_MANA = 0F;
    private float MAX_MANA = 100F;
    private float MANA_REGEN = 10F;

    private final float defaultMAXMANA = 100F;
    private final float defaultMANAREGEN = 10F;

    //getter methods for variables
    public float getManaCount() {
        return this.MANA_COUNT;
    }
    public float getMIN_MANA() {
        return this.MIN_MANA;
    }
    public float getMAX_MANA() {
        return this.MAX_MANA;
    }
    public float getMANA_REGEN() {
        return this.MANA_REGEN;
    }

    public float getDefaultMAXMANA() {
        return this.defaultMAXMANA;
    }
    public float getDefaultMANAREGEN() {
        return this.defaultMANAREGEN;
    }

    //setter methods for variables

    public void setMANA_COUNT(float MANA_COUNT) {
        this.MANA_COUNT = MANA_COUNT;
    }
    public void setMAX_MANA(float MAX_MANA) {
        this.MAX_MANA = MAX_MANA;
    }
    public void setMANA_REGEN(float MANA_REGEN) {
        this.MANA_REGEN = MANA_REGEN;
    }

    //handling mana use and deduction

    public void deductMANA_COUNT(float deduction) {
        if (this.MANA_COUNT-deduction <= this.MIN_MANA) {
            this.MANA_COUNT = 0.0f;
        } else {
            this.MANA_COUNT -= deduction;
        }
    }

    public void regenMANA_COUNT(float regenAmount, float bonusRegen) {
        float regenFinalValue = (regenAmount/2) + (bonusRegen/2);
        if (this.MANA_COUNT+regenFinalValue > this.MAX_MANA) {
            this.MANA_COUNT = this.MAX_MANA;
        } else if (this.MANA_COUNT+regenFinalValue <0) {
            this.MANA_COUNT = 0;
        } else {
            this.MANA_COUNT+=regenFinalValue;
        }
    }

    //Required methods

    public void copyFrom(PlayerMana source) {
        this.MANA_COUNT = source.MANA_COUNT;
        this.MANA_REGEN = source.MANA_REGEN;
        this.MAX_MANA = source.MAX_MANA;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putFloat("mana_count", this.MANA_COUNT);
        nbt.putFloat("mana_max", this.MAX_MANA);
        nbt.putFloat("mana_regen", this.MANA_REGEN);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.MANA_COUNT = nbt.getFloat("mana_count");
        this.MAX_MANA = nbt.getFloat("mana_max");
        this.MANA_REGEN = nbt.getFloat("mana_regen");
    }

}
