package com.kingbacon007.aeternumcraft.abilities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class AbilityComponentDataType {
    /*
        Stores an arrayList with extra functionality.
         */



    ArrayList<DefaultSpellComponent> abilityComponentList = new ArrayList<DefaultSpellComponent>();

    String spellType;

    public AbilityComponentDataType(String spellType) {
        this.spellType = spellType;
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

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public String getSpellType() {
        return spellType;
    }

    public void runComponents(LivingEntity player, @Nullable EntityHitResult entityHitResult, @Nullable BlockHitResult blockHitResult) {
        switch (spellType) {
            case ("Projectile"): {
                runAllComponentsProjectile(entityHitResult, blockHitResult, player);
                break;
            }
            case ("Self"): {
                runAllComponentsOnPlayer((Player) player);
                break;
            }
            default: {
                System.out.println("Error, tried to run a spell chain with an unrecognized spell type.");
            }
        }
    }

    public void runAllComponentsProjectile(@Nullable EntityHitResult entityHitResult, @Nullable BlockHitResult blockHitResult, LivingEntity shooter) {
        for (int i = 0; i< abilityComponentList.size()-1; i++) {
            if (abilityComponentList.get(i)!=null) {
                abilityComponentList.get(i).triggerAbilityComponentProjectile(entityHitResult, blockHitResult, shooter);
            } else {
                System.out.println("tried to run triggerAbilityComponentProjectile but the component at index "+i +" is null");
            }
        }
    }

    public void runAllComponentsOnPlayer(Player player) {
        for (int i = 0; i < abilityComponentList.size()-1; i++) {
            //abilityComponentList.get(i).triggerAbilityComponentSelf(player);
            if (!(abilityComponentList.get(i)==null)) {
                abilityComponentList.get(i).triggerAbilityComponentSelf(player);
            } else {
                System.out.println("Tried to trigger all components on player but the component at index " + i + " is null.");
            }
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
