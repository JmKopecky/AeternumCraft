package com.jmkopecky.aeternumcraft.networking;

import com.jmkopecky.aeternumcraft.client.ClientCurrentManaData;
import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class KeypressFireAbilityPacketCS {
    private final boolean isPressed;


    public KeypressFireAbilityPacketCS(boolean isPressed) {
        this.isPressed = isPressed;
    }
    public KeypressFireAbilityPacketCS(FriendlyByteBuf buf) {
        this.isPressed = buf.readBoolean();
    }
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(isPressed);

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        supplier.get().getSender().getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(playerCap -> {
            playerCap.setIsFiring(isPressed);
        });
        });
        return true;
    }
}
