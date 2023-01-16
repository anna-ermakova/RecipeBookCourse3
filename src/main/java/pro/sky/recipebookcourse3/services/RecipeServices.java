package pro.sky.recipebookcourse3.services;

import pro.sky.recipebookcourse3.model.Recipes;

import java.util.List;

public interface RecipeServices {


    void addRecipe(String recipeName, int cookingTimeMin, List<Long> ingrIds, List<String> steps);


    Recipes getRecipeById(Long idRecipe);

    Recipes deleteRecipe(Long idRecipe);

    Recipes updateRecipe(Long idRecipe, Recipes recipe);
}
