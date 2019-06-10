package dev.dtrix.rpproject.proxy;

import dev.dtrix.rpproject.client.event.IOEventHandler;
import dev.dtrix.rpproject.client.event.RenderEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
    public static KeyBinding keyBinding;

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();

        MinecraftForge.EVENT_BUS.register(new IOEventHandler());
        MinecraftForge.EVENT_BUS.register(new RenderEvent());


        keyBinding = new KeyBinding("key.menu.open", Keyboard.KEY_J, "key.rpproject.category");
        ClientRegistry.registerKeyBinding(keyBinding);
    }

    @Override
    public void postInit() {
        super.postInit();
    }
}
