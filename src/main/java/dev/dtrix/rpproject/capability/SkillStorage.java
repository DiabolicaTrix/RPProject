package dev.dtrix.rpproject.capability;

import dev.dtrix.rpproject.RPProject;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

import javax.annotation.Nullable;

public class SkillStorage implements Capability.IStorage<ISkill> {

    @CapabilityInject(ISkill.class)
    public static final Capability<ISkill> SKILL_CAPABILITY = null;

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ISkill> capability, ISkill instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger(RPProject.MODID + ":experience", instance.getExperience());
        nbt.setInteger(RPProject.MODID + ":level", instance.getLevel());
        nbt.setInteger(RPProject.MODID + ":maxexperience", instance.getMaxExperience());
        return nbt;
    }

    @Override
    public void readNBT(Capability<ISkill> capability, ISkill instance, EnumFacing side, NBTBase base) {
        if (base instanceof NBTTagCompound) {
            NBTTagCompound nbt = (NBTTagCompound) base;
            instance.setExperience(nbt.getInteger(RPProject.MODID + ":experience"));
            instance.setLevel(nbt.getInteger(RPProject.MODID + ":level"));
            instance.setMaxExperience(nbt.getInteger(RPProject.MODID + ":maxexperience"));
        }
    }

}
