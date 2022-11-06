package com.jmkopecky.aeternumcraft;

import com.jmkopecky.aeternumcraft.blocks.BlocksRegister;
import com.jmkopecky.aeternumcraft.effects.EffectsRegister;
import com.jmkopecky.aeternumcraft.enchantment.ModEnchantments;
import com.jmkopecky.aeternumcraft.entity.EntityRegister;
import com.jmkopecky.aeternumcraft.networking.ModMessages;
import com.jmkopecky.aeternumcraft.particle.ModParticles;
import com.jmkopecky.aeternumcraft.world.biomes.ModBiomes;
import com.jmkopecky.aeternumcraft.world.dimensions.ModDimensions;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import static com.jmkopecky.aeternumcraft.blocks.BlocksRegister.BLOCKS;
import static com.jmkopecky.aeternumcraft.items.ItemsRegister.ITEMS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AeternumCraft.MODID)
public class AeternumCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "aeternumcraft";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public static void log(String toLog, String type) {
        //Logs the "toLog" string based on the "type" string
        switch (type) {
            case "Debug" -> LOGGER.debug(toLog);
            case "Info" -> LOGGER.info(toLog);
            case "Warning" -> LOGGER.warn(toLog);
            case "Error" -> LOGGER.error(toLog);
            default -> LOGGER.error("Error trying to log the string: " + toLog + " | Caused by the provided log type being unrecognized. " + type);
        }
    }



    public AeternumCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so entities get registered
        EntityRegister.ENTITY_REGISTER.register(modEventBus);
        // Register particles
        ModParticles.register(modEventBus);
        // Register the Deferred Register to the mod event bus so effects get registered
        EffectsRegister.registerEffect(modEventBus);
        // Register the Deferred Register to the mod event bus so enchantments get registered
        ModEnchantments.register(modEventBus);
        // Register Biomes
        ModBiomes.register(modEventBus);

        ModDimensions.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ModMessages.register();
        log("Common Setup has completed for Aeternumcraft.", "Info");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        log("Server starting for Aeternumcraft.", "Info");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(BlocksRegister.SPELL_UNLOCK_TABLE.get(), RenderType.translucent());
            // Some client setup code
            log("Client Setup has completed for Aeternumcraft.", "Info");
        }
    }
}
