package com.jmkopecky.aeternumcraft.abilities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AbilityComponentDataType {
    /*
        Stores an arrayList with extra functionality.
         */


    ArrayList<DefaultSpellComponent> abilityComponentList = new ArrayList<>();

    String spellType;

    ArrayList<Integer> amplification = new ArrayList<Integer>();

    public AbilityComponentDataType(String spellType) {
        this.spellType = spellType;
    }

    public DefaultSpellComponent getComponentAtIndex(int i) {
        return abilityComponentList.get(i);
    }

    public void appendComponent(DefaultSpellComponent component, int amplification) {
        abilityComponentList.add(component);
        this.amplification.add(amplification);
    }

    public void emptyComponents() {
        abilityComponentList.clear();
        amplification.clear();
    }

    public void populateComponents(ArrayList<DefaultSpellComponent> arrayList, ArrayList<Integer> amplification) {
        abilityComponentList.clear();
        abilityComponentList.addAll(arrayList);
        this.amplification.clear();
        this.amplification.addAll(amplification);

    }

    public void populateAmplification(ArrayList<Integer> amplification) {
        this.amplification = amplification;
    }

    public void setAmplificationValue(int index, int amplification) {
        this.amplification.set(index, amplification);
    }

    public int getAmplification(int componentIndex) {
        return this.amplification.get(componentIndex);
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
        for (DefaultSpellComponent component : abilityComponentList) {
            if (component != null) {
                component.triggerAbilityComponentProjectile(entityHitResult, blockHitResult, shooter);
            } else {
                System.out.println("tried to run updated runallcomponentsprojectile but the component is null");
            }
        }
    }

    public void runAllComponentsOnPlayer(Player player) {
        for (int i = 0; i < abilityComponentList.size() - 1; i++) {
            //abilityComponentList.get(i).triggerAbilityComponentSelf(player);
            if (!(abilityComponentList.get(i) == null)) {
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
        return DefaultSpellComponent.getIdentifierWithComponent(abilityComponentList.get(index));
    }
}