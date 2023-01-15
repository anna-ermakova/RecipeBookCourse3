package pro.sky.recipebookcourse3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
public class Ingredients{
    private String INGREDIENT_NAME;
    private int VOLUME;
    private String UNIT_OF_MEASURE;

}
