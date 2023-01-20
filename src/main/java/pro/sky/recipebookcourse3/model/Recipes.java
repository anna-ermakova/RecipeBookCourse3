package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipes {
    private String recipeName;
    private int cookingTimeMin;
    private Map<Long, Ingredients> ingredients;
    private List<String> cookingSteps;

    public Recipes(String recipeName, int cookingTimeMin, List<String> cookingSteps) {
        this.recipeName = recipeName;
        this.cookingTimeMin = cookingTimeMin;
        this.cookingSteps = cookingSteps;
        this.ingredients = new HashMap<>();
    }
}
