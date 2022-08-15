package com.kingbacon007.aeternumcraft.event;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.networking.ManaDataSyncPacketSC;
import com.kingbacon007.aeternumcraft.networking.MaxManaDataSyncPacketSC;
import com.kingbacon007.aeternumcraft.networking.ModMessages;
import com.kingbacon007.aeternumcraft.playerstats.PlayerMana;
import com.kingbacon007.aeternumcraft.playerstats.PlayerManaProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.UUID;

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

    public static boolean hasPlayerDied = false;

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(original -> {
                event.getEntity().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newPlayer -> {
                    newPlayer.copyFrom(original);
                    ModMessages.sendToPlayer(new MaxManaDataSyncPacketSC(newPlayer.getMAX_MANA()), (ServerPlayer) event.getEntity());
                    ModMessages.sendToPlayer(new ManaDataSyncPacketSC(newPlayer.getManaCount()), (ServerPlayer) event.getEntity());
                });
            });
            hasPlayerDied = true;
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMana.class);
    }
    //counter for tick to second system
    private static int counter = 0;
    private static boolean hasInitialMaxManaPacketSent = false;
    //static AttributeModifier TEST = new AttributeModifier(UUID.randomUUID(), "test", 10.0D, AttributeModifier.Operation.ADDITION);


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            if (!hasInitialMaxManaPacketSent) {
                if (!event.player.isDeadOrDying()) {
                    //Objects.requireNonNull(event.player.getAttribute(Attributes.MAX_HEALTH)).addTransientModifier(TEST);
                    event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(PlayerManaCap -> {
                                ModMessages.sendToPlayer(new MaxManaDataSyncPacketSC(PlayerManaCap.getMAX_MANA()), (ServerPlayer) event.player);
                                ModMessages.sendToPlayer(new ManaDataSyncPacketSC(PlayerManaCap.getManaCount()), (ServerPlayer) event.player);
                        });
                    hasInitialMaxManaPacketSent = true;
                    }
            }
            if (!event.player.isDeadOrDying()) {
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    if (counter == 10) {
                        if (mana.getManaCount() < mana.getMAX_MANA()) {
                            mana.regenMANA_COUNT(2);
                            counter = 0;
                            ModMessages.sendToPlayer(new ManaDataSyncPacketSC(mana.getManaCount()), (ServerPlayer) event.player);
                        }

                    } else {
                        counter += 1;
                    }
                });
            }
        }
    }
}
