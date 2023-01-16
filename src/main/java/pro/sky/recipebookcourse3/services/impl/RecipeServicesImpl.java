package pro.sky.recipebookcourse3.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.IngredientService;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServicesImpl implements RecipeServices {
    private Long idRecipe = 0l;
    private Map<Long, Recipes> recipes = new HashMap<>();

    private IngredientService ingredientService;

    public RecipeServicesImpl(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public void addRecipe(String recipeName, int cookingTimeMin, List<Long> ingrIds, List<String> steps) {
        Map<Long, Ingredients> ingredients = new HashMap<>();
        for (Long ingrId : ingrIds) {
            ingredients.put(ingrId, ingredientService.getIngrById(ingrId));
        }
        Recipes recipe = new Recipes(recipeName, cookingTimeMin, ingredients, steps);
        recipes.put(idRecipe, recipe);
        idRecipe++;
    }

    @Override
    public Recipes getRecipeById(Long idRecipe) {
        return recipes.get(idRecipe);
    }

    @Override
    public Recipes deleteRecipe(Long idRecipe) {
        return recipes.remove(idRecipe);
    }

    @Override
    public Recipes updateRecipe(Long idRecipe, Recipes recipe) {
        recipes.put(idRecipe, recipe);
        return recipe;

    }
}
