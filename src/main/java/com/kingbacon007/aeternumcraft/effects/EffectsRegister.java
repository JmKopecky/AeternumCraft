package com.kingbacon007.aeternumcraft.effects;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsRegister {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AeternumCraft.MODID);

    public static final RegistryObject<MobEffect> STASIS = EFFECT.register("stasis", () -> new StasisEffect(MobEffectCategory.HARMFUL, 3124687));
    public static void registerEffect(IEventBus eventBus) {
        EFFECT.register(eventBus);
    }
}
