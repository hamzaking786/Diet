package Eksamen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FlexiterianDietTest {

    /*
     * TODO: 1.d. The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein type.
     */
    @Test(expected = IllegalArgumentException.class)
    public void veganFoodShouldNotBeAllowed(){
        new FlexitarianDiet(1, new Food("AnyName", 12, true, Food.FoodType.CARB), 2, "", new ArrayList<>());
    }

    /*
     * TODO: 1.d. The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein type.
     */
    @Test()
    public void onlyTheNonVeganFoodOfProteinTypeShouldBeAllowed(){
        new FlexitarianDiet(1, new Food("AnyName", 12, false, Food.FoodType.PROTEIN), 2, "", new ArrayList<>());
    }

}
