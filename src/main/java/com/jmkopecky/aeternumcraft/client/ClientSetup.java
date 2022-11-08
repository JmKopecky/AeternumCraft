package com.jmkopecky.aeternumcraft.client;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.entity.EntityRegister;
import com.jmkopecky.aeternumcraft.entity.SpellBurstProjectileRenderer;
import com.jmkopecky.aeternumcraft.entity.SpellProjectileRenderer;
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
        EntityRenderers.register(EntityRegister.SPELL_BURST_PROJECTILE.get(), SpellBurstProjectileRenderer::new);
    }
}