package dev.dtrix.rpproject.client.gui;

import dev.dtrix.rpproject.RPProject;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiSkillTree extends GuiScreen {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RPProject.MODID, "textures/gui/book.png");
    public static final int WIDTH = 254;
    public static final int HEIGHT = 190;

    public GuiSkillTree() {
        //ISkill cap = player.getCapability(SkillStorage.SKILL_CAPABILITY, null);
        //BarOverlayEvent.renderBar(cap.getExperience(), cap.get);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        final GuiModButton ic2Button = new GuiModButton(0, 0, 0);
        this.addButton(ic2Button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        this.mc.getTextureManager().bindTexture(TEXTURE);

        int xPos = this.width / 2 - (254 / 2);
        int yPos = this.height / 2 - (180 / 2);
        this.drawTexturedModalRect(xPos, yPos, 0, 0, 254, 180);

    }
}
