package com.kingbacon007.aeternumcraft.client;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.entity.EntityRegister;
import com.kingbacon007.aeternumcraft.entity.SpellProjectileRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AeternumCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegister.SPELL_PROJECTILE.get(), SpellProjectileRenderer::new);
    }
}