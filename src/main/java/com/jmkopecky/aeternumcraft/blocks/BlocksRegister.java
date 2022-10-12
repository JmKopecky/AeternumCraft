package com.jmkopecky.aeternumcraft.blocks;

import com.jmkopecky.aeternumcraft.AeternumCraft;
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


    //create the light level:
    public static ToIntFunction<BlockState> lightLevel15 = BlockState -> 15;
    public static ToIntFunction<BlockState> lightLevel10 = BlockState -> 10;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AeternumCraft.MODID);

//Hardlight Block
    public static final RegistryObject<Block> HARDLIGHT_BLOCK = BLOCKS.register("hardlight_block" , () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel(lightLevel15)));
    public static final RegistryObject<Item> HARDLIGHT_BLOCK_ITEM = ITEMS.register("hardlight_block_item" , () -> new BlockItem(HARDLIGHT_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Cloud Block
    public static  final RegistryObject<Block> MAGIC_CLOUD_BLOCK = BLOCKS.register("magic_cloud_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<Item> MAGIC_CLOUD_BLOCK_ITEM = ITEMS.register("magic_cloud_block_item" , () -> new BlockItem(MAGIC_CLOUD_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Earth Block
    public static  final RegistryObject<Block> MAGIC_EARTH_BLOCK = BLOCKS.register("magic_earth_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(lightLevel10)));
    public static final RegistryObject<Item> MAGIC_EARTH_BLOCK_ITEM = ITEMS.register("magic_earth_block_item" , () -> new BlockItem(MAGIC_EARTH_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Fire Block
    public static  final RegistryObject<Block> MAGIC_FIRE_BLOCK = BLOCKS.register("magic_fire_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(lightLevel10)));
    public static final RegistryObject<Item> MAGIC_FIRE_BLOCK_ITEM = ITEMS.register("magic_fire_block_item" , () -> new BlockItem(MAGIC_FIRE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Space Block
    public static  final RegistryObject<Block> MAGIC_SPACE_BLOCK = BLOCKS.register("magic_space_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(lightLevel10)));
    public static final RegistryObject<Item> MAGIC_SPACE_BLOCK_ITEM = ITEMS.register("magic_space_block_item" , () -> new BlockItem(MAGIC_SPACE_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Magic Stabilized Water
    public static  final RegistryObject<Block> MAGIC_STABILIZED_WATER = BLOCKS.register("magic_stabilized_water", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<Item> MAGIC_STABILIZED_WATER_ITEM = ITEMS.register("magic_stabilized_water_item" , () -> new BlockItem(MAGIC_STABILIZED_WATER.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));

    //Stabilized Magic Block
    public static  final RegistryObject<Block> STABILIZED_MAGIC_BLOCK = BLOCKS.register("stabilized_magic_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(lightLevel10)));
    public static final RegistryObject<Item> STABILIZED_MAGIC_BLOCK_ITEM = ITEMS.register("stabilized_magic_block_item" , () -> new BlockItem(STABILIZED_MAGIC_BLOCK.get(), new Item.Properties().tab(CreativeModeItemTabs.AETERNUMCRAFT_BLOCKS)));



}
