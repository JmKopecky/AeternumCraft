package com.jmkopecky.aeternumcraft.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final ForgeTier GENTENIUM_TIER = new ForgeTier(5, 2250, 10, 6, 20, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.GENTINIUM_INGOT.get()));
    public static final ForgeTier MONTENITE_TIER = new ForgeTier(5, 2500, 11, 8, 21, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.MONTENITE_INGOT.get()));
    public static final ForgeTier RECLINITE_TIER = new ForgeTier(6, 2750, 12, 10, 22, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.RECLINITE_INGOT.get()));
    public static final ForgeTier RUELANITE_TIER = new ForgeTier(6, 3000, 13, 12, 23, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.RUELANITE_INGOT.get()));
    public static final ForgeTier AZULANITE_TIER = new ForgeTier(7, 3250, 14, 15, 24, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.AZULANITE_INGOT.get()));
    public static final ForgeTier VENTENIUM_TIER = new ForgeTier(8, 3500, 15, 18, 28, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.VENTENIUM_INGOT.get()));
    public static final ForgeTier VENTENIUM_AZULANITE_TIER = new ForgeTier(10, 5000, 18, 22, 35, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemsRegister.VENTENIUM_AZULANITE_ALLOY.get()));
}
