package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class RecipeCreateDTO {
    private String recipeName;
    private int cookingTimeMin;
    private List<Long> ingredientsIds;
    private List<String> cookingSteps;

}
