package com.jmkopecky.aeternumcraft.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class AbilityComponentDataType {
    /*
        Stores an arrayList with extra functionality.
         */


    ArrayList<DefaultSpellComponent> abilityComponentList = new ArrayList<>();

    SpellCastTypes spellType;

    int spellScatterCount = 1;

    ArrayList<Integer> amplification = new ArrayList<Integer>();

    public AbilityComponentDataType(SpellCastTypes spellType) {
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

    public void setSpellScatterCount(int scatterCount) {
        this.spellScatterCount = scatterCount;
    }
    public int getSpellScatterCount() {
        return this.spellScatterCount;
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

    public void setSpellType(SpellCastTypes spellType) {
        this.spellType = spellType;
    }

    public SpellCastTypes getSpellType() {
        return spellType;
    }

    public void runComponents(LivingEntity player, @Nullable LivingEntity entity, @Nullable BlockPos blockHitResult) {
        switch (spellType) {
            case PROJECTILE, BURSTPROJECTILE, SCATTERBURSTPROJECTILE, SCATTERPROJECTILE -> {
                runAllComponentsOnTarget(entity, blockHitResult, player);
            }
            case SELF -> {
                runAllComponentsOnPlayer((Player) player);
            }
            default -> {
                System.out.println("Error, tried to run a spell chain with an unrecognized spell type.");
            }
        }
    }

    public void runAllComponentsOnTarget(@Nullable LivingEntity entity, @Nullable BlockPos blockPos, LivingEntity shooter) {
        for (DefaultSpellComponent component : abilityComponentList) {
            if (component != null) {
                component.triggerSpell((Player) shooter, entity, blockPos);
            } else {
                System.out.println("tried to run updated runallcomponentsprojectile but the component is null");
            }
        }
    }

    public void runAllComponentsOnPlayer(Player player) {
        for (DefaultSpellComponent component : abilityComponentList) {
            if (component != null) {
                component.triggerSpell(player, player, null);
            } else {
                System.out.println("tried to run updated runallcomponentsplayer but the component is null");
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
        return SpellComponentInfo.getIdentifierWithComponent(abilityComponentList.get(index));
    }
}