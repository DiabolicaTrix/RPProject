package dev.dtrix.rpproject.capability;

import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public interface ISkill {

    void addExperience(int amount);

    int getExperience();

    void setExperience(int amount);

    int getLevel();

    void setLevel(int level);

    int getMaxExperience();

    void setMaxExperience(int maxExperience);

    int getSkillPoints();

    void setSkillPoints(int skillPoints);

    List<String> getSkillList();

    void setSkillList(List<String> skillList);

    boolean hasSkill(String skill);

    void sync(EntityPlayerMP player);

    void copyTo(ISkill cap);
}
