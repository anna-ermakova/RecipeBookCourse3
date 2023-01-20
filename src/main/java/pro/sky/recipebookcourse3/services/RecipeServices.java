package pro.sky.recipebookcourse3.services;

import pro.sky.recipebookcourse3.model.RecipeCreateDTO;
import pro.sky.recipebookcourse3.model.Recipes;

import java.util.Map;

public interface RecipeServices {


    Recipes editRecipe(Long idRecipe, RecipeCreateDTO recipeDTO);

    Recipes getRecipeById(Long idRecipe);

    Long addRecipe(RecipeCreateDTO recipeDTO);

    boolean existById(long idRecipe);

    boolean deleteRecipe(long idRecipe);

    Map<Long, Recipes> getAllRecipes();
}
