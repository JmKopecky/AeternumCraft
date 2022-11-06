package com.jmkopecky.aeternumcraft.entity;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.SpellProjectile;
import com.jmkopecky.aeternumcraft.particle.ModParticles;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SpellProjectileRenderer extends ArrowRenderer<SpellProjectile> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(AeternumCraft.MODID, "textures/entity/spell_projectile.png");

    public SpellProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(SpellProjectile spell) {
        return TEXTURE;
    }

    @Override
    public void render(SpellProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        if (pEntity.getLevel().isClientSide) {
            pEntity.getLevel().addParticle(ModParticles.SPELL_TRAIL_PARTICLE.get(), pEntity.getX(), pEntity.getY(), pEntity.getZ(), 0, 0, 0);
            Random random = new Random();
            Vec3 entityVector = pEntity.getDeltaMovement();
            for (int i = 0; i < 10; i++) {
                double xDir = random.nextDouble(-1, 1)*10;
                double yDir = random.nextDouble(-1, 1)*10;
                double zDir = random.nextDouble(-1, 1)*10;
                pEntity.getLevel().addParticle(ModParticles.SPELL_PROJECTILE_PARTICLE.get(), pEntity.getX(), pEntity.getY(), pEntity.getZ(), xDir+entityVector.x, yDir+entityVector.y, zDir+entityVector.z);
            }
        } else {
            AeternumCraft.log("pEntity is not clientSide", "Error");
        }
    }
}
