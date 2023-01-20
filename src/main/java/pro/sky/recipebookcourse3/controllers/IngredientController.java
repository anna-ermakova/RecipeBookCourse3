package pro.sky.recipebookcourse3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.services.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{idIngr}")
    public ResponseEntity<Ingredients> getIngrById(@PathVariable long idIngr) {
        Ingredients newIngredient = ingredientService.getIngrById(idIngr);
        if (newIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newIngredient);
    }

    @PostMapping
    public Long addIngredient(@RequestBody Ingredients ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/{idIngr}")
    public ResponseEntity<Ingredients> egitIngredient(@RequestBody Ingredients ingredients, @PathVariable long idIngr) {
        if (!ingredientService.existById(idIngr)) {
            return ResponseEntity.notFound().build();
        }
        ingredientService.editIngredient(idIngr, ingredients);
        return ResponseEntity.ok(ingredients);
    }

    @DeleteMapping("/{idIngr}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long idIngr) {
        if (ingredientService.deleteIngredient(idIngr)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Map<Long, Ingredients>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }
}