package dev.dtrix.rpproject.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Mouse;

import java.io.IOException;

public class GuiCustomMenu extends GuiScreen {

    private int widthCopyright;
    private int widthCopyrightRest;

    public GuiCustomMenu() {
    }

    public void updateScreen() {
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void initGui() {
        this.widthCopyright = this.fontRenderer.getStringWidth("Copyright Mojang AB. Do not distribute!");
        this.widthCopyrightRest = this.width - this.widthCopyright - 2;

        int i = 24;
        int j = this.height / 4 + 48;

        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options")));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit")));
        this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, j + 72 + 12));
    }

    public void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 6) {
            this.mc.displayGuiScreen(new net.minecraftforge.fml.client.GuiModList(this));
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        String s = "Minecraft 1.12.2" + ("release".equalsIgnoreCase(this.mc.getVersionType()) ? "" : "/" + this.mc.getVersionType());

        /*java.util.List<String> brandings = com.google.common.collect.Lists.reverse(net.minecraftforge.fml.common.FMLCommonHandler.instance().getBrandings(true));
        for (int brdline = 0; brdline < brandings.size(); brdline++)
        {
            String brd = brandings.get(brdline);
            if (!com.google.common.base.Strings.isNullOrEmpty(brd))
            {
                this.drawString(this.fontRenderer, brd, 2, this.height - ( 10 + brdline * (this.fontRenderer.FONT_HEIGHT + 1)), 16777215);
            }
        }*/

        this.drawString(this.fontRenderer, "Copyright Mojang AB. Do not distribute!", this.widthCopyrightRest, this.height - 10, -1);

        if (mouseX > this.widthCopyrightRest && mouseX < this.widthCopyrightRest + this.widthCopyright && mouseY > this.height - 10 && mouseY < this.height && Mouse.isInsideWindow()) {
            drawRect(this.widthCopyrightRest, this.height - 1, this.widthCopyrightRest + this.widthCopyright, this.height, -1);
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void onGuiClosed() {
    }

}
