package com.kingbacon007.aeternumcraft.client;

import com.kingbacon007.aeternumcraft.AeternumCraft;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {



    private static final ResourceLocation MANA_FULL = new ResourceLocation(AeternumCraft.MODID, "textures/mana/mana_full.png");
    private static final ResourceLocation MANA_EMPTY = new ResourceLocation(AeternumCraft.MODID, "textures/mana/mana_empty.png");

    public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
        int x = width/2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, MANA_EMPTY);

        for (int i=0;i<10;i++) {
            GuiComponent.blit(poseStack, x-300+(i*15), y-25, 0, 0, 14, 14, 14,14);
        }

        RenderSystem.setShaderTexture(0, MANA_FULL);
        for (int i=0;i<10;i++) {
            if (((ClientManaData.getPlayerMana()/100)*10) > i) {
                GuiComponent.blit(poseStack,x-300+(i*15), y-25, 0, 0, 14, 14, 14,14 );
            } else {
                break;
            }
        }
    });

}
