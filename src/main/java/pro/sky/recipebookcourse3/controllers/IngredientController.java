package pro.sky.recipebookcourse3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.services.IngredientService;

@RestController
@RequestMapping("/ingr")
public class IngredientController {
    private IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/getIngr")
    public Ingredients getIngrById(@RequestParam Long idIngr) {
        return ingredientService.getIngrById(idIngr);
    }

    @GetMapping("/addRecipe")
    public void addIngredient(@RequestParam String ingredientName, @RequestParam int volume, @RequestParam String unitOfMeasure) {
        ingredientService.addIngredient(ingredientName, volume, unitOfMeasure);
    }
}
