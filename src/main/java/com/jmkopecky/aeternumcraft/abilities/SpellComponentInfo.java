package com.jmkopecky.aeternumcraft.abilities;


import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.spellComponents.*;
import com.jmkopecky.aeternumcraft.util.Logger;

import java.util.Map;

public enum SpellComponentInfo {
    DETONATESMALL("detonatesmall", "Parva Explosio", "Small Detonation", 0, 0, 0, DetonateSmallSpellComponent.class, "Creates a small explosion"),
    DETONATE("detonate", "Explosio", "Detonate", 0, 0, 0, DetonateSpellComponent.class, "Creates a explosion"),
    INFERNALEXPLOSION("infernalexplosion", "Ignis Explosio", "Infernal Explosion", 0, 0, 0, InfernalExplosionSpellComponent.class, "Creates a fiery explosion"),
    MASSIVEINFERNALEXPLOSION("massiveinfernalexplosion", "Magnus Ignis Explosio", "Massive Infernal Explosion", 0, 0, 0, MassiveInfernalExplosionSpellComponent.class, "Creates a big fiery explosion"),
    STASIS("stasis", "Mora", "Stasis", 0, 0, 0, StasisSpellComponent.class, "Freezes the target temporarily"),
    EXTENDEDSTASIS("extendedstasis", "Extensa Mora", "Extended Stasis", 0, 0, 0, StasisExtendedSpellComponent.class, "Freezes the target for a longer time"),
    WEAKDAMAGE("weakdamage", "Infirmum Impetum", "Weak Damage", 0, 0, 0, WeakDamageSpellComponent.class, "Deals basic weak damage"),
    STRONGDAMAGE("strongdamage", "Fortis Impetus", "Strong Damage", 0, 0, 0, StrongDamageSpellComponent.class, "Deals basic strong damage"),
    CRIPPLE("cripple", "Debilis", "Cripple", 0, 0, 0, CrippleSpellComponent.class, "Cripples the target"),
    IMPEDE("impede", "Impedire", "Impede", 0, 0, 0, ImpedeSpellComponent.class, "Impedes the target"),
    DISORIENT("disorient", "Diluere", "Disorient", 0, 0, 0, DisorientSpellComponent.class, "Disorients the target"),
    DOOM("doom", "Malum", "Doom", 0, 0, 0, DoomSpellComponent.class, "Dooms the target to near-death"),
    DRAIN("drain", "Exhaurire", "Drain", 0, 0, 0, DrainHealthSpellComponent.class, "Drains the target's health"),
    LIGHTNINGSTRIKEDOOM("lightningstrikedoom", "Intervallum Fulgur", "Lightning Strike Doom", 0, 0, 0, LightningStrikeDoomSpellComponent.class, "Strikes lightning on the target periodically"),
    EXPLOSIVEDOOM("explosivedoom", "Intervallum Explosio", "Explosive Doom", 0, 0, 0, ExplosiveDoomSpellComponent.class, "Explodes the target periodically"),
    ASSASSINSHIFT("assassinshift", "Sicarius Transmuto", "Assassin's Shift", 0, 0, 0, AssassinSpellComponent.class, "Shifts the target into assassin mode"),
    DEFENSIVESHIFT("defensiveshift", "Defensus Transmuto", "Defensive Shift", 0, 0, 0, DefensiveShiftSpellComponent.class, "Shifts the target into defense mode"),
    ESCAPISTSHIFT("escapistshift", "Effugere Transmuto", "Escapist Shift", 0, 0, 0, EscapistShiftSpellComponent.class, "Shifts the target into escape mode");





    private String spellName;
    private String latinSpellName;
    private String spellDisplayName;
    private String spellDescription;
    private int spellMinLevel;
    private int spellLevelCost;
    private int spellManaCost;
    private Object spellClass;




    SpellComponentInfo(String spellName, String latinSpellName, String spellDisplayName, int spellMinLevel, int spellLevelCost, int spellManaCost, Object spellClass, String spellDescription) {
        this.spellName = spellName;
        this.latinSpellName = latinSpellName;
        this.spellDisplayName = spellDisplayName;
        this.spellDescription = spellDescription;
        this.spellMinLevel = spellMinLevel;
        this.spellLevelCost = spellLevelCost;
        this.spellManaCost = spellManaCost;
        this.spellClass = spellClass;
    }
    public String getSpellName() {
        return this.spellName;
    }
    public String getLatinSpellName() {
        return this.latinSpellName;
    }
    public String getSpellDisplayName() {
        return this.spellDisplayName;
    }
    public String getSpellDescription() {
        return this.spellDescription;
    }
    public int getSpellMinLevel() {
        return this.spellMinLevel;
    }
    public int getSpellLevelCost() {
        return this.spellLevelCost;
    }
    public int getSpellManaCost() {
        return this.spellManaCost;
    }
    public Object getSpellClass() {
        return this.spellClass;
    }

