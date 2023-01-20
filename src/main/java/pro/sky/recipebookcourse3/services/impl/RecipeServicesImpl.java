package pro.sky.recipebookcourse3.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebookcourse3.model.RecipeCreateDTO;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.IngredientService;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.HashMap;
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
    public Long addRecipe(RecipeCreateDTO recipeDTO) {
        Recipes recipe = fromDTO(recipeDTO);
        idRecipe++;
        recipes.put(idRecipe, recipe);
        return idRecipe;
    }

    private Recipes fromDTO(RecipeCreateDTO recipeDTO) {
        Recipes recipe = new Recipes(recipeDTO.getRecipeName(), recipeDTO.getCookingTimeMin(), recipeDTO.getCookingSteps());
        for (Long ingrId : recipeDTO.getIngredientsIds()) {
            recipe.getIngredients().put(ingrId, ingredientService.getIngrById(ingrId));
        }
        return recipe;
    }

    @Override
    public Recipes editRecipe(Long idRecipe, RecipeCreateDTO recipeDTO) {

        Recipes recipe = fromDTO(recipeDTO);
        recipes.put(idRecipe, recipe);

        return recipe;
    }

    @Override
    public Recipes getRecipeById(Long idRecipe) {
        return recipes.get(idRecipe);
    }

    @Override
    public boolean existById(long idRecipe) {
        return recipes.containsKey(idRecipe);
    }

    @Override
    public boolean deleteRecipe(long idRecipe) {
        if (recipes.containsKey(idRecipe)) {
            recipes.remove(idRecipe);
            return true;
        }
        return false;
    }

    @Override
    public Map<Long, Recipes> getAllRecipes() {
        return recipes;
    }
}

