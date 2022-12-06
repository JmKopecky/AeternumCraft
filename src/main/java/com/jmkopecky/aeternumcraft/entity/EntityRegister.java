package com.jmkopecky.aeternumcraft.entity;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellBurstProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellScatterBurstProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellScatterProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegister {
    public static DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, AeternumCraft.MODID);

    public static final RegistryObject<EntityType<SpellProjectile>> SPELL_PROJECTILE = ENTITY_REGISTER.register("spell_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpellProjectile>) SpellProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spell_projectile"));

    public static final RegistryObject<EntityType<SpellBurstProjectile>> SPELL_BURST_PROJECTILE = ENTITY_REGISTER.register("spell_burst_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpellBurstProjectile>) SpellBurstProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spell_burst_projectile"));

    public static final RegistryObject<EntityType<SpellScatterProjectile>> SPELL_SCATTER_PROJECTILE = ENTITY_REGISTER.register("spell_scatter_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpellScatterProjectile>) SpellScatterProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spell_scatter_projectile"));

    public static final RegistryObject<EntityType<SpellScatterBurstProjectile>> SPELL_SCATTER_BURST_PROJECTILE = ENTITY_REGISTER.register("spell_scatter_burst_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpellScatterBurstProjectile>) SpellScatterBurstProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spell_scatter_burst_projectile"));

}
