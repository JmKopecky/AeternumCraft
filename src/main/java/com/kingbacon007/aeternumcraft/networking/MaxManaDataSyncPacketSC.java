package com.kingbacon007.aeternumcraft.networking;

import com.kingbacon007.aeternumcraft.client.ClientCurrentManaData;
import com.kingbacon007.aeternumcraft.client.ClientCurrentMaxManaData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MaxManaDataSyncPacketSC {

    private final float maxMana;


    public MaxManaDataSyncPacketSC(float maxMana) {
        this.maxMana = maxMana;
    }
    public MaxManaDataSyncPacketSC(FriendlyByteBuf buf) {
        this.maxMana = buf.readFloat();
    }
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(maxMana);

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientCurrentMaxManaData.setPlayerMaxMana(maxMana);

        });
        return true;
    }

}
