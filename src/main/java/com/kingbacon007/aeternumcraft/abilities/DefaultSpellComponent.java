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
    String componentName = "defaultcomponent";
    int amplification;

    public DefaultSpellComponent(int amplification) {
        this.amplification = amplification;
    }

    public DefaultSpellComponent() {
    }

    //method to load a hashmap with damage values for a spell (because some spells can do multiple types of damage).
    public HashMap<String, Double> setDamageValues(HashMap<String, Double> map, double fireDamage, double earthDamage, double waterDamage, double airDamage, double spaceDamage, double energyDamage, double magicDamage) {
        map.put("fireDamage", fireDamage);
        map.put("earthDamage", earthDamage);
        map.put("waterDamage", waterDamage);
        map.put("airDamage", airDamage);
        map.put("energyDamage", energyDamage);
        map.put("magicDamage", magicDamage);
        map.put("spaceDamage", spaceDamage);
        return map;
    }
    public static DefaultSpellComponent lookupComponentWithIdentifier(String identifier) {
        return spellComponentMap.get(identifier);
    }
    public void triggerAbilityComponentProjectile(@Nullable EntityHitResult EntityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        //code to be run by any given spell component should override this method and place here.
    }
    public void triggerAbilityComponentSelf(Player player) {
        //code to be run by any child spell components on the player, should be overridden.
    }

    public static Map<String, ? extends DefaultSpellComponent> spellComponentMap = Map.ofEntries(
            //explosion components
            Map.entry("detonatesmall", new DetonateSmallSpellComponent(0)),
            Map.entry("detonate", new DetonateSpellComponent(0)),
            Map.entry("infernalexplosion", new InfernalExplosionSpellComponent(0)),
            Map.entry("massiveinfernalexplosion", new MassiveInfernalExplosionSpellComponent(0)),
            //stasis and movement components
            Map.entry("stasis", new StasisSpellComponent(0)),
            Map.entry("extendedstasis", new StasisExtendedSpellComponent(0)),
            //basic damage components
            Map.entry("weakdamage", new WeakDamageSpellComponent(0)),
            Map.entry("strongdamage", new StrongDamageSpellComponent(0)),
            //normal harmful effects
            Map.entry("cripple", new CrippleSpellComponent(0)),
            Map.entry("impede", new ImpedeSpellComponent(0))

    );
}
