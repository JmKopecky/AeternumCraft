package com.jmkopecky.aeternumcraft.playerstats;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.AbilityComponentDataType;
import com.jmkopecky.aeternumcraft.abilities.DefaultSpellComponent;
import com.jmkopecky.aeternumcraft.abilities.SpellComponentInfo;
import com.jmkopecky.aeternumcraft.abilities.SpellProjectile;
import com.jmkopecky.aeternumcraft.entity.EntityRegister;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;


public class PlayerAbilities {
    /*
    create a custom class solely to store the players ability components.
    An object of this class can then be created and the components can be passed with the constructor.
     */
    AbilityComponentDataType[] abilitySlots = {
            new AbilityComponentDataType("Projectile"),
            new AbilityComponentDataType("Projectile"),
            new AbilityComponentDataType("Projectile"),
            new AbilityComponentDataType("Projectile"),
            new AbilityComponentDataType("Projectile"),
            new AbilityComponentDataType("Self"),
            new AbilityComponentDataType("Self")};

    int[] componentCountPerSlot = {0, 0, 0, 0, 0, 0, 0};
    int currentSlot = 0;

    boolean isFiring = false;

    Map<String, Boolean> unlockedSpells  = new HashMap<String, Boolean>() {{
        put("detonatesmall", false);
        put("detonate", false);
        put("infernalexplosion", false);
        put("massiveinfernalexplosion", false);
        put("stasis", false);
        put("extendedstasis", false);
        put("weakdamage", false);
        put("strongdamage", false);
        put("cripple", false);
        put("impede", false);
        put("disorient", false);
        put("doom", false);
        put("drain", false);
        put("lightningstrikedoom", false);
        put("explosivedoom", false);
        put("assassinshift", false);
        put("defensiveshift", false);
        put("escapistshift", false);
    }};

    public void unlockSpell(String spellName, boolean unlockOrLock) {
        if (unlockedSpells.containsKey(spellName)) {
            unlockedSpells.put(spellName, unlockOrLock);
        } else {
            AeternumCraft.log("Error: Attempted to unlock a spell that does not exist in the player's ability class. (AeternumCraft) ", "Warning");
        }
    }

    public boolean checkIfSpellUnlocked(String spellName) {
        return unlockedSpells.get(spellName);
    }

    public void setIsFiring(boolean value) {
        this.isFiring = value;
    }

    public boolean getIsFiring() {
        return isFiring;
    }

    public void fireAtCurrentSlot(Player player, ClientLevel level) {
        switch (abilitySlots[currentSlot].getSpellType()) {
            case "Projectile": {
                SpellProjectile spell = new SpellProjectile(EntityRegister.SPELL_PROJECTILE.get(), player.level, player);
                spell.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 0.7F);
                player.level.addFreshEntity(spell);
                break;
            }
            case "Self": {
                System.out.println("Registered command to fire spell self.");
                abilitySlots[currentSlot].runComponents(player, null,null);
                break;
            }
            default: {
                System.out.println("Error, tried to fire a spell with an unidentified spell type");
            }
        }
    }

    public int getCurrentSlot() {
        return currentSlot;
    }

    public AbilityComponentDataType getAbilityChain(int slot) {
        return abilitySlots[slot];
    }

    public void addComponentToSlot(int index, DefaultSpellComponent component, int amplification) {
        abilitySlots[index].appendComponent(component, amplification);
        componentCountPerSlot[index] += 1;
    }
    public void populateComponentsToSlot(int index, ArrayList<DefaultSpellComponent> componentArray, ArrayList<Integer> amplification) {
        abilitySlots[index].populateComponents(componentArray, amplification);
    }

    public void emptyComponentsOfSlot(int slot) {
        abilitySlots[slot].emptyComponents();
        componentCountPerSlot[slot] = 0;
    }



    public void copyFrom(PlayerAbilities source) {
        this.abilitySlots = source.abilitySlots;
    }

    public void saveNBTData(CompoundTag nbt) {
        /*
        Saves strings to the player, which are looked up in the load method.
        Saves amplification values in a seperate array.
        Saves the amount of components, for use in the load method.
        Saves the current slot of the player.
        Saves whether each spell is unlocked by the player.
         */
        nbt.putInt("currentSlot", currentSlot);

        //Saving unlocked spells
        for(String spellName : unlockedSpells.keySet()) {
            nbt.putBoolean(spellName, checkIfSpellUnlocked(spellName));
        }

        int slotIterator = 0;
        int componentIterator = 0;

        List<Integer> componentCount = new ArrayList<>();

        for (AbilityComponentDataType slot : abilitySlots) {
            componentCount.add(slot.getLength());

            List<Integer> amplificationValues = new ArrayList<>();

            if (!slot.accessContainer().isEmpty()) {
                for (Object ignored : slot.accessContainer()) {
                    amplificationValues.add(slot.getAmplification(componentIterator));
                    nbt.putString("slot_"+slotIterator+"_component_"+componentIterator, slot.getComponentName(componentIterator));
                    componentIterator++;
                }
                nbt.putIntArray("amplification_" + slotIterator, amplificationValues);
                amplificationValues.clear();
            }
            slotIterator++;
        }
        nbt.putIntArray("componentCount", componentCount);
    }


    public void loadNBTData(CompoundTag nbt) {

        /*
        Gets the players current slot
        gets the players amplification values
        gets the players components
        Gets players unlocked spells
         */

        this.currentSlot = nbt.getInt("currentSlot");

        for(String spellName : unlockedSpells.keySet()) {
            unlockSpell(spellName, nbt.getBoolean(spellName));
        }

        this.componentCountPerSlot = nbt.getIntArray("componentCount");

        int slotIterator = 0;
        int componentIterator;

        for (AbilityComponentDataType slot : abilitySlots) {
            int[] amplification = nbt.getIntArray("amplification_" + slotIterator);

            for (componentIterator = 0; componentIterator <= componentCountPerSlot[slotIterator]-1; componentIterator++) {
                String componentName = nbt.getString("slot_"+slotIterator+"_component_"+componentIterator);
                DefaultSpellComponent component = SpellComponentInfo.buildComponentWithIdentifier(componentName, amplification[componentIterator]);
                slot.appendComponent(component, amplification[componentIterator]);
            }
            slotIterator++;
        }
    }
}
