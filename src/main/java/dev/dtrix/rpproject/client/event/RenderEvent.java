package dev.dtrix.rpproject.client.event;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class RenderEvent {

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiMainMenu) {
            //event.setGui(new GuiCustomMenu());
        }
    }

}
