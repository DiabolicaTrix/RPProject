package dev.dtrix.rpproject.proxy;

import dev.dtrix.rpproject.capability.DefaultSkill;
import dev.dtrix.rpproject.capability.ISkill;
import dev.dtrix.rpproject.capability.SkillStorage;
import dev.dtrix.rpproject.event.CapabilityEvent;
import dev.dtrix.rpproject.registry.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {
    public void preInit() {

    }

    public void init() {
        CapabilityManager.INSTANCE.register(ISkill.class, new SkillStorage(), DefaultSkill::new);
        NetworkRegistry.registerMessages();

        MinecraftForge.EVENT_BUS.register(new CapabilityEvent());
    }

    public void postInit() {

    }
}
