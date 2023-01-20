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
    public Long addIngredient(Ingredients ingredient) {
        idIngr++;
        ingredients.put(idIngr, ingredient);
        return idIngr;
    }

    @Override
    public boolean existById(long idIngr) {
        return ingredients.containsKey(idIngr);
    }

    @Override
    public void editIngredient(Long idIngr, Ingredients ingredient) {
        if (ingredients.containsKey(idIngr)) {
            ingredients.put(idIngr, ingredient);
        }
    }

    @Override
    public Ingredients getIngrById(Long idIngr) {
        return ingredients.get(idIngr);
    }

    @Override
    public boolean deleteIngredient(long idIngr) {
        if (ingredients.containsKey(idIngr)) {
            ingredients.remove(idIngr);
            return true;
        }
        return false;
    }

    @Override
    public Map<Long, Ingredients> getAllIngredients() {
        return ingredients;
    }
}
