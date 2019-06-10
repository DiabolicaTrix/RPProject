package dev.dtrix.rpproject.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SkillProvider implements ICapabilitySerializable<NBTBase> {

    private ISkill skill;

    public SkillProvider() {
        this.skill = new DefaultSkill();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == SkillStorage.SKILL_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return this.hasCapability(capability, facing) ? SkillStorage.SKILL_CAPABILITY.cast(this.skill) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return SkillStorage.SKILL_CAPABILITY.writeNBT(this.skill, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SkillStorage.SKILL_CAPABILITY.readNBT(this.skill, null, nbt);
    }

}
