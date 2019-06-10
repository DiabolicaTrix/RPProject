package dev.dtrix.rpproject.client.event;

import dev.dtrix.rpproject.client.gui.GuiSkillTree;
import dev.dtrix.rpproject.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class IOEventHandler {

    @SubscribeEvent
    public void keyInputEvent(InputEvent.KeyInputEvent event) {
        KeyBinding keybinding = ClientProxy.keyBinding;
        if (keybinding.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiSkillTree());
        }
    }

}
