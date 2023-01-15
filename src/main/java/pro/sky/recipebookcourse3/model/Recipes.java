package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipes {
    private String RECIPE_NAME;
    private int COOKING_TIME_MIN;
    private Map<Integer, Ingredients> ingredients;
    ArrayList<String> cookingSteps;


}
