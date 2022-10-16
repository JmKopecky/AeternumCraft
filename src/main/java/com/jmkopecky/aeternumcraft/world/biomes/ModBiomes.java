package com.jmkopecky.aeternumcraft.world.biomes;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBiomes {




    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, AeternumCraft.MODID);

    public static final ResourceKey<Biome> ASHEN_PLAINS = registerBiome("ashen_plains");
    public static final ResourceKey<Biome> ASHEN_FOREST = registerBiome("ashen_forest");
    public static final ResourceKey<Biome> CHARRED_FOREST = registerBiome("charred_forest");
    public static final ResourceKey<Biome> CHARRED_PLAINS = registerBiome("charred_plains");
    public static final ResourceKey<Biome> CLOUDY_PLAINS = registerBiome("cloudy_plains");
    public static final ResourceKey<Biome> CRYSTAL_ICE_FIELDS = registerBiome("crystal_ice_fields");
    public static final ResourceKey<Biome> ICY_PLAINS = registerBiome("icy_plains");
    public static final ResourceKey<Biome> MOLTEN_PLAINS = registerBiome("molten_plains");
    public static final ResourceKey<Biome> VOLCANIC_MOUNTAINS = registerBiome("volcanic_wastes");
    public static final ResourceKey<Biome> EARTHY_PLAINS = registerBiome("earthy_plains");
    public static final ResourceKey<Biome> EARTHY_SNOW_TIPPED_MOUNTAINS = registerBiome("earthy_snow_tipped_mountains");
    public static final ResourceKey<Biome> ELEMENTAL_OCEAN_COLD = registerBiome("elemental_ocean_cold");
    public static final ResourceKey<Biome> ELEMENTAL_OCEAN_DEEP_COLD = registerBiome("elemental_ocean_deep_cold");
    public static final ResourceKey<Biome> ELEMENTAL_OCEAN_WARM = registerBiome("elemental_ocean_warm");
    public static final ResourceKey<Biome> ELEMENTAL_OCEAN_DEEP_WARM = registerBiome("elemental_ocean_deep_warm");

    private static ResourceKey<Biome> registerBiome(String name) {
        BIOMES.register(name, OverworldBiomes::theVoid);
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(AeternumCraft.MODID, name));
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }




}