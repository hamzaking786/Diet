package Eksamen;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class LowCarbDietTest {

    @Test
    /*
     * TODO: 1.e The maximum carb-type foods that can be included in a LowCarbDiet is two.
     */
    public void maximumOfTwoCarbTypeFoodsShouldBeAllowed(){
        // isFoodAllowed method.
        ArrayList<Food> food = new ArrayList();
        food.add(new Food("Spagetti",100,false, Food.FoodType.CARB));
        food.add(new Food("Pasta",101,false, Food.FoodType.CARB));
        LowCarbDiet LC1 = new LowCarbDiet (45, 7,"idk", food);
        Food anotherCarb = new Food("Tunfisk", 34,false, Food.FoodType.CARB);
        Assert.assertFalse(LC1.isFoodAllowed(anotherCarb));
    }
}
