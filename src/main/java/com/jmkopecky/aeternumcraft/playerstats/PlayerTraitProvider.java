package com.jmkopecky.aeternumcraft.playerstats;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerTraitProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerTraits> PLAYER_TRAITS = CapabilityManager.get(new CapabilityToken<PlayerTraits>() {});

    private PlayerTraits traits = null;
    private final LazyOptional<PlayerTraits> optional = LazyOptional.of(this::createPlayerTraits);

    private PlayerTraits createPlayerTraits() {
        if (this.traits == null) {
            this.traits = new PlayerTraits();
        }
        return this.traits;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap==PLAYER_TRAITS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerTraits().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerTraits().loadNBTData(nbt);
    }
}
