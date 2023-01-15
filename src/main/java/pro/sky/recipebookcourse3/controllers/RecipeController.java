package pro.sky.recipebookcourse3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.RecipeServices;


@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeServices recipeServices;


    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }


    @GetMapping("/getRecipe")
    public int Recipe(@RequestParam int lastId) {

        return recipeServices.getRecipe(lastId);
    }

    @GetMapping("/addRecipe")
    public addRecipe(@RequestParam Recipes recipe ) {
        return recipeServices.addRecipe(Recipes recipe, lastId++);
    }
}