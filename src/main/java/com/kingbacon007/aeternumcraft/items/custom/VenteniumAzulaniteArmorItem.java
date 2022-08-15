package com.kingbacon007.aeternumcraft.items.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.UUID;

public class VenteniumAzulaniteArmorItem extends ArmorItem {
    public double MaxHealthBonus = 10.0D;
    private final UUID HealthUUID = UUID.randomUUID();
    public boolean initialAddModifier = true;
    AttributeModifier HEALTH_BONUS;

    public VenteniumAzulaniteArmorItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
        HEALTH_BONUS = new AttributeModifier(HealthUUID, "HealthModifier", MaxHealthBonus, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        //this triggers on the first tick of the armor being equipped, and does not fire again unless told to.
        if (initialAddModifier||!player.getAttribute(Attributes.MAX_HEALTH).hasModifier(HEALTH_BONUS)) {
            initialAddModifier = false;
            player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(HEALTH_BONUS);
        }
    }
    private int counter = 0;

    @Override
    public void inventoryTick(ItemStack item, Level world, Entity player, int p_41407_, boolean p_41408_) {
        //checks if the armor has just been removed from the slot, checks every quarter second
        if (counter==5) {
            counter = 0;
            if (!(((Player) player).getInventory().getArmor(slot.getIndex()) == item)) {
                if (!initialAddModifier) {
                    //remove the modifier and set initialaddmodifier to true.
                    ((Player) player).getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BONUS);
                    initialAddModifier = true;
                    if (((Player) player).getHealth() >= ((Player) player).getMaxHealth()) {
                        ((Player) player).setHealth((float) ((Player) player).getMaxHealth());
                    }
                }
            }
        } else {
            counter++;
        }

    }
}
