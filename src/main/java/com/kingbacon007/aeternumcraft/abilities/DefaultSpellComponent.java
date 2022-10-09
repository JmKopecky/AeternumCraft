package com.kingbacon007.aeternumcraft.abilities;

import com.kingbacon007.aeternumcraft.abilities.spellComponents.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class DefaultSpellComponent {
    HashMap<String, Double> defaultDamageValues = new HashMap<String, Double>();
    double manaBaseCost;
    int amplification;



    public DefaultSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    public DefaultSpellComponent() {
    }

    public static Object lookupComponentWithIdentifier(String identifier) {
        return spellComponentMap.get(identifier);
    }

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


    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        //code to be run by any given spell component should override this method and place here.
        System.out.println("runallocmponentprojectile is accessing the parent class.");
    }
    public void triggerAbilityComponentSelf(Player player) {
        //code to be run by any child spell components on the player, should be overridden.
    }

    public static Map<String, Object> spellComponentMap = Map.ofEntries(
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

}
