package pro.sky.recipebookcourse3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebookcourse3.model.RecipeCreateDTO;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.Map;


@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeServices recipeServices;


    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }

    @GetMapping("/{idRecipe}")
    public ResponseEntity<Recipes> getRecipeById(@PathVariable long idRecipe) {
        Recipes newRecipe = recipeServices.getRecipeById(idRecipe);
        if (newRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newRecipe);
    }

    @PostMapping
    public Long addRecipe(@RequestBody RecipeCreateDTO recipeDTO) {
        return recipeServices.addRecipe(recipeDTO);
    }

    @PutMapping("/{idRecipe}")
    public ResponseEntity<Recipes> editRecipe(@RequestBody RecipeCreateDTO recipesDTO, @PathVariable long idRecipe) {
        if (!recipeServices.existById(idRecipe)) {
            return ResponseEntity.notFound().build();
        }
        Recipes recipe = recipeServices.editRecipe(idRecipe, recipesDTO);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{idRecipe}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long idRecipe) {
        if (recipeServices.deleteRecipe(idRecipe)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Map<Long, Recipes>> getAllRecipes() {
        return ResponseEntity.ok(recipeServices.getAllRecipes());
    }
}