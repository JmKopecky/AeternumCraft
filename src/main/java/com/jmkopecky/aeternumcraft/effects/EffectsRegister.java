package com.jmkopecky.aeternumcraft.effects;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsRegister {

    static String antigravityUUID = "7a0f334e-41e0-488c-a27c-650e0a89dba8";
    static String hypergravityUUID = "4a5ac8eb-960c-41ba-89bd-af77b03a0249";

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AeternumCraft.MODID);

    public static final RegistryObject<MobEffect> STASIS = EFFECT.register("stasis", () -> new StasisEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> DRAIN = EFFECT.register("drain", () -> new DrainHealthEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> DOOM = EFFECT.register("doom", () -> new DoomEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> StrikePeriodically = EFFECT.register("strikeperiodically", () -> new StrikePeriodicallyEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> ExplodePeriodically = EFFECT.register("explodeperiodically", () -> new ExplodePeriodicallyEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> ManaExhaustion = EFFECT.register("manaexhaustion", () -> new ManaExhaustionEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> ManaRegenBoost = EFFECT.register("manaregenboost", () -> new ManaRegenBoostEffect(MobEffectCategory.BENEFICIAL, 3124687));
    public static final RegistryObject<MobEffect> Antigravity = EFFECT.register("antigravity", () -> new AntigravityEffect(MobEffectCategory.NEUTRAL, 3124687).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), antigravityUUID, -0.1 , AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> HyperGravity = EFFECT.register("hypergravity", () -> new HyperGravityEffect(MobEffectCategory.NEUTRAL, 3124687).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), hypergravityUUID, 0.1 , AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static void registerEffect(IEventBus eventBus) {
        EFFECT.register(eventBus);
    }
}
