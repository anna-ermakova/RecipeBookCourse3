package pro.sky.recipebookcourse3.services;

import pro.sky.recipebookcourse3.model.Ingredients;

import java.util.Map;

public interface IngredientService {


    Long addIngredient(Ingredients ingredient);

    boolean existById(long idIngr);

    void editIngredient(Long idIngr, Ingredients ingredient);

    Ingredients getIngrById(Long idIngr);

    boolean deleteIngredient(long idIngr);

    Map<Long,Ingredients> getAllIngredients();
}
