package dev.dtrix.rpproject.client.event;

import dev.dtrix.rpproject.RPProject;
import dev.dtrix.rpproject.client.gui.GuiSkillTree;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@Mod.EventBusSubscriber(modid = RPProject.MODID, value = {Side.CLIENT})
public class BarOverlayEvent {

    public static final ResourceLocation BARS = new ResourceLocation("textures/gui/bars.png");
    public static final int BAR_WIDTH = 182;
    public static final int BAR_HEIGHT = 5;
    public static int experience = 0;
    public static int maxExperience = 100;
    public static int level = 0;
    public static int timer = 0;
    public static int maxTimer = 300;

    @SubscribeEvent
    public static void renderGameOverlayPost(RenderGameOverlayEvent.Post event) {

        if (event.getType().equals(RenderGameOverlayEvent.ElementType.ALL)) {
            if (timer > 0 || Minecraft.getMinecraft().currentScreen instanceof GuiSkillTree) {

                GL11.glColor4f(1, 1, 1, 1);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(770, 771);

                final int width = event.getResolution().getScaledWidth();
                final int xPos = width / 2 - BAR_WIDTH / 2;
                final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

                Minecraft.getMinecraft().getTextureManager().bindTexture(BARS);
                Gui.drawModalRectWithCustomSizedTexture(xPos, 5, 0, 50, BAR_WIDTH, BAR_HEIGHT, 256, 256);

                int progress = experience * BAR_WIDTH / maxExperience;
                Gui.drawModalRectWithCustomSizedTexture(xPos, 5, 0, 55, progress, BAR_HEIGHT, 256, 256);

                String s = "Level: " + level;
                fontRenderer.drawString(s, width / 2 - BAR_WIDTH / 2 + 2, 13, Color.WHITE.getRGB());

                String p = experience + "/" + maxExperience + " (" + experience * 100 / maxExperience + "%)";
                fontRenderer.drawString(p, xPos + BAR_WIDTH - fontRenderer.getStringWidth(p), 13, Color.WHITE.getRGB());

                timer--;

            }
        }
    }

    public static void renderBar(int xp, int lvl, int maxXP) {
        experience = xp;
        maxExperience = maxXP;
        level = lvl;
        timer = maxTimer;
    }

}
