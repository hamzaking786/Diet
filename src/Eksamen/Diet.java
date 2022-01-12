package Eksamen;

import java.util.ArrayList;

public abstract class Diet {
    //Attributes
    public int daysDuration;
    public String purpose;
    public boolean isVegan;
    public ArrayList<Food> allowedFood;

    //Construction
    protected Diet(int daysDuration, String purpose, ArrayList<Food> allowedFood) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = calculateIsVegan();
    }

    public abstract boolean isFoodAllowed(Food food);

    public boolean isCompatible(Person person) {
        //  ii. They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
        ArrayList<Food> allergies = person.getAllergies();
        int counter = 0;

        //Check how many foods in allowedFood that you are allergic too
        for (Food allergicFood : allergies) {
            for (Food aFood : allowedFood) {
                System.out.println(allergicFood.name + " equals " + aFood.name);
                if (aFood.name.equals(allergicFood.name)) {
                    counter++;
                    break;
                }
            }
        }
        int total50Percent = allowedFood.size() / 2;
        System.out.println("HALF:  " + total50Percent);
        System.out.println("counter: " + counter);
        if (counter >= total50Percent && counter > 0 && total50Percent > 0) {
            System.out.println("returning false");
            return false;
        }

        return true;
    }

    //Methods
    public String writeDuration() {
        // TODO: Write the duration of a diet in terms of years, months and days, e.g., “This
        //  VeganDiet lasts for 2 years, 3 months and 5 days”

        int year, month, week, days;

        year = this.daysDuration / 365;
        month = (this.daysDuration - (year * 365)) / 30;
        days = (this.daysDuration - (year * 365) - (month * 30));

        return "This " +
                this.getClass().getSimpleName() +
                " lasts for " +
                year +
                " years, " +
                month +
                " months and " +
                days +
                " days";
    }

    public String writeAllowedFood() {
        // TODO: Write the allowed food, e.g., “The following food is allowed in this
        //  FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”.
        // Use isFoodAllowed method to check if the food i allowed.

        String foodList = "The following food is allowed in this diet: ";
        for (Food f : allowedFood) {
            if (isFoodAllowed(f)) {
                foodList += f.getName() + ", ";
            }
        }
        foodList = foodList.substring(0, foodList.length() - 2); // Remove comma and space at the end
        return foodList;
    }

    public boolean calculateIsVegan() {
        for (Food food : allowedFood) {
            // 1.a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).
            if (!food.isVegan()) {
                return false;
            }
        }
        // 1.b: If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet (e.g., it could be a LowCarbDiet).
        return true;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }
}
