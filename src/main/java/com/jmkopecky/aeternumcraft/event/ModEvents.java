package com.jmkopecky.aeternumcraft.event;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.spellComponents.DetonateSpellComponent;
import com.jmkopecky.aeternumcraft.abilities.spellComponents.MassiveInfernalExplosionSpellComponent;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import com.jmkopecky.aeternumcraft.networking.ManaDataSyncPacketSC;
import com.jmkopecky.aeternumcraft.networking.MaxManaDataSyncPacketSC;
import com.jmkopecky.aeternumcraft.networking.ModMessages;
import com.jmkopecky.aeternumcraft.playerstats.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.units.qual.Mass;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = AeternumCraft.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) {
                event.addCapability(new ResourceLocation(AeternumCraft.MODID, "properties_mana"), new PlayerManaProvider());
            }
            if (!event.getObject().getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).isPresent()) {
                event.addCapability(new ResourceLocation(AeternumCraft.MODID, "properties_abilities"), new PlayerAbilityProvider());
            }
            if (!event.getObject().getCapability(PlayerTraitProvider.PLAYER_TRAITS).isPresent()) {
                event.addCapability(new ResourceLocation(AeternumCraft.MODID, "properties_traits"), new PlayerTraitProvider());
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
                    ModMessages.sendToPlayer(new MaxManaDataSyncPacketSC(newPlayer.getMAX_MANA()), (ServerPlayer) event.getEntity());
                    ModMessages.sendToPlayer(new ManaDataSyncPacketSC(newPlayer.getManaCount()), (ServerPlayer) event.getEntity());
                });
            });
            event.getOriginal().getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(original -> {
                event.getEntity().getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(newPlayer -> {
                    newPlayer.copyFrom(original);
                });
            });
            event.getOriginal().getCapability(PlayerTraitProvider.PLAYER_TRAITS).ifPresent(original -> {
                event.getEntity().getCapability(PlayerTraitProvider.PLAYER_TRAITS).ifPresent(newPlayer -> {
                    newPlayer.copyFrom(original);
                    event.getEntity().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                        mana.setMAX_MANA(newPlayer.getBonusFromTrait(mana.getDefaultMAXMANA(), "magical_wisdom", "manaMaxBonus"));
                        mana.setMANA_REGEN(newPlayer.getBonusFromTrait(mana.getDefaultMANAREGEN(), "magical_wisdom", "manaRegenBonus"));
                    });
                });
            });
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMana.class);
        event.register(PlayerAbilities.class);
        event.register(PlayerTraits.class);
    }
    //counter for tick to second system
    private static int counterMana = 0;
    private static boolean hasInitialMaxManaPacketSent = false;
    private static int counterSpellFire = 0;
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
                        if (counterMana == 10) {
                            if (mana.getManaCount() < mana.getMAX_MANA()) {
                                if (event.player.hasEffect(EffectsRegister.ManaRegenBoost.get())) {
                                    float regenAmplifier = event.player.getEffect(EffectsRegister.ManaRegenBoost.get()).getAmplifier();
                                    mana.regenMANA_COUNT(2F, regenAmplifier * 5);
                                    counterMana = 0;
                                    ModMessages.sendToPlayer(new ManaDataSyncPacketSC(mana.getManaCount()), (ServerPlayer) event.player);
                                } else if (event.player.hasEffect(EffectsRegister.ManaExhaustion.get())) {
                                    float deductionAmplifier = event.player.getEffect(EffectsRegister.ManaExhaustion.get()).getAmplifier();
                                    mana.regenMANA_COUNT(2, deductionAmplifier * -3);
                                    counterMana = 0;
                                    ModMessages.sendToPlayer(new ManaDataSyncPacketSC(mana.getManaCount()), (ServerPlayer) event.player);
                                } else {
                                    mana.regenMANA_COUNT(2, 0);
                                    counterMana = 0;
                                    ModMessages.sendToPlayer(new ManaDataSyncPacketSC(mana.getManaCount()), (ServerPlayer) event.player);
                                }
                            }
                        } else {
                            counterMana += 1;
                        }
                });

                event.player.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(abilities -> {
                    if (counterSpellFire < 20) {
                        counterSpellFire += 1;
                    } else if (counterSpellFire == 20) {
                        if (abilities.getIsFiring()) {
                            abilities.fireAtCurrentSlot(event.player);
                            counterSpellFire = 0;
                        }
                    } else {
                        System.out.println("ModEvents.counterSpellFire is " + counterSpellFire);
                    }
                });
            }
        }
    }
}
