package dev.dtrix.rpproject.compat;

import dev.dtrix.rpproject.capability.SkillStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;

public class RecipeSkill implements IRecipe {

    private IRecipe recipe;

    public RecipeSkill(IRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        Container eventHandler = ObfuscationReflectionHelper.getPrivateValue(InventoryCrafting.class, inv, "eventHandler");
        EntityPlayer player = null;
        if (eventHandler instanceof ContainerWorkbench) {
            SlotCrafting slot = (SlotCrafting) ((ContainerWorkbench) eventHandler).getSlot(0);
            player = ObfuscationReflectionHelper.getPrivateValue(SlotCrafting.class, slot, "player");
        }

        if (this.recipe.matches(inv, worldIn)) {
            String skill = this.getRecipeOutput().getItem().getRegistryName().getResourceDomain();
            return skill == "minecraft" ? true : player.getCapability(SkillStorage.SKILL_CAPABILITY, null).hasSkill(skill);
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return this.recipe.getCraftingResult(inv);
    }

    @Override
    public boolean canFit(int width, int height) {
        return this.recipe.canFit(width, height);
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipe.getRecipeOutput();
    }

    @Override
    public IRecipe setRegistryName(ResourceLocation name) {
        return this.recipe.setRegistryName(name);
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return this.recipe.getRegistryName();
    }

    @Override
    public Class<IRecipe> getRegistryType() {
        return this.recipe.getRegistryType();
    }


}
