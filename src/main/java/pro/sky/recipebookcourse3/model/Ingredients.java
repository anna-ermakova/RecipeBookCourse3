package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredients {
    private String ingredientName;
    private int volume;
    private String unitOfMeasure;
}

