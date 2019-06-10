package dev.dtrix.rpproject.event;

import dev.dtrix.rpproject.RPProject;
import dev.dtrix.rpproject.compat.RecipeSkill;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = RPProject.MODID)
public class RPEventHandler {

    public static final List<IRecipe> REPLACED_RECIPES = new ArrayList<>();

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        final IForgeRegistry<IRecipe> registry = ForgeRegistries.RECIPES;
        final List<IRecipe> toReplace = new ArrayList<>();

        for (IRecipe recipe : registry) {
            toReplace.add(recipe);
            REPLACED_RECIPES.add(recipe);
        }
        toReplace.forEach(recipe -> {
            IRecipe replacement = new RecipeSkill(recipe);
            registry.register(replacement);
        });

    }


}
