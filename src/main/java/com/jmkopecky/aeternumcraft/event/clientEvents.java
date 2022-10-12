package com.jmkopecky.aeternumcraft.event;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.client.ManaHudOverlay;
import com.jmkopecky.aeternumcraft.networking.KeypressFireAbilityPacketCS;
import com.jmkopecky.aeternumcraft.networking.ModMessages;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.level.Level;
import net.minecraft.world.ticks.TickAccess;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = AeternumCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class clientEvents {
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("mana", ManaHudOverlay.HUD_MANA);
    }
    private static final KeyMapping fireAbilityKey = new KeyMapping("key.abilityfire", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KeyMapping.CATEGORY_GAMEPLAY);

    @SubscribeEvent
    public static void registerKeyBinds(RegisterKeyMappingsEvent event) {
        event.register(fireAbilityKey);
    }


    @Mod.EventBusSubscriber(modid = AeternumCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class KeyHandler {

        static boolean hasFired = false; //determines if it can fire again when unpressing the button
        static boolean hasFiredNotStopped = true; //determines if it can fire again after already firing if you hold the key down.
        @SubscribeEvent
        public static void keyEvent(InputEvent.Key event) {
            /*
            System that runs once per key press. Send a packet on click  and a packet on unpress.
             */
            if (fireAbilityKey.isDown()&&(!hasFired)&&(!hasFiredNotStopped)) {
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(true));
                hasFired = true;
                hasFiredNotStopped = true;
            } else if (fireAbilityKey.isDown()&&hasFiredNotStopped) {
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(false));
                hasFiredNotStopped = false;
            } else if ((!fireAbilityKey.isDown())&&hasFired) {
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(false));
                hasFired = false;
                hasFiredNotStopped = false;
            } else if ((!fireAbilityKey.isDown())&&hasFiredNotStopped) { //fixes a wierd bug that has the spell constantly firing on login.
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(false));
                hasFired = false;
                hasFiredNotStopped = false;
            }
        }
    }
}
