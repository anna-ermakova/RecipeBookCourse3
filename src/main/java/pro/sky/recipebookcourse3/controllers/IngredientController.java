package pro.sky.recipebookcourse3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipebookcourse3.model.Ingredients;
import pro.sky.recipebookcourse3.services.IngredientService;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты.", description = "CRUD-операции и другие эндпоинты для работы с ингредиентами.")

public class IngredientController {
    private IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{idIngr}")
    @Operation(summary = "Получение ингредиента по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Игредиент получен.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredients.class)
                            )
                    }
            )
    })
    @Parameters(value = {@Parameter(name = "idIngr", example = "1")})
    public ResponseEntity<Ingredients> getIngrById(@PathVariable long idIngr) {
        Ingredients newIngredient = ingredientService.getIngrById(idIngr);
        if (newIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newIngredient);
    }

    @PostMapping
    @Operation(summary = "Добавление ингредиента в список ингредиентов.")
    public Long addIngredient(@Valid @RequestBody Ingredients ingredient) {
        if (StringUtils.isNotBlank(ingredient.getIngredientName())) {
            return ingredientService.addIngredient(ingredient);
        }
        return 0l;

    }

    @PutMapping("/{idIngr}")
    @Operation(summary = "Изменение ингредиента по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Игредиент изменен.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredients.class)
                            )
                    }
            )
    })
    @Parameters(value = {@Parameter(name = "idIngr", example = "1")})
    public ResponseEntity<Ingredients> editIngredient(@Valid @RequestBody Ingredients ingredients, @PathVariable long idIngr) {
        if (!ingredientService.existById(idIngr)) {
            return ResponseEntity.notFound().build();
        }
        ingredientService.editIngredient(idIngr, ingredients);
        return ResponseEntity.ok(ingredients);
    }

    @DeleteMapping("/{idIngr}")
    @Operation(summary = "Удаление ингредиента по id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент удален."
            )})
    @Parameters(value = {@Parameter(name = "idIngr", example = "1")})
    public ResponseEntity<Void> deleteIngredient(@PathVariable long idIngr) {
        if (ingredientService.deleteIngredient(idIngr)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получение всех ингредиентов.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Все ингредиенты получены.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Ingredients.class)
                            )
                    }
            )
    })
    public ResponseEntity<Map<Long, Ingredients>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}