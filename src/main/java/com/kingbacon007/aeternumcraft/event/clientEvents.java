package com.kingbacon007.aeternumcraft.event;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.client.ManaHudOverlay;
import com.kingbacon007.aeternumcraft.networking.KeypressFireAbilityPacketCS;
import com.kingbacon007.aeternumcraft.networking.ModMessages;
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

        @SubscribeEvent
        public static void keyEvent(InputEvent.Key event) {
            if (fireAbilityKey.isDown()) {
                System.out.println("Successfully detected key press");
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(true));
            } else {
                ModMessages.sendToServer(new KeypressFireAbilityPacketCS(false));
            }
        }
    }
}
