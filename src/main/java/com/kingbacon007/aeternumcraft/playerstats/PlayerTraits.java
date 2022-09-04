package com.kingbacon007.aeternumcraft.playerstats;

import net.minecraft.nbt.CompoundTag;


public class PlayerTraits {
    private int MAGICAL_WISDOM_LEVEL = 0;
    private int AGILITY_LEVEL = 0;
    private int AIM_LEVEL = 0;
    private int STRENGTH_LEVEL = 0;
    private int DEFENSE_LEVEL = 0;
    private int LUCK_LEVEL = 0;
    private int SPEED_LEVEL = 0;
    private int EARTH_LEVEL = 0;
    private int AIR_LEVEL = 0;
    private int FIRE_LEVEL = 0;
    private int WATER_LEVEL = 0;
    private int SPACE_LEVEL = 0;
    private int MAGIC_LEVEL = 0;
    private int ENERGY_LEVEL = 0;
    //level max values
    public int MAGICAL_WISDOM_MAX = 25;
    public int AGILITY_MAX = 25;
    public int AIM_MAX = 25;
    public int STRENGTH_MAX = 25;
    public int DEFENSE_MAX = 25;
    public int LUCK_MAX = 25;
    public int SPEED_MAX = 25;
    public int EARTH_MAX = 50;
    public int AIR_MAX = 50;
    public int FIRE_MAX = 50;
    public int WATER_MAX = 50;
    public int SPACE_MAX = 50;
    public int MAGIC_MAX = 50;
    public int ENERGY_MAX = 50;

    //load, save, and copy the players stats

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("magical_wisdom_level", MAGICAL_WISDOM_LEVEL);
        nbt.putInt("agility_level", AGILITY_LEVEL);
        nbt.putInt("aim_level", AIM_LEVEL);
        nbt.putInt("strength_level", STRENGTH_LEVEL);
        nbt.putInt("defense_level", DEFENSE_LEVEL);
        nbt.putInt("luck_level", LUCK_LEVEL);
        nbt.putInt("speed_level", SPEED_LEVEL);
        nbt.putInt("earth_level", EARTH_LEVEL);
        nbt.putInt("air_level", AIR_LEVEL);
        nbt.putInt("fire_level", FIRE_LEVEL);
        nbt.putInt("water_level", WATER_LEVEL);
        nbt.putInt("space_level", SPACE_LEVEL);
        nbt.putInt("magic_level", MAGIC_LEVEL);
        nbt.putInt("energy_level", ENERGY_LEVEL);
    }

    public void getNBTData(CompoundTag nbt) {
        MAGICAL_WISDOM_LEVEL = nbt.getInt("magical_wisdom_level");
        AGILITY_LEVEL = nbt.getInt("agility_level");
        AIM_LEVEL = nbt.getInt("aim_level");
        STRENGTH_LEVEL = nbt.getInt("strength_level");
        DEFENSE_LEVEL = nbt.getInt("defense_level");
        LUCK_LEVEL = nbt.getInt("luck_level");
        SPEED_LEVEL = nbt.getInt("speed_level");
        EARTH_LEVEL = nbt.getInt("earth_level");
        AIR_LEVEL = nbt.getInt("air_level");
        FIRE_LEVEL = nbt.getInt("fire_level");
        WATER_LEVEL = nbt.getInt("water_level");
        SPACE_LEVEL = nbt.getInt("space_level");
        MAGIC_LEVEL = nbt.getInt("magic_level");
        ENERGY_LEVEL = nbt.getInt("energy_level");
    }

    public void copyFrom(PlayerTraits source) {
        this.MAGICAL_WISDOM_LEVEL = source.MAGICAL_WISDOM_LEVEL;
        this.AGILITY_LEVEL = source.AGILITY_LEVEL;
        this.AIM_LEVEL = source.AIM_LEVEL;
        this.STRENGTH_LEVEL = source.STRENGTH_LEVEL;
        this.DEFENSE_LEVEL = source.DEFENSE_LEVEL;
        this.LUCK_LEVEL = source.LUCK_LEVEL;
        this.SPEED_LEVEL = source.SPEED_LEVEL;
        this.EARTH_LEVEL = source.EARTH_LEVEL;
        this.AIR_LEVEL = source.AIR_LEVEL;
        this.FIRE_LEVEL = source.FIRE_LEVEL;
        this.WATER_LEVEL = source.WATER_LEVEL;
        this.SPACE_LEVEL = source.SPACE_LEVEL;
        this.MAGIC_LEVEL = source.MAGIC_LEVEL;
        this.ENERGY_LEVEL = source.ENERGY_LEVEL;
    }
// method that increments the trait's level, can be positive or negative to increase or decrease.
    public void incrementTraitLevel(String traitName, int increment) {
        switch (traitName) {
            case "magical_wisdom": MAGICAL_WISDOM_LEVEL += increment;
                break;
            case "agility": AGILITY_LEVEL += increment;
                break;
            case "aim": AIM_LEVEL += increment;
                break;
            case "strength": STRENGTH_LEVEL += increment;
                break;
            case "defense": DEFENSE_LEVEL += increment;
                break;
            case "luck": LUCK_LEVEL += increment;
                break;
            case "speed": SPEED_LEVEL += increment;
                break;
            case "earth": EARTH_LEVEL += increment;
                break;
            case "air": AIR_LEVEL += increment;
                break;
            case "fire": FIRE_LEVEL += increment;
                break;
            case "water": WATER_LEVEL += increment;
                break;
            case "space": SPACE_LEVEL += increment;
                break;
            case "magic": MAGIC_LEVEL += increment;
                break;
            case "energy": ENERGY_LEVEL += increment;
                break;
            default: System.out.println("Error: trait string provided in increment trait method does not match a trait.");
        }
    }
// returns the level of the trait specified.
    public int getTraitLevel(String trait) {
        switch (trait) {
            case "magical_wisdom": return MAGICAL_WISDOM_LEVEL;
            case "agility": return AGILITY_LEVEL;
            case "aim": return AIM_LEVEL;
            case "strength": return STRENGTH_LEVEL;
            case "defense": return DEFENSE_LEVEL;
            case "luck": return LUCK_LEVEL;
            case "speed": return SPEED_LEVEL;
            case "earth": return EARTH_LEVEL;
            case "air": return AIR_LEVEL;
            case "fire": return FIRE_LEVEL;
            case "water": return WATER_LEVEL;
            case "space": return SPACE_LEVEL;
            case "magic": return MAGIC_LEVEL;
            case "energy": return ENERGY_LEVEL;
            default: return 0;
        }
    }
}
