package com.jmkopecky.aeternumcraft.gui.buttons;

import com.jmkopecky.aeternumcraft.playerstats.PlayerAbilityProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SpellUnlockButton extends DefaultButton {

    public String attachedSpellName;
    public int costPoints;
    public int requiredLevel;
    public ArrayList<String> requiredSpell;
    public boolean playerHasUnlocked;


    public SpellUnlockButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pMessage, pOnPress);
    }
    public SpellUnlockButton(int px, int py, int pWidth, int pHeight, String spellName, int cost, int requiredLevel, ArrayList<String> requiredSpells, boolean doesPlayerHave, OnPress pOnPress) {
        this(px, py, pWidth, pHeight, new TextComponent(""), pOnPress);
        this.attachedSpellName = spellName;
        this.costPoints = cost;
        this.requiredLevel = requiredLevel;
        this.requiredSpell = requiredSpells;
        this.playerHasUnlocked = doesPlayerHave;
    }

    public void setUnlocked(Player player, boolean isUnlocked) {
        player.getCapability(PlayerAbilityProvider.PLAYER_ABILITIES).ifPresent(abilities -> {
            abilities.unlockSpell(attachedSpellName, isUnlocked);
            this.playerHasUnlocked = isUnlocked;
        });
    }

    public String getAttachedSpellName() {
        return this.attachedSpellName;
    }
}
