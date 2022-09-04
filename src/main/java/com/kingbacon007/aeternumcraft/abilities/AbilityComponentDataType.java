package com.kingbacon007.aeternumcraft.abilities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.EntityHitResult;

import java.util.ArrayList;

public class AbilityComponentDataType {
    /*
        Stores an arrayList with extra functionality.
         */



    ArrayList<DefaultSpellComponent> abilityComponentList;

    public AbilityComponentDataType() {

    }

    public DefaultSpellComponent getComponentAtIndex(int i) {
        return abilityComponentList.get(i);
    }

    public void appendComponent(DefaultSpellComponent component) {
        abilityComponentList.add(component);
    }

    public void emptyComponents() {
        abilityComponentList.clear();
    }

    public void populateComponents(ArrayList<DefaultSpellComponent> arrayList) {
        for (int i = 0; i< arrayList.size(); i++) {
            abilityComponentList.add(arrayList.get(i));
        }
    }


    public void runAllComponentsProjectile(EntityHitResult HitResult, LivingEntity shooter) {
        for (int i = 0; i< abilityComponentList.size(); i++) {
            abilityComponentList.get(i).triggerAbilityComponentProjectile(HitResult, shooter);
        }
    }

    public void runAllComponentsOnPlayer(Player player) {
        for (int i = 0; i< abilityComponentList.size(); i++) {
            abilityComponentList.get(i).triggerAbilityComponentSelf(player);
        }
    }
    public ArrayList accessContainer() {
        return abilityComponentList;
    }
    public int getLength() {
        return abilityComponentList.size();
    }
    public String getComponentName(int index) {
        return abilityComponentList.get(index).componentName;
    }
}
