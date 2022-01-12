package Eksamen;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DietManagerTest{
    @Test
    /*
     * TODO: 2.a.i: If their favorite food is non-vegan, they cannot follow a VeganDiet.
     */
    public void veganDietShouldNotBeCompatibleWithThePersonWhoseFavouriteFoodIsNonVegan() {
        // test for areCompatible method
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Spinat", 150, true, Food.FoodType.PROTEIN));
        Diet diet = new VeganDiet(30, "Get fit", allowedFood, 50);

        Food favFood = new Food("Kjøtt", 100, false, Food.FoodType.PROTEIN);
        Person person = new Person(50, favFood, new ArrayList<>());

        Assert.assertFalse(diet.isCompatible(person));
    }

    @Test
    /*
     * TODO: 2.a.ii: They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
     */
    public void dietShouldNotBeCompatibleWithThePersonWhoIsAllergicToAtLeastHalfOfTheFoodsAllowedByTheDiet() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Spinat", 150, true, Food.FoodType.PROTEIN));
        allowedFood.add(new Food("Tunfisk", 150, true, Food.FoodType.PROTEIN));
        allowedFood.add(new Food("Spagetti", 150, true, Food.FoodType.PROTEIN));
        allowedFood.add(new Food("Pasta", 150, true, Food.FoodType.CARB));

        Diet diet = new VeganDiet(30, "Get fit", allowedFood, 50);

        Food favFood = new Food("Kjøtt", 100, false, Food.FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(new Food("Spagetti", 150, true, Food.FoodType.PROTEIN));
        allergies.add(new Food("Pasta", 150, true, Food.FoodType.CARB));
        Person person = new Person(50, favFood, allergies);

        Assert.assertFalse(diet.isCompatible(person));
    }

    @Test
    /*
     * TODO: 2.a.iii: If they weigh less than the limit set by the VeganDiet or the LowCarbDiet, they cannot be following these diets (for health reasons).
     */
    public void veganDietShouldNotBeCompatibleWithThePersonWhoWeighsLessThanTheMinimumWeightSetByVeganDiet() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Spinat", 150, true, Food.FoodType.PROTEIN));
        Diet diet = new VeganDiet(30, "Get fit", allowedFood, 50);

        Food favFood = new Food("Vegansk Kjøtt", 100, true, Food.FoodType.PROTEIN);
        Person person = new Person(45, favFood, new ArrayList<>());

        Assert.assertFalse(diet.isCompatible(person));
    }

    @Test
    /*
     * TODO: 2.a.iii: If they weigh less than the limit set by the VeganDiet or the LowCarbDiet, they cannot be following these diets (for health reasons).
     */
    public void lowCarbDietShouldNotBeCompatibleWithThePersonWhoWeighsLessThanTheMinimumWeightSetByLowCarbDiet() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Spinat", 150, true, Food.FoodType.PROTEIN));
        LowCarbDiet diet = new LowCarbDiet(30, 40, "Get fit", allowedFood);

        Food favFood = new Food("Vegansk Kjøtt", 100, false, Food.FoodType.PROTEIN);
        Person person = new Person(15, favFood, new ArrayList<>());

        Assert.assertFalse(diet.isCompatible(person));
    }

    @Test
    /*
     * TODO: 2.a.iv: If they weigh more than the limit set by the HyperCaloricDiet, they cannot be following this diet (for health reasons).
     */
    public void hyperCaloricDietShouldNotBeCompatibleWithThePersonWhoWeighsMoreThanTheMaximumWeightSetByHyperCaloricDiet() {
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("Spinat", 150, true, Food.FoodType.PROTEIN));
        Diet diet = new HyperCaloricDiet(10, "idk", allowedFood, 80,120);

        Food favFood = new Food("Vegansk Kjøtt", 100, false, Food.FoodType.PROTEIN);
        Person person = new Person(100, favFood, new ArrayList<>());

        Assert.assertFalse(diet.isCompatible(person));
    }

    @Test
    /*
     * TODO: 2.i: daysDuration: random number between 1 and 100.
     */
    public void daysDurationForTheRandomDietShouldBeBetween1and100() {
        DietManager dm = new DietManager();
        for (int i = 0; i < 1000; i++) {
            int num = dm.getRandomNumber(1,100);
            if(num>100 || num <1 ) Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test
    /*
     * TODO: 2.ii: purpose: “Random diet”.
     */
    public void purposeTextForTheRandomDietShouldBeRandomDiet() {
        DietManager dm = new DietManager();
        Food food = new Food("Steak", 100, false, Food.FoodType.PROTEIN);
        ArrayList<Food> allergies = new ArrayList(Arrays.asList(food));
        Person p = new Person(80, food, allergies);
        Food[] foods = new Food[]{food};
        HyperCaloricDiet hd = dm.randomDiet(p, foods);
        Assert.assertEquals("Random Diet", hd.purpose);
    }

    @Test
    /*
     * TODO: 2.iii: allowedFood: all the Food from the list that the person is not allergic to.
     */
    public void allowedFoodsForTheRandomDietShouldNotContainFoodsThatThePersonIsNotAllergicTo() {
        // test for randomDiet method
        DietManager dm = new DietManager();
        Food strawberry = new Food("Strawberry", 100, true, Food.FoodType.PROTEIN);
        Food blueberry = new Food("Blueberry", 100, true, Food.FoodType.PROTEIN);
        Food raspberry = new Food("Raspberry", 100, true, Food.FoodType.PROTEIN);
        Food orange = new Food("Orange", 100, true, Food.FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList(Arrays.asList(raspberry, orange));
        Food[] foods = new Food[] {strawberry, blueberry, raspberry, orange};

        Food fav = new Food("Steak", 100, false, Food.FoodType.PROTEIN);
        Person p = new Person(80, fav, allergies);

        HyperCaloricDiet hd = dm.randomDiet(p, foods);
        ArrayList<Food> allowedFoods = hd.allowedFood;
        Assert.assertTrue(allowedFoods.contains(blueberry));
        Assert.assertTrue(allowedFoods.contains(strawberry));
        Assert.assertTrue(allowedFoods.size() == 2);
    }

    @Test
    /*
     * TODO: .if there is some non-vegan Food, true otherwise.
     */
    public void theRandomDietShouldShouldBeVeganIfThereIsNotAnyNonVeganFoodInTheGivenFoodList() {
        // test for randomDiet method
        DietManager dm = new DietManager();
        Food strawberry = new Food("Strawberry", 100, true, Food.FoodType.PROTEIN);
        Food blueberry = new Food("Blueberry", 100, true, Food.FoodType.PROTEIN);
        Food raspberry = new Food("Raspberry", 100, true, Food.FoodType.PROTEIN);
        Food orange = new Food("Orange", 100, true, Food.FoodType.PROTEIN);
        Food nonVegan = new Food("Orange", 100, false, Food.FoodType.PROTEIN);

        ArrayList<Food> allergies = new ArrayList(Arrays.asList(raspberry, orange));
        Food[] foodsVegan = new Food[] {strawberry, blueberry, raspberry, orange};
        Food[] foodsNonVegan = new Food[] {strawberry, blueberry, raspberry, orange, nonVegan};

        Food fav = new Food("Peanut", 100, true, Food.FoodType.PROTEIN);
        Person p = new Person(80, fav, allergies);

        HyperCaloricDiet hdVegan = dm.randomDiet(p, foodsVegan);
        HyperCaloricDiet hdNonVegan = dm.randomDiet(p, foodsNonVegan);

        Assert.assertTrue(hdVegan.isVegan);
        Assert.assertFalse(hdNonVegan.isVegan);
    }

    @Test
    /*
     * TODO: 2.v: maxWeightKg: random number between Person.weight and Person.weight + 20
     */
    public void maxWeightKgForTheRandomDietShouldShouldBeBetweenWeightOfThePersonAndWeightOfThePersonPlus20() {
        // test for randomDiet method

        Food fav = new Food("Steak", 100, false, Food.FoodType.PROTEIN);
        ArrayList<Food> allergies = new ArrayList(Arrays.asList(fav));
        Person p = new Person(80, fav, allergies);
        DietManager dm = new DietManager();
        for (int i = 0; i < 1000; i++) {
            int num = dm.getRandomNumber(p.getWeight(), p.getWeight() + 20);
            if(num>100 || num <1 ) Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test
    /*
     * TODO: 2.vi: minCaloriesPerDay: random number between 2000 and 4000.
     */
    public void minCaloriesPerDayForTheRandomDietShouldShouldBeBetween2000And4000() {
        // test for randomDiet method
        DietManager dm = new DietManager();

        Food food = new Food("Steak", 100, false, Food.FoodType.PROTEIN);
        ArrayList<Food> allergies = new ArrayList(Arrays.asList(food));
        Person p = new Person(80, food, allergies);
        Food[] foods = new Food[]{food};
        HyperCaloricDiet hd = dm.randomDiet(p, foods);
        float minCalories = hd.getMinCaloriesPerDay();
        Assert.assertTrue(minCalories <= 4000 && minCalories >= 2000);

    }

}
