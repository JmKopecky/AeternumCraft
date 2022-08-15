package com.kingbacon007.aeternumcraft.items;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.items.custom.ModArmorMaterials;
import com.kingbacon007.aeternumcraft.items.custom.VenteniumAzulaniteArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AeternumCraft.MODID);

    //demo Armor for testing
    public static final RegistryObject<Item> DEMO_ARMOR = ITEMS.register("demo_armor_helmet", () -> new VenteniumAzulaniteArmorItem(ModArmorMaterials.VENTENIUM_AZULANITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_ITEMS)));

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
}
