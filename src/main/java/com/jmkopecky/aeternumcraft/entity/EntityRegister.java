package com.jmkopecky.aeternumcraft.entity;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.SpellProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegister {
    public static DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, AeternumCraft.MODID);

    public static final RegistryObject<EntityType<SpellProjectile>> SPELL_PROJECTILE = ENTITY_REGISTER.register("spell_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpellProjectile>) SpellProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spell_projectile"));

}
