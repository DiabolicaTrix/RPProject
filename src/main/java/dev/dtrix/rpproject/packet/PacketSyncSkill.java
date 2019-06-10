package dev.dtrix.rpproject.packet;

import dev.dtrix.rpproject.capability.ISkill;
import dev.dtrix.rpproject.capability.SkillStorage;
import dev.dtrix.rpproject.client.event.BarOverlayEvent;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.ArrayList;
import java.util.List;

public class PacketSyncSkill implements IMessage {

    private int experience;
    private int maxExperience;
    private int level;
    private int skillPoints;
    private List<String> skillList;

    public PacketSyncSkill() {
    }

    public PacketSyncSkill(int experience, int level, int maxExperience, List<String> skillList, int skillPoints) {
        this.experience = experience;
        this.level = level;
        this.maxExperience = maxExperience;
        this.skillList = skillList;
        this.skillPoints = skillPoints;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.experience = buf.readInt();
        this.level = buf.readInt();
        this.maxExperience = buf.readInt();
        this.skillPoints = buf.readInt();
        this.skillList = new ArrayList<>();
        int size = buf.readInt();
        for (int i = 0; i < size; i++) {
            this.skillList.add(ByteBufUtils.readUTF8String(buf));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.experience);
        buf.writeInt(this.level);
        buf.writeInt(this.maxExperience);
        buf.writeInt(this.skillPoints);
        buf.writeInt(this.skillList.size());
        this.skillList.forEach(skill -> {
            ByteBufUtils.writeUTF8String(buf, skill);
        });
    }

    public static class ClientHandler implements IMessageHandler<PacketSyncSkill, IMessage> {

        @Override
        public IMessage onMessage(PacketSyncSkill message, MessageContext ctx) {
            EntityPlayer player = Minecraft.getMinecraft().player;

            Minecraft.getMinecraft().addScheduledTask(() -> {
                ISkill cap = player.getCapability(SkillStorage.SKILL_CAPABILITY, null);
                cap.setExperience(message.experience);
                cap.setLevel(message.level);
                cap.setMaxExperience(message.maxExperience);
                cap.setSkillList(message.skillList);
                cap.setSkillPoints(message.skillPoints);
                BarOverlayEvent.renderBar(message.experience, message.level, message.maxExperience);
            });
            return null;
        }

    }
}
