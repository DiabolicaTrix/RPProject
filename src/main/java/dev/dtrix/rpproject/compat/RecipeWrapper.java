package dev.dtrix.rpproject.compat;

import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.wrapper.ICustomCraftingRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;

public class RecipeWrapper implements ICustomCraftingRecipeWrapper {

    private RecipeSkill recipe;

    public RecipeWrapper(RecipeSkill recipe) {
        this.recipe = recipe;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        Object focus = recipeLayout.getFocus().getValue();

        guiItemStacks.init(0, false, 94, 18);

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 3; ++x) {
                int index = 1 + x + (y * 3);
                guiItemStacks.init(index, true, x * 18, y * 18);
            }
        }

        List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
        List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);

        guiItemStacks.set(ingredients);
    }

    @Override
    public void getIngredients(IIngredients ingredients) {

    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return this.recipe.getRegistryName();
    }
}
