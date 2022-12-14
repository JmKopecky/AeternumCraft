package com.kingbacon007.aeternumcraft.entity;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.kingbacon007.aeternumcraft.abilities.SpellProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpellProjectileRenderer extends ArrowRenderer<SpellProjectile> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AeternumCraft.MODID, "textures/entity/spell_projectile.png");

    public SpellProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(SpellProjectile spell) {
        return TEXTURE;
    }
}
