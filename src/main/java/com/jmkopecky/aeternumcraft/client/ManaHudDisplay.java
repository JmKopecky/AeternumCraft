package com.jmkopecky.aeternumcraft.client;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class ManaHudDisplay extends GuiComponent {

    private static final ResourceLocation MANA_FULL = new ResourceLocation(AeternumCraft.MODID, "textures/mana/mana_full.png");
    private static final ResourceLocation MANA_EMPTY = new ResourceLocation(AeternumCraft.MODID, "textures/mana/mana_empty.png");

    public static void renderBar() {
        PoseStack poseStack = new PoseStack();
        Minecraft minecraft = Minecraft.getInstance();
        Window window = minecraft.getWindow();

        if (minecraft.level == null || minecraft.player == null) {
            return;
        }
        if (minecraft.player.isSpectator()) {
            return;
        }
        if (minecraft.screen != null) {
            if (minecraft.screen.isPauseScreen()) {
                return;
            }
        }
        if (minecraft.getOverlay() != null || minecraft.options.hideGui) {
            return;
        }
        if (!(minecraft.getCameraEntity() instanceof Player)) {
            return;
        }
        if (minecraft.gameMode != null) {
            if (!(minecraft.gameMode.canHurtPlayer())) {
                return;
            }
        }


        int screenWidth = window.getGuiScaledWidth();
        int screenHeight = window.getGuiScaledHeight();
        double guiScale = window.getGuiScale();

        System.out.println("Screen Width: " + screenWidth + " Screen Height: " + screenHeight + " Gui Scale: " + guiScale);

        int x = 10;
        int y = screenHeight - 25;



        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, MANA_EMPTY);

        int distanceBetweenIcons = (int) (19 - guiScale);
        int iconSize = (int) (16 - guiScale);

        for (int i=0;i<10;i++) {
            GuiComponent.blit(poseStack, x+(i*distanceBetweenIcons), y, 0, 0, iconSize, iconSize, iconSize,iconSize);
        }

        RenderSystem.setShaderTexture(0, MANA_FULL);
        for (int i=0;i<10;i++) {
            if (((ClientCurrentManaData.getPlayerMana()/ClientCurrentMaxManaData.getPlayerMaxMana())*10) > i) {
                GuiComponent.blit(poseStack,x+(i*distanceBetweenIcons), y, 0, 0, iconSize, iconSize, iconSize,iconSize);
            } else {
                break;
            }
        }
    }
}
