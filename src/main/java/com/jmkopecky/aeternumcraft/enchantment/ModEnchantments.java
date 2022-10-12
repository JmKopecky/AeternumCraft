package com.jmkopecky.aeternumcraft.enchantment;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, AeternumCraft.MODID);

    public static RegistryObject<Enchantment> StasisBladeEnchant = ENCHANTMENT_DEFERRED_REGISTER.register("stasis_blade", () -> new StasisBladeEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> StasisPulseEnchant = ENCHANTMENT_DEFERRED_REGISTER.register("stasis_pulse", () -> new StasisPulseEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.FEET, EquipmentSlot.LEGS));
    public static RegistryObject<Enchantment> SmiteStrikeEnchant = ENCHANTMENT_DEFERRED_REGISTER.register("smite_strike", () -> new SmiteStrikeEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> ExecutionEnchant = ENCHANTMENT_DEFERRED_REGISTER.register("execution", () -> new ExecutionEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENT_DEFERRED_REGISTER.register(eventBus);
    }
}
