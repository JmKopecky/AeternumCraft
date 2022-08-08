package com.kingbacon007.aeternumcraft.networking;

import com.kingbacon007.aeternumcraft.client.ClientCurrentManaData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ManaDataSyncPacketSC {

    private final float mana;


    public ManaDataSyncPacketSC(float mana) {
        this.mana = mana;
    }
    public ManaDataSyncPacketSC(FriendlyByteBuf buf) {
        this.mana = buf.readFloat();
    }
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(mana);

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientCurrentManaData.setMana(mana);

        });
        return true;
    }
}
