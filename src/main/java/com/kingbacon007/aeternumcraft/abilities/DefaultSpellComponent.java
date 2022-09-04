package com.kingbacon007.aeternumcraft.abilities;

import com.kingbacon007.aeternumcraft.abilities.spellComponents.DemoSpellComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.EntityHitResult;
import java.util.HashMap;
import java.util.Map;

public class DefaultSpellComponent {
    HashMap<String, Double> defaultDamageValues = new HashMap<String, Double>();
    double manaBaseCost;
    String componentName = "defaultcomponent";

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
    public void triggerAbilityComponentProjectile(EntityHitResult HitResult, LivingEntity shooter) {
        //code to be run by any given spell component should override this method and place here.
    }
    public void triggerAbilityComponentSelf(Player player) {
        //code to be run by any child spell components on the player, should be overridden.
    }

    public static Map<String, ? extends DefaultSpellComponent> spellComponentMap = Map.ofEntries(
            Map.entry("democomponent", new DemoSpellComponent())
    );
}
