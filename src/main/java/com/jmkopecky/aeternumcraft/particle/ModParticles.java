package com.jmkopecky.aeternumcraft.particle;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AeternumCraft.MODID);

    public static final RegistryObject<SimpleParticleType> SPELL_TRAIL_PARTICLE =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("spell_trail_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SPELL_PROJECTILE_PARTICLE =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("spell_projectile_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SPELL_BURST_PROJECTILE_PARTICLE =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("spell_burst_projectile_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SPELL_BURST_TRAIL_PARTICLE =
            PARTICLE_TYPE_DEFERRED_REGISTER.register("spell_burst_trail_particle", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLE_TYPE_DEFERRED_REGISTER.register(eventBus);
    }

}
