package dev.dtrix.rpproject.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiModButton extends GuiButton {

    public GuiModButton(int buttonId, int x, int y) {
        super(buttonId, x, y, 50, 50, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        super.drawButton(mc, mouseX, mouseY, partialTicks);
    }
}
