package pro.sky.recipebookcourse3.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Ingredients {
    @NotBlank(message = "Обязательно для заполнения!")
    private String ingredientName;
    @Positive
    private int volume;
    private String unitOfMeasure;
}

