package com.kingbacon007.aeternumcraft.playerstats;

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

import java.lang.reflect.InvocationTargetException;

public class PlayerAbilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerAbilities> PLAYER_ABILITIES = CapabilityManager.get(new CapabilityToken<PlayerAbilities>() {});

    private PlayerAbilities abilities = null;
    private final LazyOptional<PlayerAbilities> optional = LazyOptional.of(this::createPlayerAbilities);

    private PlayerAbilities createPlayerAbilities() {
        if (this.abilities == null) {
            this.abilities = new PlayerAbilities();
        }
        return this.abilities;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap==PLAYER_ABILITIES) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerAbilities().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerAbilities().loadNBTData(nbt);
    }
}
