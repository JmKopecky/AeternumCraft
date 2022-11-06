package com.jmkopecky.aeternumcraft.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class DefaultButton extends Button {
    public DefaultButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pMessage, pOnPress);
    }
}
