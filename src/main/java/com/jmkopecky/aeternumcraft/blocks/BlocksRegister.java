package com.jmkopecky.aeternumcraft.blocks;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.blocks.custom.SpellUnlockTableBlock;
import com.jmkopecky.aeternumcraft.items.CreativeModeItemTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

import static com.jmkopecky.aeternumcraft.items.ItemsRegister.ITEMS;

public class BlocksRegister {


    //create the light levels:
    public static ToIntFunction<BlockState> lightLevel15 = BlockState -> 15;
    public static ToIntFunction<BlockState> lightLevel14 = BlockState -> 14;
    public static ToIntFunction<BlockState> lightLevel13 = BlockState -> 13;
    public static ToIntFunction<BlockState> lightLevel12 = BlockState -> 12;
    public static ToIntFunction<BlockState> lightLevel11 = BlockState -> 11;
    public static ToIntFunction<BlockState> lightLevel10 = BlockState -> 10;
    public static ToIntFunction<BlockState> lightLevel9 = BlockState -> 9;
    public static ToIntFunction<BlockState> lightLevel8 = BlockState -> 8;
    public static ToIntFunction<BlockState> lightLevel7 = BlockState -> 7;
    public static ToIntFunction<BlockState> lightLevel6 = BlockState -> 6;
    public static ToIntFunction<BlockState> lightLevel5 = BlockState -> 5;
    public static ToIntFunction<BlockState> lightLevel4 = BlockState -> 4;
    public static ToIntFunction<BlockState> lightLevel3 = BlockState -> 3;
    public static ToIntFunction<BlockState> lightLevel2 = BlockState -> 2;
    public static ToIntFunction<BlockState> lightLevel1 = BlockState -> 1;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AeternumCraft.MODID);

    //Hardlight Block
    public static final RegistryObject<Block> HARDLIGHT_BLOCK = BLOCKS.register("hardlight_block" , () -> new Block(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS).lightLevel(lightLevel15).strength(10F).explosionResistance(10F).noDrops()));
    public static final RegistryObject<Item> HARDLIGHT_BLOCK_ITEM = ITEMS.register("hardlight_block_item" , () -> new BlockItem(HARDLIGHT_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Cloud Block
    public static  final RegistryObject<Block> MAGIC_CLOUD_BLOCK = BLOCKS.register("magic_cloud_block", () -> new Block(BlockBehaviour.Properties.of(Material.WEB).strength(0.5F).explosionResistance(0.3F).lightLevel(lightLevel2).noDrops().jumpFactor(2F).speedFactor(2F)));
    public static final RegistryObject<Item> MAGIC_CLOUD_BLOCK_ITEM = ITEMS.register("magic_cloud_block_item" , () -> new BlockItem(MAGIC_CLOUD_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Earth Block
    public static  final RegistryObject<Block> MAGIC_EARTH_BLOCK = BLOCKS.register("magic_earth_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4F).explosionResistance(6F).noDrops()));
    public static final RegistryObject<Item> MAGIC_EARTH_BLOCK_ITEM = ITEMS.register("magic_earth_block_item" , () -> new BlockItem(MAGIC_EARTH_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Fire Block
    public static  final RegistryObject<Block> MAGIC_FIRE_BLOCK = BLOCKS.register("magic_fire_block", () -> new Block(BlockBehaviour.Properties.of(Material.FIRE).lightLevel(lightLevel10).strength(3F).explosionResistance(3F).friction(2F).noDrops()));
    public static final RegistryObject<Item> MAGIC_FIRE_BLOCK_ITEM = ITEMS.register("magic_fire_block_item" , () -> new BlockItem(MAGIC_FIRE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Space Block
    public static  final RegistryObject<Block> MAGIC_SPACE_BLOCK = BLOCKS.register("magic_space_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(lightLevel10).strength(8F).explosionResistance(200F).speedFactor(2F).noDrops()));
    public static final RegistryObject<Item> MAGIC_SPACE_BLOCK_ITEM = ITEMS.register("magic_space_block_item" , () -> new BlockItem(MAGIC_SPACE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Stabilized Water
    public static  final RegistryObject<Block> MAGIC_STABILIZED_WATER = BLOCKS.register("magic_stabilized_water", () -> new Block(BlockBehaviour.Properties.of(Material.ICE_SOLID).strength(2F).explosionResistance(8F).speedFactor(1.5F).noDrops()));
    public static final RegistryObject<Item> MAGIC_STABILIZED_WATER_ITEM = ITEMS.register("magic_stabilized_water_item" , () -> new BlockItem(MAGIC_STABILIZED_WATER.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Stabilized Magic Block
    public static  final RegistryObject<Block> STABILIZED_MAGIC_BLOCK = BLOCKS.register("stabilized_magic_block", () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).lightLevel(lightLevel10).strength(15F).explosionResistance(150F).noDrops()));
    public static final RegistryObject<Item> STABILIZED_MAGIC_BLOCK_ITEM = ITEMS.register("stabilized_magic_block_item" , () -> new BlockItem(STABILIZED_MAGIC_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Elemental Stone Block
    public static final RegistryObject<Block> ELEMENTAL_STONE_BLOCK = BLOCKS.register("elemental_stone_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_STONE_BLOCK_ITEM = ITEMS.register("elemental_stone_block_item", () -> new BlockItem(ELEMENTAL_STONE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Elemental Dimension Blocks
    public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(2F).explosionResistance(3F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ASH_BLOCK_ITEM = ITEMS.register("ash_block_item", () -> new BlockItem(ASH_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> CHARRED_ASH_BLOCK = BLOCKS.register("charred_ash_block", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(3F).explosionResistance(4F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> CHARRED_ASH_BLOCK_ITEM = ITEMS.register("charred_ash_block_item", () -> new BlockItem(CHARRED_ASH_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> CHARRED_LOG_BLOCK = BLOCKS.register("charred_log_block", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(3F).explosionResistance(4F)));
    public static final RegistryObject<Item> CHARRED_LOG_BLOCK_ITEM = ITEMS.register("charred_log_block_item", () -> new BlockItem(CHARRED_LOG_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> CLOUDY_BLOCK = BLOCKS.register("cloudy_block", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(1F).explosionResistance(1F)));
    public static final RegistryObject<Item> CLOUDY_BLOCK_ITEM = ITEMS.register("cloudy_block_item", () -> new BlockItem(CLOUDY_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> CRYSTALIZED_ICE_BLOCK = BLOCKS.register("crystalized_ice_block", () -> new Block(BlockBehaviour.Properties.of(Material.ICE_SOLID).strength(2F).explosionResistance(2F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> CRYSTALIZED_ICE_BLOCK_ITEM = ITEMS.register("crystalized_ice_block_item", () -> new BlockItem(CRYSTALIZED_ICE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> EARTHY_GRASS_BLOCK = BLOCKS.register("earthy_grass_block", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(2F).explosionResistance(5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> EARTHY_GRASS_BLOCK_ITEM = ITEMS.register("earthy_grass_block_item", () -> new BlockItem(EARTHY_GRASS_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> FLAMING_SOOT_BLOCK = BLOCKS.register("flaming_soot_block", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(2F).explosionResistance(4F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> FLAMING_SOOT_BLOCK_ITEM = ITEMS.register("flaming_soot_block_item", () -> new BlockItem(FLAMING_SOOT_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Elemental Ores
    public static final RegistryObject<Block> ELEMENTAL_GENTENIUM_ORE = BLOCKS.register("elemental_gentenium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_GENTENIUM_ORE_ITEM = ITEMS.register("elemental_gentenium_ore_item", () -> new BlockItem(ELEMENTAL_GENTENIUM_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> ELEMENTAL_MONTENITE_ORE = BLOCKS.register("elemental_montenite_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_MONTENITE_ORE_ITEM = ITEMS.register("elemental_montenite_ore_item", () -> new BlockItem(ELEMENTAL_MONTENITE_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> ELEMENTAL_RECLINITE_ORE = BLOCKS.register("elemental_reclinite_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_RECLINITE_ORE_ITEM = ITEMS.register("elemental_reclinite_ore_item", () -> new BlockItem(ELEMENTAL_RECLINITE_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> ELEMENTAL_RUELANITE_ORE = BLOCKS.register("elemental_ruelanite_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_RUELANITE_ORE_ITEM = ITEMS.register("elemental_ruelanite_ore_item", () -> new BlockItem(ELEMENTAL_RUELANITE_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> ELEMENTAL_VENTENIUM_ORE = BLOCKS.register("elemental_ventenium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(100F).lightLevel(lightLevel10).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_VENTENIUM_ORE_ITEM = ITEMS.register("elemental_ventenium_ore_item", () -> new BlockItem(ELEMENTAL_VENTENIUM_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> ELEMENTAL_AZULANITE_ORE = BLOCKS.register("elemental_azulanite_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).explosionResistance(100F).lightLevel(lightLevel12).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> ELEMENTAL_AZULANITE_ORE_ITEM = ITEMS.register("elemental_azulanite_ore_item", () -> new BlockItem(ELEMENTAL_AZULANITE_ORE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    public static final RegistryObject<Block> SPELL_UNLOCK_TABLE = BLOCKS.register("spell_unlock_table", () -> new SpellUnlockTableBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4F).explosionResistance(10F).lightLevel(lightLevel15).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Item> SPELL_UNLOCK_TABLE_BLOCK = ITEMS.register("spell_unlock_table_item", () -> new BlockItem(SPELL_UNLOCK_TABLE.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));



}
