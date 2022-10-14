package com.jmkopecky.aeternumcraft.items;


import com.jmkopecky.aeternumcraft.blocks.BlocksRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeItemTabs {

    public static final CreativeModeTab AETERNUMCRAFT_BLOCKS = new CreativeModeTab("aeternumcraft_block_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlocksRegister.HARDLIGHT_BLOCK_ITEM.get());
        }
    };
    public static final CreativeModeTab AETERNUMCRAFT_ITEMS = new CreativeModeTab("aeternumcraft_item_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegister.ENERGETICUM_INGOT.get());
        }
    };

    public static final CreativeModeTab AETERNUMCRAFT_GEAR = new CreativeModeTab("aeternumcraft_gear_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegister.VENTENIUM_AZULANITE_CHESTPLATE.get());
        }
    };
}
