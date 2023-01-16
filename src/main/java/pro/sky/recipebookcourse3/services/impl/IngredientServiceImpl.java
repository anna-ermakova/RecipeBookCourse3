package pro.sky.recipebookcourse3.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private Long idIngr = 0l;
    private Map<Long, Ingredients> ingredients = new HashMap<>();

    @Override
    public void addIngredient(String ingredientName, int volume, String unitOfMeasure) {
        Ingredients ingredients1 = new Ingredients(ingredientName, volume, unitOfMeasure);
        ingredients.put(idIngr, ingredients1);
        idIngr++;
    }

    @Override
    public Ingredients getIngrById(Long idIngr) {
        return ingredients.get(idIngr);
    }
}
