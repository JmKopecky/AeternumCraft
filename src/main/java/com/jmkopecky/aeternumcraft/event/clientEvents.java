package com.jmkopecky.aeternumcraft.event;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.client.ManaHudDisplay;
import com.jmkopecky.aeternumcraft.networking.KeypressFireAbilityPacketCS;
import com.jmkopecky.aeternumcraft.networking.ModMessages;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = AeternumCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class clientEvents {

    @SubscribeEvent
    public static void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ManaHudDisplay.renderBar();
        }
    }

    //Keybindings
    private static final KeyMapping fireAbilityKey = new KeyMapping("key.abilityfire", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KeyMapping.CATEGORY_GAMEPLAY);

    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(fireAbilityKey);
    }


    @Mod.EventBusSubscriber(modid = AeternumCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class KeyHandler {

        static boolean hasFired = false; //determines if it can fire again when unpressing the button
        static boolean hasFiredNotStopped = true; //determines if it can fire again after already firing if you hold the key down.
        @SubscribeEvent
        public static void keyEvent(InputEvent.KeyInputEvent event) {


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
