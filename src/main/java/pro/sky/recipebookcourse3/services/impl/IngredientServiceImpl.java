package pro.sky.recipebookcourse3.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebookcourse3.model.Ingredients;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static Integer id = 0;
    private static Map<Integer, Ingredients> ingredients = new LinkedHashMap<>();

    @Override
    public void addIngredient(Ingredients ingredient) {
        ingredients.put(id++, ingredient);
    }

    @Override
    public void getIngredient(Integer id) {
        ingredients.get(id);
    }
}
