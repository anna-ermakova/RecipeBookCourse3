package pro.sky.recipebookcourse3.services;

import pro.sky.recipebookcourse3.model.Ingredients;

public interface IngredientService {
    void addIngredient(String ingredientName, int volume, String unitOfMeasure);

    Ingredients getIngrById(Long idIngr);
}
