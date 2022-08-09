package com.kingbacon007.aeternumcraft.networking;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;
    private static int id() {
        return packetID++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(AeternumCraft.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ManaDataSyncPacketSC.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ManaDataSyncPacketSC::new)
                .encoder(ManaDataSyncPacketSC::toBytes)
                .consumerMainThread(ManaDataSyncPacketSC::handle)
                .add();

        net.messageBuilder(MaxManaDataSyncPacketSC.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(MaxManaDataSyncPacketSC::new)
                .encoder(MaxManaDataSyncPacketSC::toBytes)
                .consumerMainThread(MaxManaDataSyncPacketSC::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
