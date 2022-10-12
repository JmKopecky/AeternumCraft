package com.jmkopecky.aeternumcraft.items.custom.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.w3c.dom.Attr;

import java.util.UUID;

public class CustomArmorUtil extends ArmorItem {

    //constructor
    public CustomArmorUtil(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
    }



    //initializes a passed in attributeModifier array with a uuid and the modifier bonus.
    protected AttributeModifier[] initModifiers(AttributeModifier[] AttributeModifiers, UUID[] ArmorUUID, double[] modifierBonus) {
        for (int i = 0; i < AttributeModifiers.length; i++) {
            AttributeModifiers[i] = new AttributeModifier(ArmorUUID[i], "ModifierArmor", modifierBonus[i], AttributeModifier.Operation.ADDITION);
        }
        return AttributeModifiers;
    }

    //generates a UUID for each individual modifier, and each UUID is different across slots.
    protected UUID[] setSlotIndependentUUIDS(EquipmentSlot slot, int attributeModifierLength, UUID[] uuidArray) {
        for (int i = 0; i < attributeModifierLength; i++) {
            switch (slot) {
                case FEET -> {
                    uuidArray[i] = UUID.randomUUID();
                    break;
                }
                case LEGS -> {
                    uuidArray[i] = UUID.randomUUID();
                    break;
                }
                case CHEST -> {
                    uuidArray[i] = UUID.randomUUID();
                    break;
                }
                case HEAD -> {
                    uuidArray[i] = UUID.randomUUID();
                    break;
                }
                default -> {uuidArray[i] = UUID.randomUUID();}
            }
        }
        return uuidArray;
    }


    //adds the modifiers contained in the attribute modifier array to the player specified.
    protected void addModifiersToPlayer(Player player, String[] modifierIdentifier, AttributeModifier[] attributeModifiers) {
        for (int i = 0; i < attributeModifiers.length; i++) {
            switch (modifierIdentifier[i]) {
                case "health": {
                    player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "damage": {
                    player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "walkSpeed": {
                    player.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "attackSpeed": {
                    player.getAttribute(Attributes.ATTACK_SPEED).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "luck": {
                    player.getAttribute(Attributes.LUCK).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "knockback": {
                    player.getAttribute(Attributes.ATTACK_KNOCKBACK).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "reach": {
                    player.getAttribute(ForgeMod.REACH_DISTANCE.get()).addTransientModifier(attributeModifiers[i]);
                    player.getAttribute(ForgeMod.ATTACK_RANGE.get()).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "swimSpeed": {
                    player.getAttribute(ForgeMod.SWIM_SPEED.get()).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "stepHeight": {
                    player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "gravity": {
                    player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                case "armor": {
                    player.getAttribute(Attributes.ARMOR).addTransientModifier(attributeModifiers[i]);
                    player.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(attributeModifiers[i]);
                    break;
                }
                default: {
                    System.out.println("Error adding attributes to player, no attributes match.");
                }
            }
        }
    }


    //removes the attributes found in the attribute modifier array from the player specified.
    protected void removePlayerModifiers(Player player, String[] modifierIdentifier, AttributeModifier[] attributeModifiers) {
        for (int i = 0; i < attributeModifiers.length; i++) {
            switch (modifierIdentifier[i]) {
                case "health": {
                    player.getAttribute(Attributes.MAX_HEALTH).removeModifier(attributeModifiers[i]);
                    if (player.getHealth() >= player.getMaxHealth()) {
                        player.setHealth(player.getMaxHealth());
                    }
                    break;
                }
                case "damage": {
                    player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "walkSpeed": {
                    player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "attackSpeed": {
                    player.getAttribute(Attributes.ATTACK_SPEED).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "luck": {
                    player.getAttribute(Attributes.LUCK).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "knockback": {
                    player.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "reach": {
                     player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(attributeModifiers[i]);
                     player.getAttribute(ForgeMod.REACH_DISTANCE.get()).removeModifier(attributeModifiers[i]);
                     break;
                }
                case "swimSpeed": {
                    player.getAttribute(ForgeMod.SWIM_SPEED.get()).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "stepHeight": {
                    player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).removeModifier(attributeModifiers[i]);
                    break;
                }
                case "gravity": {
                    player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).removeModifier(attributeModifiers[i]);
                    break;
                }
                default: {
                    System.out.println("Error: Attribute unable to be removed due to being unrecognized on the removeable list.");
                }
            }
        }
    }
}
