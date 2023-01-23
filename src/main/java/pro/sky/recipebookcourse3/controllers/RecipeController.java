package pro.sky.recipebookcourse3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.internal.metadata.aggregated.rule.OverridingMethodMustNotAlterParameterConstraints;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.model.RecipeCreateDTO;
import pro.sky.recipebookcourse3.model.Recipes;
import pro.sky.recipebookcourse3.services.RecipeServices;

import java.util.Map;


@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты.", description = "CRUD-операции и другие эндпоинты для работы с рецептами.")
public class RecipeController {
    private RecipeServices recipeServices;


    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }

    @GetMapping("/{idRecipe}")
    @Operation(summary = "Получение рецепта по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт получен.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipes.class)
                            )
                    }
            )
    })
    @Parameters(value = {@Parameter(name = "idIngr", example = "1")})
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
    @Operation(summary = "Изменение рецепта по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт изменен.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipes.class)
                            )
                    }
            )
    })
    @Parameters(value = {@Parameter(name = "idRecipe", example = "1")})
    public ResponseEntity<Recipes> editRecipe(@RequestBody RecipeCreateDTO recipesDTO, @PathVariable long idRecipe) {
        if (!recipeServices.existById(idRecipe)) {
            return ResponseEntity.notFound().build();
        }
        Recipes recipe = recipeServices.editRecipe(idRecipe, recipesDTO);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{idRecipe}")
    @Operation(summary = "Удаление рецепта по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт удален."
            )
    })
    @Parameters(value = {@Parameter(name = "idRecipe", example = "1")})
    public ResponseEntity<Void> deleteRecipe(@PathVariable long idRecipe) {
        if (recipeServices.deleteRecipe(idRecipe)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов.", description = "Поиск производится без параметров.")
    @ApiResponses(value={@ApiResponse(responseCode = "200", description = "Все рецепты получены.")})
    public ResponseEntity<Map<Long, Recipes>> getAllRecipes() {
        return ResponseEntity.ok(recipeServices.getAllRecipes());
    }
}