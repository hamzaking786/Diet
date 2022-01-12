package Eksamen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DietManager {
    public static void main(String[] args) {

    }

    /*
     * TODO: 2.a: Given a Person and a Diet, return true if they are compatible, false otherwise.
     *      i. If their favorite food is non-vegan, they cannot follow a VeganDiet.
     *     ii. They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
     *    iii. If they weigh less than the limit set by the VeganDiet or the LowCarbDiet, they cannot be following these diets (for health reasons).
     *     iv. If they weigh more than the limit set by the HyperCaloricDiet, they cannot be following this diet (for health reasons).
     */
    public boolean areCompatible(Person person, Diet diet) {
        return diet.isCompatible(person);
    }

    /*
     * TODO 2. Given a Person and a list of Food, create a random HyperCaloricDiet with following attributes
     *  (daysDuration, purpose, allowedFood, isVegan, maxWeightKg, minCaloriesPerDay)
     *      i. daysDuration: random number between 1 and 100.
     *     ii. purpose: “Random diet”.
     *    iii. allowedFood: all the Food from the list that the person is not allergic to.
     *     iv. isVegan: false if there is some non-vegan Food, true otherwise.
     *      v. maxWeightKg: random number between Person.weight and Person.weight + 20.
     *     vi. minCaloriesPerDay: random number between 2000 and 4000.
     */

    public HyperCaloricDiet randomDiet(Person p, Food[] foods) {
        int daysDuration = getRandomNumber(1,100);
        String purpose = getPurposeRandomDiet();
        ArrayList<Food> listOfFoods = new ArrayList<>(Arrays.asList(foods));
        //TODO all food from the parameter foods the user is not allergic to.
        ArrayList<Food> allowedFood = foodNotAllergicToo(p.getAllergies(), listOfFoods);

        int randomWeight = getRandomNumber(p.getWeight(), p.getWeight() + 20);
        int randomMinCaloriesPerDay = getRandomNumber(2000, 4000);

        return new HyperCaloricDiet(daysDuration, purpose, allowedFood, randomWeight, randomMinCaloriesPerDay);
    }

    // TODO Given 2 numbers find random number between them.
    public int getRandomNumber(int from, int to) {
        Random r = new Random();
        return r.nextInt(to-from)+from;
    }

    public String getPurposeRandomDiet() {
        return "Random Diet";
    }

    public boolean isVegan(Food[] foodList) {
        for (Food food : foodList) {
            // 1.a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).
            if (!food.isVegan()) {
                return false;
            }
        }
        // 1.b: If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet (e.g., it could be a LowCarbDiet).
        return true;
    }

    public ArrayList<Food> foodNotAllergicToo(ArrayList<Food> allergies, ArrayList<Food> foods) {
        System.out.println(allergies);
        System.out.println(foods);

        ArrayList<Food> notAllergicFood = new ArrayList();
        for(Food food: foods) {
            if (!allergies.contains(food)) {
                notAllergicFood.add(food);
            }
        }

        return notAllergicFood;
    }


}

