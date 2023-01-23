package pro.sky.recipebookcourse3.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Recipes {
    @NotBlank(message = "Обязательно для заполнения!")
    private String recipeName;
    @Positive
    private int cookingTimeMin;
    @NotEmpty
    private Map<Long, Ingredients> ingredients;
    @NotEmpty
    private List<String> cookingSteps;

    public Recipes(String recipeName, int cookingTimeMin, List<String> cookingSteps) {

    }
}
