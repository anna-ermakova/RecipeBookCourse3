package pro.sky.recipebookcourse3.services.impl;

import pro.sky.recipebookcourse3.model.Ingredients;

public interface IngredientService {
    void addIngredient(Ingredients ingredient);

    abstract void getIngredient(Integer id);
}
