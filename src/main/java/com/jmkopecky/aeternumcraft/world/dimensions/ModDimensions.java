package com.jmkopecky.aeternumcraft.world.dimensions;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {




    public static final ResourceKey<Level> ELEMENTA_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(AeternumCraft.MODID, "elementa_dim"));

    public static final ResourceKey<DimensionType> ELEMENTA_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, ELEMENTA_KEY.getRegistryName());

    public static void register() {
        System.out.println("Registering dimensions for mod: " + AeternumCraft.MODID);
    }


}
