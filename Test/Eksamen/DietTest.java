package Eksamen;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DietTest {
    //TODO REQ 1 A
    //A: Create a diet with non vegan food. result = non vegan
    //B: Create a diet with vegan food = vegan
    //C: Create a diet with vegan and non vegan = non vegan

    @Test
    public void dietIsNotVegan1A_A() {
        //Oppretter arrayList obj som henter fra Food
        ArrayList<Food> allowedFood = new ArrayList<>();

        //Oppretter food obj og liste med inputs
        allowedFood.add(new Food("Meat", 120, false, Food.FoodType.FAT));
        allowedFood.add(new Food("Egg", 75, false, Food.FoodType.PROTEIN));
        allowedFood.add(new Food("Pasta bolognese", 145, false, Food.FoodType.CARB));

        //Lage en diet
        Diet diet = new HyperCaloricDiet(30, "More energy", allowedFood, 100, 5000);

        Assert.assertFalse(diet.calculateIsVegan());       //Må lage isVegan funksjon
        System.out.println("This is not a vegan diet"); //Dette skrives ut hvis hele testen kjøres gjennom
    }

    @Test
    public void dietIsVegan1A_B() {
        //Oppretter arrayList obj som henter fra Food
        ArrayList<Food> allowedFood = new ArrayList<>();

        //Oppretter food obj og liste med inputs
        allowedFood.add(new Food("Salad", 50, true, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Pasta", 105, true, Food.FoodType.CARB));
        allowedFood.add(new Food("Bread", 89, true, Food.FoodType.CARB));

        //Lage en diet
        Diet diet = new HyperCaloricDiet(30, "Eat healthier", allowedFood, 100, 5000);

        Assert.assertTrue(diet.calculateIsVegan());       //Må lage isVegan funksjon
        System.out.println("This is a vegan diet"); //Dette skrives ut hvis hele testen kjøres gjennom
    }

    @Test
    public void dietIsStillNotVegan1A_C() {
        //Oppretter arrayList obj som henter fra Food
        ArrayList<Food> allowedFood = new ArrayList<>();

        //Oppretter food obj og liste med inputs
        allowedFood.add(new Food("Salad", 50, true, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Hamburger", 215, false, Food.FoodType.CARB));
        allowedFood.add(new Food("Bread", 89, true, Food.FoodType.CARB));

        //Lage en diet
        Diet diet = new HyperCaloricDiet(30, "Eat healthier", allowedFood, 100, 5000);

        Assert.assertFalse(diet.calculateIsVegan());       //Må lage isVegan funksjon
        System.out.println("This is not a vegan diet"); //Dette skrives ut hvis hele testen kjøres gjennom
    }

    //TODO REQ 1B
    //A: LowCarbDiet with vegan food = vegan
    //B: LowCarbDiet with non vegan food = non vegan

    @Test
    public void veganLowCarbDiet1B_A() {
        //Oppretter arrayList obj som henter fra Food
        ArrayList<Food> allowedFood = new ArrayList<>();

        //Oppretter food obj og liste med inputs
        allowedFood.add(new Food("Salad", 50, true, Food.FoodType.RECIPE));
        allowedFood.add(new Food("Pasta", 105, true, Food.FoodType.CARB));
        allowedFood.add(new Food("Bread", 89, true, Food.FoodType.CARB));

        //Lage en diet
        Diet diet = new LowCarbDiet(50, 30, "Weight loss", allowedFood);

        Assert.assertTrue(diet.calculateIsVegan());       //Må lage isVegan funksjon
        System.out.println("This is a vegan diet"); //Dette skrives ut hvis hele testen kjøres gjennom
    }

    @Test
    public void nonVeganLowCarbDiet1B_B() {
        //Oppretter arrayList obj som henter fra Food
        ArrayList<Food> allowedFood = new ArrayList<>();

        //Oppretter food obj og liste med inputs
        allowedFood.add(new Food("Meat", 120, false, Food.FoodType.FAT));
        allowedFood.add(new Food("Egg", 75, false, Food.FoodType.PROTEIN));
        allowedFood.add(new Food("Pasta bolognese", 145, false, Food.FoodType.CARB));

        //Lage en diet
        Diet diet = new LowCarbDiet(50, 30, "Weight loss", allowedFood);

        Assert.assertFalse(diet.calculateIsVegan());       //Må lage isVegan funksjon
        System.out.println("This is not a vegan diet"); //Dette skrives ut hvis hele testen kjøres gjennom
    }

    //TODO Req 1C
    //A: a vegan diet with only vegan food
    //B: a vegan diet with non vegan food = exception

    @Test
    public void veganDietWith(){

    }

    @Test
    public void durationInYearsShouldBeReturnedInTheCorrectFormat() {
        // TODO: Her skal duration består av flere år.
        VeganDiet VD = new VeganDiet(365,"idk", new ArrayList<>());
        Assert.assertEquals(VD.writeDuration(),"This VeganDiet lasts for 1 years, 0 months and 0 days" );
    }

    @Test
    public void durationInMonthsShouldBeReturnedInTheCorrectFormat() {
        // TODO: Her skal duration består av noe månder.
        HyperCaloricDiet HC = new HyperCaloricDiet(30,"idk", new ArrayList<>());
        Assert.assertEquals(HC.writeDuration(), "This HyperCaloricDiet lasts for 0 years, 1 months and 0 days");
    }

    @Test
    public void durationInDaysShouldBeReturnedInTheCorrectFormat() {
        // TODO: Her skal duration består av noe dager.
        LowCarbDiet LD = new LowCarbDiet(8,30, "idk", new ArrayList<>());
        Assert.assertEquals("This LowCarbDiet lasts for 0 years, 1 months and 0 days", LD.writeDuration());
        LowCarbDiet LD2 = new LowCarbDiet(8,396, "idk", new ArrayList<>());
        Assert.assertEquals("This LowCarbDiet lasts for 1 years, 1 months and 1 days", LD2.writeDuration());
    }

    @Test
    public void allowedFoodShouldBeReturnedInTheCorrectFormat() {
        // TODO: Her skal noe diet object lages med noe som helst allowedFood, og sjekkes om det ble retunert i riktig format.
        ArrayList<Food> food = new ArrayList();
        food.add(new Food("Strawberry", 100, false, Food.FoodType.PROTEIN));
        food.add(new Food("Soup", 100, false, Food.FoodType.FAT));
        food.add(new Food("Apple", 100, false, Food.FoodType.CARB));
        Food prefferedMeat = new Food("Steak", 100, false, Food.FoodType.PROTEIN);
        FlexitarianDiet FD = new FlexitarianDiet(3, prefferedMeat, 10, "idk", food);

        String result = "The following food is allowed in this FlexitarianDiet: Strawberry, Soup, Apple";
        Assert.assertEquals(result, FD.writeAllowedFood());
    }

    @Test
    /*
     * TODO: 1.a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false)
     */
    public void dietShouldBeNonVeganIfItContainsAnyNonVeganFood() {
    }

    @Test
    /*
     * TODO: 1.a: If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet (e.g., it could be a LowCarbDiet).
     */
    public void dietShouldBeVeganIfItContainsOnlyVeganFood() {
    }
}
