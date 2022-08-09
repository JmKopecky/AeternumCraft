package com.kingbacon007.aeternumcraft.event;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.networking.ManaDataSyncPacketSC;
import com.kingbacon007.aeternumcraft.networking.ModMessages;
import com.kingbacon007.aeternumcraft.playerstats.PlayerMana;
import com.kingbacon007.aeternumcraft.playerstats.PlayerManaProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AeternumCraft.MODID)
public class ModEvents {


    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) {
                event.addCapability(new ResourceLocation(AeternumCraft.MODID, "properties"), new PlayerManaProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(original -> {
                event.getEntity().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newPlayer -> {
                    newPlayer.copyFrom(original);
                });
            });
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMana.class);
    }
    //counter for tick to second system
    private static int counter = 0;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            if (!(event.player.isDeadOrDying())) {
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    if (mana.getManaCount() != mana.getMAX_MANA())
                        if (counter == 10) {
                            mana.regenMANA_COUNT(2);
                            counter = 0;
                            ModMessages.sendToPlayer(new ManaDataSyncPacketSC(mana.getManaCount()), (ServerPlayer) event.player);

                        } else {
                            counter++;
                        }
                });
            }
        }
    }
}
