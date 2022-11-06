package com.jmkopecky.aeternumcraft.gui.screens;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class DefaultScreen extends Screen {
    protected DefaultScreen(Component pTitle) {
        super(pTitle);
    }

    Minecraft minecraft = Minecraft.getInstance();
    Window window = minecraft.getWindow();

    protected int boxWidth = 256;
    protected int boxHeight = 256;

}
