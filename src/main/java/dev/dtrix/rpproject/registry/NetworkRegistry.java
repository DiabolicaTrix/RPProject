package dev.dtrix.rpproject.registry;

import dev.dtrix.rpproject.RPProject;
import dev.dtrix.rpproject.packet.PacketSyncSkill;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkRegistry {
    public static final SimpleNetworkWrapper INSTANCE = net.minecraftforge.fml.common.network.NetworkRegistry.INSTANCE.newSimpleChannel(RPProject.MODID);
    private static int ID = 0;

    public static void registerMessages() {
        INSTANCE.registerMessage(PacketSyncSkill.ClientHandler.class, PacketSyncSkill.class, ID++, Side.CLIENT);
    }
}
