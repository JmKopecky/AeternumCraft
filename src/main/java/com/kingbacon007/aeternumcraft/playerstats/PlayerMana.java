package com.kingbacon007.aeternumcraft.playerstats;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {
    private float MANA_COUNT = 0f;
    private final float MIN_MANA = 0f;
    private int MAX_MANA = 100;
    private float MANA_REGEN = 10f;

    //getter methods for variables
    public float getManaCount() {
        return MANA_COUNT;
    }
    public float getMIN_MANA() {
        return MIN_MANA;
    }
    public int getMAX_MANA() {
        return MAX_MANA;
    }
    public float getMANA_REGEN() {
        return MANA_REGEN;
    }

    //setter methods for variables

    public void setMANA_COUNT(float MANA_COUNT) {
        this.MANA_COUNT = MANA_COUNT;
    }
    public void setMAX_MANA(int MAX_MANA) {
        this.MAX_MANA = MAX_MANA;
    }
    public void setMANA_REGEN(float MANA_REGEN) {
        this.MANA_REGEN = MANA_REGEN;
    }

    //handling mana use and deduction

    public void deductMANA_COUNT(float deduction) {
        if (MANA_COUNT-deduction <= MIN_MANA) {
            MANA_COUNT = 0.0f;
        } else {
            MANA_COUNT -= deduction;
        }
    }

    public void regenMANA_COUNT(float regenAmount) {
        if (MANA_COUNT+(MANA_REGEN/regenAmount) > MAX_MANA) {
            this.MANA_COUNT = MAX_MANA;
        } else {
            this.MANA_COUNT+=(MANA_REGEN/regenAmount);
        }
    }

    //Required methods

    public void copyFrom(PlayerMana source) {
        this.MANA_COUNT = source.MANA_COUNT;
        this.MANA_REGEN = source.MANA_REGEN;
        this.MAX_MANA = source.MAX_MANA;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putFloat("mana_count", MANA_COUNT);
        nbt.putInt("mana_max", MAX_MANA);
        nbt.putFloat("mana_regen", MANA_REGEN);
    }

    public void loadNBTData(CompoundTag nbt) {
        MANA_COUNT = nbt.getFloat("mana_count");
        MAX_MANA = nbt.getInt("mana_max");
        MANA_REGEN = nbt.getFloat("mana_regen");
    }
}
