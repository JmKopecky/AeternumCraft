package com.kingbacon007.aeternumcraft.playerstats;

import com.kingbacon007.aeternumcraft.abilities.AbilityComponentDataType;
import com.kingbacon007.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;


public class PlayerAbilities {
    /*
    create a custom class solely to store the players ability components.
    An object of this class can then be created and the components can be passed with the constructor.
     */
    AbilityComponentDataType[] abilitySlots = {new AbilityComponentDataType(), new AbilityComponentDataType(), new AbilityComponentDataType(), new AbilityComponentDataType(), new AbilityComponentDataType(), new AbilityComponentDataType(), new AbilityComponentDataType()};

    int[] componentCountPerSlot = {0, 0, 0, 0, 0, 0, 0};
    int currentSlot = 0;
    ArrayList<DefaultSpellComponent> arrayListTemp;

    public int getCurrentSlot() {
        return currentSlot;
    }

    public AbilityComponentDataType getAbilityChain(int slot) {
        return abilitySlots[slot];
    }

    public void addComponentToSlot(int index, DefaultSpellComponent component) {
        abilitySlots[index].appendComponent(component);
    }
    public void populateComponentsToSlot(int index, ArrayList<DefaultSpellComponent> componentArray) {
        abilitySlots[index].populateComponents(componentArray);
    }

    public void copyFrom(PlayerAbilities source) {
        this.abilitySlots = source.abilitySlots;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("currentSlot", currentSlot);
        //for each loop that runs for each element in the abilityslots variable, iterates through each component in the variable, gets it name, and saves it.
        for (int i = 0; i< abilitySlots.length; i++) { //for each slot
            if (!(abilitySlots[i].accessContainer()==null)) {
                componentCountPerSlot[i] = abilitySlots[i].getLength();
                for (int i2 = 0; i2<abilitySlots[i].getLength(); i2++) { //for each component
                    //format "slot_SLOTINDEX_component_COMPONENTINDEX
                    nbt.putString("slot_"+i+"_component_"+i2, abilitySlots[i].getComponentName(i2));
                }
            }
        }
        nbt.putIntArray("componentCount", componentCountPerSlot);
    }
    public void loadNBTData(CompoundTag nbt) {
        this.currentSlot = nbt.getInt("currentSlot");
        for (int i = 0; i< abilitySlots.length; i++) { //for each slot
            if ((nbt.contains("componentCount"))) {
                componentCountPerSlot = nbt.getIntArray("componentCount");
                if (!(componentCountPerSlot[i]==0)) {
                    //for each stored string, get its component, then append it to abilityslots. do this for each slot.
                    for (int i2 = 0; i2<componentCountPerSlot[i]; i2++) { //for each component in the slot
                        //gets the component at the given index and adds it to the temporary arraylist, used to populate abilitySlots
                        arrayListTemp.add(DefaultSpellComponent.lookupComponentWithIdentifier(nbt.getString("slot_"+i+"_component_"+i2)));
                    }
                    abilitySlots[i].populateComponents(arrayListTemp);
                    arrayListTemp.clear();
                }
            }
        }
    }
}
