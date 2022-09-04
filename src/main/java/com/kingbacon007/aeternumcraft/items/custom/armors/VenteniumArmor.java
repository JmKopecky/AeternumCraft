package com.kingbacon007.aeternumcraft.items.custom.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.UUID;

public class VenteniumArmor extends CustomArmorUtil {
    double[] modifierBonus = {6.0D};
    String[] modifierIdentifier = {"health"};
    AttributeModifier[] ATTRIBUTE_MODIFIER_ARMOR = new AttributeModifier[1];
    UUID[] ArmorUUID = new UUID[1];

    public VenteniumArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
        ArmorUUID = setSlotIndependentUUIDS(p_40387_, ATTRIBUTE_MODIFIER_ARMOR.length, ArmorUUID);
        ATTRIBUTE_MODIFIER_ARMOR = initModifiers(ATTRIBUTE_MODIFIER_ARMOR, ArmorUUID, modifierBonus);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!player.getAttributes().hasModifier(Attributes.MAX_HEALTH, ArmorUUID[0])) {
            addModifiersToPlayer(player, modifierIdentifier, ATTRIBUTE_MODIFIER_ARMOR);
        }
    }

    @Override
    public void inventoryTick(ItemStack item, Level world, Entity player, int p_41407_, boolean p_41408_) {
        if (!(((Player) player).getInventory().getArmor(slot.getIndex()) == item)) {
            if (((Player) player).getAttributes().hasModifier(Attributes.MAX_HEALTH, ArmorUUID[0])) {
                removePlayerModifiers((Player) player, modifierIdentifier, ATTRIBUTE_MODIFIER_ARMOR);
            }
        }
    }
}
