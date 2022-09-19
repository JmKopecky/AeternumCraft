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
    //Elemental trait max values
    public final int EARTH_MAX = 50;
    public final int AIR_MAX = 50;
    public final int FIRE_MAX = 50;
    public final int WATER_MAX = 50;
    public final int SPACE_MAX = 50;
    public final int MAGIC_MAX = 50;
    public final int ENERGY_MAX = 50;

    //load, save, and copy the players stats


    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("magical_wisdom_level", MAGICAL_WISDOM_LEVEL);
        nbt.putInt("agility_level", AGILITY_LEVEL);
        nbt.putInt("aim_level", AIM_LEVEL);
        nbt.putInt("strength_level", STRENGTH_LEVEL);
        nbt.putInt("defense_level", DEFENSE_LEVEL);
        nbt.putInt("luck_level", LUCK_LEVEL);
        nbt.putInt("speed_level", SPEED_LEVEL);
        //elemental traits
        nbt.putInt("earth_level", EARTH_LEVEL);
        nbt.putInt("air_level", AIR_LEVEL);
        nbt.putInt("fire_level", FIRE_LEVEL);
        nbt.putInt("water_level", WATER_LEVEL);
        nbt.putInt("space_level", SPACE_LEVEL);
        nbt.putInt("magic_level", MAGIC_LEVEL);
        nbt.putInt("energy_level", ENERGY_LEVEL);
    }

    public void loadNBTData(CompoundTag nbt) {
        MAGICAL_WISDOM_LEVEL = nbt.getInt("magical_wisdom_level");
        AGILITY_LEVEL = nbt.getInt("agility_level");
        AIM_LEVEL = nbt.getInt("aim_level");
        STRENGTH_LEVEL = nbt.getInt("strength_level");
        DEFENSE_LEVEL = nbt.getInt("defense_level");
        LUCK_LEVEL = nbt.getInt("luck_level");
        SPEED_LEVEL = nbt.getInt("speed_level");
        //elemental traits
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
        //elemental traits
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
            case "magical_wisdom": {
                if (MAGICAL_WISDOM_LEVEL+increment <= MAGICAL_WISDOM_MAX && MAGICAL_WISDOM_LEVEL+increment >=0) {
                    MAGICAL_WISDOM_LEVEL = MAGICAL_WISDOM_LEVEL + increment;
                }
            }
                break;
            case "agility": {
                if (AGILITY_LEVEL+increment <= AGILITY_MAX && AGILITY_LEVEL+increment >=0) {
                    AGILITY_LEVEL = AGILITY_LEVEL + increment;
                }
            }
                break;
            case "aim": {
                if (AIM_LEVEL+increment <= AIM_MAX && AIM_LEVEL+increment >=0) {
                    AIM_LEVEL = AIM_LEVEL + increment;
                }
            }
                break;
            case "strength": {
                if (STRENGTH_LEVEL+increment <= STRENGTH_MAX && STRENGTH_LEVEL+increment >=0) {
                    STRENGTH_LEVEL = STRENGTH_LEVEL + increment;
                }
            }
                break;
            case "defense": {
                if (DEFENSE_LEVEL+increment <= DEFENSE_MAX && DEFENSE_LEVEL+increment >=0) {
                    DEFENSE_LEVEL = DEFENSE_LEVEL + increment;
                }
            }
                break;
            case "luck": {
                if (LUCK_LEVEL+increment <= LUCK_MAX && LUCK_LEVEL+increment >=0) {
                   LUCK_LEVEL = LUCK_LEVEL + increment;
                }
            }
                break;
            case "speed": {
                if (SPEED_LEVEL+increment <= SPEED_MAX && SPEED_LEVEL+increment >=0) {
                    SPEED_LEVEL = SPEED_LEVEL + increment;
                }
            }
                break;
            case "earth": {
                if (EARTH_LEVEL+increment <= EARTH_MAX && EARTH_LEVEL+increment >=0) {
                    EARTH_LEVEL = EARTH_LEVEL + increment;
                }
            }
                break;
            case "air": {
                if (AIR_LEVEL+increment <= AIR_MAX && AIR_LEVEL+increment >=0) {
                    AIR_LEVEL = AIR_LEVEL + increment;
                }
            }
                break;
            case "fire": {
                if (FIRE_LEVEL+increment <= FIRE_MAX && FIRE_LEVEL+increment >=0) {
                    FIRE_LEVEL = FIRE_LEVEL + increment;
                }
            }
                break;
            case "water": {
                if (WATER_LEVEL+increment <= WATER_MAX && WATER_LEVEL+increment >=0) {
                    WATER_LEVEL = WATER_LEVEL + increment;
                }
            }
                break;
            case "space": {
                if (SPACE_LEVEL+increment <= SPACE_MAX && SPACE_LEVEL+increment >=0) {
                    SPACE_LEVEL = SPACE_LEVEL + increment;
                }
            }
                break;
            case "magic": {
                if (MAGIC_LEVEL+increment <= MAGIC_MAX && MAGIC_LEVEL+increment >=0) {
                    MAGIC_LEVEL = MAGIC_LEVEL + increment;
                }
            }
                break;
            case "energy": {
                if (ENERGY_LEVEL+increment <= ENERGY_MAX && ENERGY_LEVEL+increment >=0) {
                    ENERGY_LEVEL = ENERGY_LEVEL + increment;
                }
            }
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
    public float getBonusFromTrait(float effectBase, String traitName, String operationName) {
        int traitLevel;
        int traitMax;
        float result = 0;

        switch (traitName) {
            case "magical_wisdom": {
                traitLevel = this.MAGICAL_WISDOM_LEVEL;
                traitMax = this.MAGICAL_WISDOM_MAX;
            }
                break;
            case "agility": {
                traitLevel = this.AGILITY_LEVEL;
                traitMax = this.AGILITY_MAX;
            }
                break;
            case "aim": {
                traitLevel = this.AIM_LEVEL;
                traitMax = this.AIM_MAX;
            }
                break;
            case "strength": {
                traitLevel = this.STRENGTH_LEVEL;
                traitMax = this.STRENGTH_MAX;
            }
                break;
            case "defense": {
                traitLevel = this.DEFENSE_LEVEL;
                traitMax = this.DEFENSE_MAX;
            }
                break;
            case "luck": {
                traitLevel = this.LUCK_LEVEL;
                traitMax = this.LUCK_MAX;
            }
                break;
            case "speed": {
                traitLevel = this.SPEED_LEVEL;
                traitMax = this.SPEED_MAX;
            }
                break;
            case "earth": {
                traitLevel = EARTH_LEVEL;
                traitMax = EARTH_MAX;
            }
                break;
            case "air": {
                traitLevel = AIR_LEVEL;
                traitMax = AIR_MAX;
            }
                break;
            case "fire": {
                traitLevel = FIRE_LEVEL;
                traitMax = FIRE_MAX;
            }
                break;
            case "water": {
                traitLevel = WATER_LEVEL;
                traitMax = WATER_MAX;
            }
                break;
            case "space": {
                traitLevel = SPACE_LEVEL;
                traitMax = SPACE_MAX;
            };
                break;
            case "magic": {
                traitLevel = MAGIC_LEVEL;
                traitMax = MAGIC_MAX;
            }
                break;
            case "energy": {
                traitLevel = ENERGY_LEVEL;
                traitMax = ENERGY_MAX;
            }
                break;
            default: {
                traitLevel = 0;
                traitMax = 0;
            }
        }
        switch (operationName) {
            case "damageBonus": {
                result = ((traitLevel/traitMax)+1)*effectBase;
                return result;
            }
            case "manaMaxBonus": {
                result = effectBase + (traitLevel * 15);
                return result;
            }
            case "manaRegenBonus": {
                result = effectBase + (traitLevel * 5);
                return result;
            }
            default: return result;
        }
    }
}
