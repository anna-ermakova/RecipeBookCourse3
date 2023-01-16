package pro.sky.recipebookcourse3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.List;


@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeServices recipeServices;


    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }


    @GetMapping("/getRecipe")
    public Recipes getRecipeById(@RequestParam Long idRecipe) {
        return recipeServices.getRecipeById(idRecipe);
    }

    @GetMapping("/addRecipe")
    public void addRecipe(@RequestParam String recipeName, @RequestParam int cookingTimeMin, @RequestParam List<Long> ingrIds, @RequestParam List<String> steps) {
        recipeServices.addRecipe(recipeName, cookingTimeMin, ingrIds, steps);
    }
}