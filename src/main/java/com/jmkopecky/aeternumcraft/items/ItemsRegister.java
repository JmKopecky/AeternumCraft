package com.jmkopecky.aeternumcraft.items;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.items.custom.armors.*;
import com.jmkopecky.aeternumcraft.items.custom.armors.alloys.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AeternumCraft.MODID);

    //Energeticum ingot
    public static final RegistryObject<Item> ENERGETICUM_INGOT = ITEMS.register("energeticum_ingot" , () -> new Item( new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Magiconium ingot
    public static final RegistryObject<Item> MAGICONIUM_INGOT = ITEMS.register("magiconium_ingot", () -> new Item( new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Spaconium ingot
    public static final RegistryObject<Item> SPACONIUM_INGOT = ITEMS.register("spaconium_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Gentinium ingot
    public static final RegistryObject<Item> GENTINIUM_INGOT = ITEMS.register("gentinium_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Montenite ingot
    public static final RegistryObject<Item> MONTENITE_INGOT = ITEMS.register("montenite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Reclinite ingot
    public static final RegistryObject<Item> RECLINITE_INGOT = ITEMS.register("reclinite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ruelanite ingot
    public static final RegistryObject<Item> RUELANITE_INGOT = ITEMS.register("ruelanite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ventenium ingot
    public static final RegistryObject<Item> VENTENIUM_INGOT = ITEMS.register("ventenium_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Azulanite ingot
    public static final RegistryObject<Item> AZULANITE_INGOT = ITEMS.register("azulanite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ventenium-Azulanite alloy
    public static final RegistryObject<Item> VENTENIUM_AZULANITE_ALLOY = ITEMS.register("ventenium_azulanite_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ruelanite alloys
    public static final RegistryObject<Item> RUELANITE_SPACONIUM_ALLOY = ITEMS.register("ruelanite_spaconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> RUELANITE_MAGICONIUM_ALLOY = ITEMS.register("ruelanite_magiconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> RUELANITE_ENERGETICUM_ALLOY = ITEMS.register("ruelanite_energeticum_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ventenium alloys
    public static final RegistryObject<Item> VENTENIUM_SPACONIUM_ALLOY = ITEMS.register("ventenium_spaconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> VENTENIUM_MAGICONIUM_ALLOY = ITEMS.register("ventenium_magiconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> VENTENIUM_ENERGETICUM_ALLOY = ITEMS.register("ventenium_energeticum_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Azulanite alloys
    public static final RegistryObject<Item> AZULANITE_SPACONIUM_ALLOY = ITEMS.register("azulanite_spaconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> AZULANITE_MAGICONIUM_ALLOY = ITEMS.register("azulanite_magiconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> AZULANITE_ENERGETICUM_ALLOY = ITEMS.register("azulanite_energeticum_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    //Ventenium-Azulanite ingot alloys
    public static final RegistryObject<Item> VENTENIUM_AZULANITE_SPACONIUM_ALLOY = ITEMS.register("ventenium_azulanite_spaconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> VENTENIUM_AZULANITE_MAGICONIUM_ALLOY = ITEMS.register("ventenium_azulanite_magiconium_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));
    public static final RegistryObject<Item> VENTENIUM_AZULANITE_ENERGETICUM_ALLOY = ITEMS.register("ventenium_azulanite_energeticum_alloy", () -> new Item(new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));

    //armors
    //Ventenium-Azulanite alloy armor
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_HELMET = ITEMS.register("ventenium_azulanite_helmet", () -> new VenteniumAzulaniteArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_CHESTPLATE = ITEMS.register("ventenium_azulanite_chestplate", () -> new VenteniumAzulaniteArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_LEGGINGS = ITEMS.register("ventenium_azulanite_leggings", () -> new VenteniumAzulaniteArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_BOOTS = ITEMS.register("ventenium_azulanite_boots", () -> new VenteniumAzulaniteArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_ENERGETICUM_HELMET = ITEMS.register("ventenium_azulanite_energeticum_helmet", () -> new VenteniumAzulaniteEnergeticumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_ENERGETICUM_CHESTPLATE = ITEMS.register("ventenium_azulanite_energeticum_chestplate", () -> new VenteniumAzulaniteEnergeticumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_ENERGETICUM_LEGGINGS = ITEMS.register("ventenium_azulanite_energeticum_leggings", () -> new VenteniumAzulaniteEnergeticumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_ENERGETICUM_BOOTS = ITEMS.register("ventenium_azulanite_energeticum_boots", () -> new VenteniumAzulaniteEnergeticumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_SPACONIUM_HELMET = ITEMS.register("ventenium_azulanite_spaconium_helmet", () -> new VenteniumAzulaniteSpaconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_SPACONIUM_CHESTPLATE = ITEMS.register("ventenium_azulanite_spaconium_chestplate", () -> new VenteniumAzulaniteSpaconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_SPACONIUM_LEGGINGS = ITEMS.register("ventenium_azulanite_spaconium_leggings", () -> new VenteniumAzulaniteSpaconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_SPACONIUM_BOOTS = ITEMS.register("ventenium_azulanite_spaconium_boots", () -> new VenteniumAzulaniteSpaconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_MAGICONIUM_HELMET = ITEMS.register("ventenium_azulanite_magiconium_helmet", () -> new VenteniumAzulaniteMagiconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_MAGICONIUM_CHESTPLATE = ITEMS.register("ventenium_azulanite_magiconium_chestplate", () -> new VenteniumAzulaniteMagiconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_MAGICONIUM_LEGGINGS = ITEMS.register("ventenium_azulanite_magiconium_leggings", () -> new VenteniumAzulaniteMagiconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_AZULANITE_MAGICONIUM_BOOTS = ITEMS.register("ventenium_azulanite_magiconium_boots", () -> new VenteniumAzulaniteMagiconiumArmor(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Ventenium Armor
    public static final RegistryObject<ArmorItem> VENTENIUM_HELMET = ITEMS.register("ventenium_helmet", () -> new VenteniumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_CHESTPLATE = ITEMS.register("ventenium_chestplate", () -> new VenteniumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_LEGGINGS = ITEMS.register("ventenium_leggings", () -> new VenteniumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_BOOTS = ITEMS.register("ventenium_boots", () -> new VenteniumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_ENERGETICUM_HELMET = ITEMS.register("ventenium_energeticum_helmet", () -> new VenteniumEnergeticumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_ENERGETICUM_CHESTPLATE = ITEMS.register("ventenium_energeticum_chestplate", () -> new VenteniumEnergeticumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_ENERGETICUM_LEGGINGS = ITEMS.register("ventenium_energeticum_leggings", () -> new VenteniumEnergeticumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_ENERGETICUM_BOOTS = ITEMS.register("ventenium_energeticum_boots", () -> new VenteniumEnergeticumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_SPACONIUM_HELMET = ITEMS.register("ventenium_spaconium_helmet", () -> new VenteniumSpaconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_SPACONIUM_CHESTPLATE = ITEMS.register("ventenium_spaconium_chestplate", () -> new VenteniumSpaconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_SPACONIUM_LEGGINGS = ITEMS.register("ventenium_spaconium_leggings", () -> new VenteniumSpaconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_SPACONIUM_BOOTS = ITEMS.register("ventenium_spaconium_boots", () -> new VenteniumSpaconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> VENTENIUM_MAGICONIUM_HELMET = ITEMS.register("ventenium_magiconium_helmet", () -> new VenteniumMagiconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_MAGICONIUM_CHESTPLATE = ITEMS.register("ventenium_magiconium_chestplate", () -> new VenteniumMagiconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_MAGICONIUM_LEGGINGS = ITEMS.register("ventenium_magiconium_leggings", () -> new VenteniumMagiconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> VENTENIUM_MAGICONIUM_BOOTS = ITEMS.register("ventenium_magiconium_boots", () -> new VenteniumMagiconiumArmor(ModArmorMaterials.VENTENIUM, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Azulanite armor
    public static final RegistryObject<ArmorItem> AZULANITE_HELMET = ITEMS.register("azulanite_helmet", () -> new AzulaniteArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_CHESTPLATE = ITEMS.register("azulanite_chestplate", () -> new AzulaniteArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_LEGGINGS = ITEMS.register("azulanite_leggings", () -> new AzulaniteArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_BOOTS = ITEMS.register("azulanite_boots", () -> new AzulaniteArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> AZULANITE_ENERGETICUM_HELMET = ITEMS.register("azulanite_energeticum_helmet", () -> new AzulaniteEnergeticumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_ENERGETICUM_CHESTPLATE = ITEMS.register("azulanite_energeticum_chestplate", () -> new AzulaniteEnergeticumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_ENERGETICUM_LEGGINGS = ITEMS.register("azulanite_energeticum_leggings", () -> new AzulaniteEnergeticumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_ENERGETICUM_BOOTS = ITEMS.register("azulanite_energeticum_boots", () -> new AzulaniteEnergeticumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> AZULANITE_SPACONIUM_HELMET = ITEMS.register("azulanite_spaconium_helmet", () -> new AzulaniteSpaconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_SPACONIUM_CHESTPLATE = ITEMS.register("azulanite_spaconium_chestplate", () -> new AzulaniteSpaconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_SPACONIUM_LEGGINGS = ITEMS.register("azulanite_spaconium_leggings", () -> new AzulaniteSpaconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_SPACONIUM_BOOTS = ITEMS.register("azulanite_spaconium_boots", () -> new AzulaniteSpaconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> AZULANITE_MAGICONIUM_HELMET = ITEMS.register("azulanite_magiconium_helmet", () -> new AzulaniteMagiconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_MAGICONIUM_CHESTPLATE = ITEMS.register("azulanite_magiconium_chestplate", () -> new AzulaniteMagiconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_MAGICONIUM_LEGGINGS = ITEMS.register("azulanite_magiconium_leggings", () -> new AzulaniteMagiconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> AZULANITE_MAGICONIUM_BOOTS = ITEMS.register("azulanite_magiconium_boots", () -> new AzulaniteMagiconiumArmor(ModArmorMaterials.AZULANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Gentinium armor
    public static final RegistryObject<ArmorItem> GENTINIUM_HELMET = ITEMS.register("gentinium_helmet", () -> new GentiniumArmor(ModArmorMaterials.GENTINIUM, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> GENTINIUM_CHESTPLATE = ITEMS.register("gentinium_chestplate", () -> new GentiniumArmor(ModArmorMaterials.GENTINIUM, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> GENTINIUM_LEGGINGS = ITEMS.register("gentinium_leggings", () -> new GentiniumArmor(ModArmorMaterials.GENTINIUM, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> GENTINIUM_BOOTS = ITEMS.register("gentinium_boots", () -> new GentiniumArmor(ModArmorMaterials.GENTINIUM, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Montenite armor
    public static final RegistryObject<ArmorItem> MONTENITE_HELMET = ITEMS.register("montenite_helmet", () -> new MonteniteArmor(ModArmorMaterials.MONTENITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> MONTENITE_CHESTPLATE = ITEMS.register("montenite_chestplate", () -> new MonteniteArmor(ModArmorMaterials.MONTENITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> MONTENITE_LEGGINGS = ITEMS.register("montenite_leggings", () -> new MonteniteArmor(ModArmorMaterials.MONTENITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> MONTENITE_BOOTS = ITEMS.register("montenite_boots", () -> new MonteniteArmor(ModArmorMaterials.MONTENITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Reclinite armor
    public static final RegistryObject<ArmorItem> RECLINITE_HELMET = ITEMS.register("reclinite_helmet", () -> new RecliniteArmor(ModArmorMaterials.RECLINITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RECLINITE_CHESTPLATE = ITEMS.register("reclinite_chestplate", () -> new RecliniteArmor(ModArmorMaterials.RECLINITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RECLINITE_LEGGINGS = ITEMS.register("reclinite_leggings", () -> new RecliniteArmor(ModArmorMaterials.RECLINITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RECLINITE_BOOTS = ITEMS.register("reclinite_boots", () -> new RecliniteArmor(ModArmorMaterials.RECLINITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    //Ruelanite armor
    public static final RegistryObject<ArmorItem> RUELANITE_HELMET = ITEMS.register("ruelanite_helmet", () -> new RuelaniteArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_CHESTPLATE = ITEMS.register("ruelanite_chestplate", () -> new RuelaniteArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_LEGGINGS = ITEMS.register("ruelanite_leggings", () -> new RuelaniteArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_BOOTS = ITEMS.register("ruelanite_boots", () -> new RuelaniteArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> RUELANITE_ENERGETICUM_HELMET = ITEMS.register("ruelanite_energeticum_helmet", () -> new RuelaniteEnergeticumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_ENERGETICUM_CHESTPLATE = ITEMS.register("ruelanite_energeticum_chestplate", () -> new RuelaniteEnergeticumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_ENERGETICUM_LEGGINGS = ITEMS.register("ruelanite_energeticum_leggings", () -> new RuelaniteEnergeticumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_ENERGETICUM_BOOTS = ITEMS.register("ruelanite_energeticum_boots", () -> new RuelaniteEnergeticumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> RUELANITE_SPACONIUM_HELMET = ITEMS.register("ruelanite_spaconium_helmet", () -> new RuelaniteSpaconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_SPACONIUM_CHESTPLATE = ITEMS.register("ruelanite_spaconium_chestplate", () -> new RuelaniteSpaconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_SPACONIUM_LEGGINGS = ITEMS.register("ruelanite_spaconium_leggings", () -> new RuelaniteSpaconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_SPACONIUM_BOOTS = ITEMS.register("ruelanite_spaconium_boots", () -> new RuelaniteSpaconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));

    public static final RegistryObject<ArmorItem> RUELANITE_MAGICONIUM_HELMET = ITEMS.register("ruelanite_magiconium_helmet", () -> new RuelaniteMagiconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_MAGICONIUM_CHESTPLATE = ITEMS.register("ruelanite_magiconium_chestplate", () -> new RuelaniteMagiconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_MAGICONIUM_LEGGINGS = ITEMS.register("ruelanite_magiconium_leggings", () -> new RuelaniteMagiconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));
    public static final RegistryObject<ArmorItem> RUELANITE_MAGICONIUM_BOOTS = ITEMS.register("ruelanite_magiconium_boots", () -> new RuelaniteMagiconiumArmor(ModArmorMaterials.RUELANITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_GEAR)));







}
