package pro.sky.recipebookcourse3.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeCreateDTO {
    @NotBlank(message = "Обязательно для заполнения!")
    private String recipeName;
    @Positive
    private int cookingTimeMin;
    @NotEmpty
    private List<Long> ingredientsIds;
    @NotEmpty
    private List<String> cookingSteps;

}
