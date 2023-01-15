package pro.sky.recipebookcourse3.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServicesImpl implements RecipeServices {
    public static Integer lastId = 0;
    private static Map<Integer, Recipes> recipes = new LinkedHashMap<>();

    @Override
    public void addRecipe(Recipes recipe, int lastId) {

        recipes.put(lastId++,recipe);
    }

    @Override
    public int getRecipe(int lastId) {
        recipes.get(lastId);
        return lastId;
    }

}
