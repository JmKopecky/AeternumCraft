package com.jmkopecky.aeternumcraft.entity;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellBurstProjectile;
import com.jmkopecky.aeternumcraft.abilities.castTypes.SpellProjectile;
import com.jmkopecky.aeternumcraft.particle.ModParticles;
import com.jmkopecky.aeternumcraft.util.Logger;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SpellBurstProjectileRenderer extends ArrowRenderer<SpellBurstProjectile> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AeternumCraft.MODID, "textures/entity/spell_projectile.png");


    public SpellBurstProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        RenderSystem.setShaderColor(0, 0.5F, 1, 1);
    }

    public ResourceLocation getTextureLocation(SpellBurstProjectile spell) {
        return TEXTURE;
    }

    @Override
    public void render(SpellBurstProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        RenderSystem.setShaderColor(1, 0.64F, 0, 1);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        if (pEntity.getLevel().isClientSide) {
            pEntity.getLevel().addParticle(ModParticles.SPELL_BURST_TRAIL_PARTICLE.get(), pEntity.getX(), pEntity.getY(), pEntity.getZ(), 0, 0, 0);
            Random random = new Random();
            Vec3 entityVector = pEntity.getDeltaMovement();
            for (int i = 0; i < 10; i++) {
                double xDir = random.nextDouble(-1, 1)*10;
                double yDir = random.nextDouble(-1, 1)*10;
                double zDir = random.nextDouble(-1, 1)*10;
                pEntity.getLevel().addParticle(ModParticles.SPELL_BURST_PROJECTILE_PARTICLE.get(), pEntity.getX(), pEntity.getY(), pEntity.getZ(), xDir+entityVector.x, yDir+entityVector.y, zDir+entityVector.z);
            }
        } else {
            Logger.log("pEntity is not clientSide", Logger.WARNING);
        }
    }
}
