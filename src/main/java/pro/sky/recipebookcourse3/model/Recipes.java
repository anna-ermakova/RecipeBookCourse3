package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipes {
    private String recipeName;
    private int cookingTimeMin;
    private Map<Long, Ingredients> ingredients;
    private List<String> cookingSteps;


}
