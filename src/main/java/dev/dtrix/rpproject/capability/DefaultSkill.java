package dev.dtrix.rpproject.capability;

import dev.dtrix.rpproject.packet.PacketSyncSkill;
import dev.dtrix.rpproject.registry.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.List;

public class DefaultSkill implements ISkill {

    protected int experience = 0;
    protected int maxExperience = 200;
    protected int level = 0;
    protected int skillPoints = 0;
    protected List<String> skillList = new ArrayList<>();

    @Override
    public void addExperience(int amount) {
        if (amount + experience >= maxExperience) {
            experience = (amount + experience) - maxExperience;
            this.levelUp();

        } else {
            this.experience += amount;
        }
    }

    public void levelUp() {
        level++;
        maxExperience += 100 * level;
        skillPoints++;
    }

    @Override
    public int getExperience() {
        return this.experience;
    }

    @Override
    public void setExperience(int amount) {
        this.experience = amount;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getMaxExperience() {
        return this.maxExperience;
    }

    @Override
    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    @Override
    public List<String> getSkillList() {
        return this.skillList;
    }

    @Override
    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }

    @Override
    public int getSkillPoints() {
        return this.skillPoints;
    }

    @Override
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    @Override
    public boolean hasSkill(String skill) {
        return this.skillList.contains(skill);
    }

    public void sync(EntityPlayerMP player) {
        NetworkRegistry.INSTANCE.sendTo(new PacketSyncSkill(experience, level, maxExperience, skillList, skillPoints), player);
    }

    public void copyTo(ISkill cap) {
        cap.setExperience(this.getExperience());
        cap.setLevel(this.getLevel());
        cap.setMaxExperience(this.getMaxExperience());
        cap.setSkillList(this.getSkillList());
        cap.setSkillPoints(this.getSkillPoints());
    }

}
