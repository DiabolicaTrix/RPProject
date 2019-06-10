package dev.dtrix.rpproject.compat;

import dev.dtrix.rpproject.event.RPEventHandler;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        registry.handleRecipes(RecipeSkill.class, RecipeWrapper::new, VanillaRecipeCategoryUid.CRAFTING);

        registry.addRecipes(RPEventHandler.REPLACED_RECIPES, VanillaRecipeCategoryUid.CRAFTING);
    }
}