    public static DefaultSpellComponent buildComponentWithIdentifier(String identifier, int amplification) {
        DefaultSpellComponent result;
        switch (identifier) {
            case "detonatesmall" -> result = new DetonateSmallSpellComponent(amplification);
            case "detonate" -> result = new DetonateSpellComponent(amplification);
            case "infernalexplosion" -> result = new InfernalExplosionSpellComponent(amplification);
            case "massiveinfernalexplosion" -> result = new MassiveInfernalExplosionSpellComponent(amplification);
            case "stasis" -> result = new StasisSpellComponent(amplification);
            case "extendedstasis" -> result = new StasisExtendedSpellComponent(amplification);
            case "weakdamage" -> result = new WeakDamageSpellComponent(amplification);
            case "strongdamage" -> result = new StrongDamageSpellComponent(amplification);
            case "cripple" -> result = new CrippleSpellComponent(amplification);
            case "impede" -> result = new ImpedeSpellComponent(amplification);
            case "disorient" -> result = new DisorientSpellComponent(amplification);
            case "doom" -> result = new DoomSpellComponent(amplification);
            case "drain" -> result = new DrainHealthSpellComponent(amplification);
            case "lightningstrikedoom" -> result = new LightningStrikeDoomSpellComponent(amplification);
            case "explosivedoom" -> result = new ExplosiveDoomSpellComponent(amplification);
            case "assassinshift" -> result = new AssassinSpellComponent(amplification);
            case "defensiveshift" -> result = new DefensiveShiftSpellComponent(amplification);
            case "escapistshift" -> result = new EscapistShiftSpellComponent(amplification);
            default -> {
                result = null;
                System.out.println("Error: attempted to build a component with an invalid spell name.");
            }
        }
        return result;
    }
    public static SpellComponentInfo getEnumValueGivenStringIdentifier(String identifier) {
        SpellComponentInfo result;
        switch (identifier) {
            case "detonatesmall" -> result = SpellComponentInfo.DETONATESMALL;
            case "detonate" -> result = SpellComponentInfo.DETONATE;
            case "infernalexplosion" -> result = SpellComponentInfo.INFERNALEXPLOSION;
            case "massiveinfernalexplosion" -> result = SpellComponentInfo.MASSIVEINFERNALEXPLOSION;
            case "stasis" -> result = SpellComponentInfo.STASIS;
            case "extendedstasis" -> result = SpellComponentInfo.EXTENDEDSTASIS;
            case "weakdamage" -> result = SpellComponentInfo.WEAKDAMAGE;
            case "strongdamage" -> result = SpellComponentInfo.STRONGDAMAGE;
            case "cripple" -> result = SpellComponentInfo.CRIPPLE;
            case "impede" -> result = SpellComponentInfo.IMPEDE;
            case "disorient" -> result = SpellComponentInfo.DISORIENT;
            case "doom" -> result = SpellComponentInfo.DOOM;
            case "drain" -> result = SpellComponentInfo.DRAIN;
            case "lightningstrikedoom" -> result = SpellComponentInfo.LIGHTNINGSTRIKEDOOM;
            case "explosivedoom" -> result = SpellComponentInfo.EXPLOSIVEDOOM;
            case "assassinshift" -> result = SpellComponentInfo.ASSASSINSHIFT;
            case "defensiveshift" -> result = SpellComponentInfo.DEFENSIVESHIFT;
            case "escapistshift" -> result = SpellComponentInfo.ESCAPISTSHIFT;
            default -> {
                result = null;
                Logger.log("Error: Attempted to get the SpellComponentInfo enum value for an unrecognized string: " + identifier, Logger.WARNING);
            }
        }
        return result;
    }

    private static Map<String, Object> spellComponentMap = Map.ofEntries(
            //explosion components
            Map.entry("detonatesmall", DetonateSmallSpellComponent.class),
            Map.entry("detonate", DetonateSpellComponent.class),
            Map.entry("infernalexplosion", InfernalExplosionSpellComponent.class),
            Map.entry("massiveinfernalexplosion", MassiveInfernalExplosionSpellComponent.class),
            //stasis and movement components
            Map.entry("stasis", StasisSpellComponent.class),
            Map.entry("extendedstasis", StasisExtendedSpellComponent.class),
            //basic damage components
            Map.entry("weakdamage", WeakDamageSpellComponent.class),
            Map.entry("strongdamage", StrongDamageSpellComponent.class),
            //spells that give effects
            Map.entry("cripple", CrippleSpellComponent.class),
            Map.entry("impede", ImpedeSpellComponent.class),
            Map.entry("disorient", DisorientSpellComponent.class),
            Map.entry("doom", DoomSpellComponent.class),
            Map.entry("drain", DrainHealthSpellComponent.class),
            Map.entry("lightningstrikedoom", LightningStrikeDoomSpellComponent.class),
            Map.entry("explosivedoom", ExplosiveDoomSpellComponent.class),
            Map.entry("assassinshift", AssassinSpellComponent.class),
            Map.entry("defensiveshift", DefensiveShiftSpellComponent.class),
            Map.entry("escapistshift", EscapistShiftSpellComponent.class)
    );

    public static String getIdentifierWithComponent(DefaultSpellComponent component) {
        String result = null;
        Object targetClass = component.getClass().asSubclass(DefaultSpellComponent.class);
        for (Map.Entry<String, Object> entry:spellComponentMap.entrySet()) {
            if (entry.getValue()==targetClass) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
