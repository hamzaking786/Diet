package Eksamen;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class VeganDietTest {
    //TODO Req 1C
    //A: a vegan diet with only vegan food
    //B: a vegan diet with non vegan food = exception
    //C: a vegan diet with vegan and non vegan food = exception
    @Test
    public void veganDietWithOnlyVeganFood() {
        ArrayList<Food> allowedFood = new ArrayList<>();

        allowedFood.add(new Food("Salad 1", 50, true, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Salad 2", 50, true, Food.FoodType.RECIPE));

        VeganDiet VD = new VeganDiet(30, "Eat healthy", allowedFood, 50);

        Assert.assertEquals("The following food is allowed in this diet: Salad 1, Salad 2", VD.writeAllowedFood());
    }

    @Test
    public void veganDietWithWithNonVeganFood(){
        ArrayList<Food> allowedFood = new ArrayList<>();

        allowedFood.add(new Food("Salad 1 ", 50, false, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Salad 2", 50, false, Food.FoodType.RECIPE));

        VeganDiet VD = new VeganDiet(30, "Eat healthy", allowedFood, 50);

        Assert.assertEquals("The following food is allowed in this diet", VD.writeAllowedFood());
    }

    @Test
    public void veganDietWithVeganAndNonVeganFood() throws Exception {
        ArrayList<Food> allowedFood = new ArrayList<>();

        allowedFood.add(new Food("Salad 1", 50, true, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Salad 2", 50, false, Food.FoodType.RECIPE));

        VeganDiet VD = new VeganDiet(30, "Eat healthy", allowedFood, 50);

        Assert.assertEquals("The following food is allowed in this diet: Salad 1", VD.writeAllowedFood());
    }
}
