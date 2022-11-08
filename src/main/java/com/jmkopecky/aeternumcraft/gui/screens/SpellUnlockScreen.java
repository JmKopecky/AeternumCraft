package com.jmkopecky.aeternumcraft.gui.screens;

import com.jmkopecky.aeternumcraft.AeternumCraft;
import com.jmkopecky.aeternumcraft.abilities.SpellComponentInfo;
import com.jmkopecky.aeternumcraft.gui.buttons.DefaultButton;
import com.jmkopecky.aeternumcraft.gui.buttons.SpellUnlockButton;
import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.ScreenEvent;

import java.util.ArrayList;
import java.util.List;

public class SpellUnlockScreen extends DefaultScreen {

    int x;
    int y;

    int menuWidth;
    int menuHeight;

    ArrayList<SpellUnlockButton> spellUnlockButtons = new ArrayList<>();

    public static final ResourceLocation SCREEN_LOCATION = new ResourceLocation(AeternumCraft.MODID, "textures/gui/screens/spell_unlock_screen_display.png");

    public SpellUnlockScreen(Component pTitle) {
        super(pTitle);
    }

    @Override
    public void init() {

        x = ((window.getGuiScaledWidth() / 2) - (boxWidth / 2));
        y = ((window.getGuiScaledHeight() / 2) - (boxHeight / 2) + 25);
        menuWidth = 256;
        menuHeight = 256;
        Player player = minecraft.player;
        //Create all the buttons for each spell.
        player.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(playerAbilities -> {
            ArrayList<String> emptyArrayList = new ArrayList<>();
            //SpellUnlockButton detonateSmall = new SpellUnlockButton(0, 0, 3, 5, "aeternumcraft.spellunlockbutton.detonatesmall", "detonatesmall", , 0, )
            SpellUnlockButton detonateSmall = new SpellUnlockButton(x, y, 100, 50, "detonatesmall", SpellComponentInfo.DETONATESMALL.getSpellLevelCost(),SpellComponentInfo.DETONATESMALL.getSpellMinLevel(), emptyArrayList, playerAbilities.checkIfSpellUnlocked("detonatesmall"), (button) -> {
                playerAbilities.unlockSpell("detonatesmall", true);
            });
            spellUnlockButtons.add(detonateSmall);


            for (DefaultButton button : spellUnlockButtons) {
                addWidget(button);
            }
        });
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(stack, 1);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, SCREEN_LOCATION);
        this.blit(stack, x, y, 0, 0, menuWidth, menuHeight);
        spellUnlockButtons.get(0).render(stack, mouseX, mouseY, partialTicks);
        //renderTooltip(stack, new TextComponent("test"), mouseX, mouseY);
        for (SpellUnlockButton button:spellUnlockButtons) {
            if (button.isHoveredOrFocused()) {
                renderButtonTooltip(button, stack, mouseX, mouseY);
            }
        }
    }

    public void renderButtonTooltip(SpellUnlockButton button, PoseStack stack, int mouseX, int mouseY) {
        List<Component> list = new ArrayList<>();
        SpellComponentInfo spellComponent = SpellComponentInfo.getEnumValueGivenStringIdentifier(button.attachedSpellName);
        TextComponent titleLine = new TextComponent(spellComponent.getSpellDisplayName() + " | " + spellComponent.getLatinSpellName());
        list.add(titleLine);
        //renderTooltip(stack, titleLine, mouseX, mouseY);
        TextComponent descLine = new TextComponent(spellComponent.getSpellDescription());
        list.add(descLine);
        //renderTooltip(stack, descLine, mouseX, mouseY+15);
        TextComponent levelLine = (TextComponent) new TextComponent("Minimum Level: " + spellComponent.getSpellMinLevel() + " | Unlock Cost: " + spellComponent.getSpellLevelCost()).withStyle(ChatFormatting.AQUA);
        list.add(levelLine);
        //renderTooltip(stack, levelLine, mouseX, mouseY+30);
        if (!button.requiredSpell.isEmpty()) {
            String tempString = "";
            for (String spellName:button.requiredSpell) {
                tempString.concat(" " + SpellComponentInfo.getEnumValueGivenStringIdentifier(spellName).getSpellDisplayName());
            }
            TextComponent requiredSpells = new TextComponent("Prerequisite Spells: " + tempString);
            list.add(requiredSpells);
            //renderTooltip(stack, requiredSpells, mouseX, mouseY+45);
        }
        renderComponentTooltip(stack, list, mouseX, mouseY);
    }

    @Override
    public void renderBackground(PoseStack stack, int p_renderBackground_1_) {
        if (this.minecraft != null) {
            this.fillGradient(stack, 0, 0, this.width+128, this.height, -1072689136, -804253680);
            net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundDrawnEvent(this, stack));
        }
        else
            this.renderBackground(stack, p_renderBackground_1_);
    }

}
