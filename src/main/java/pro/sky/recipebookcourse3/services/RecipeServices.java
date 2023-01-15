package pro.sky.recipebookcourse3.services;

import pro.sky.recipebookcourse3.model.Recipes;

public interface RecipeServices {


    void addRecipe(Recipes recipe, int lastId);

    int getRecipe(int lastId);
}
