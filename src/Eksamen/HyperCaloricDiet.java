package Eksamen;

import java.util.ArrayList;

public class HyperCaloricDiet extends Diet {
    //Attributes
    private float maxWeightKg;
    private float minCaloriesPerDay;

    //Construction
    public HyperCaloricDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood) {
        super(daysDuration, purpose, allowedFood);
    }

    public HyperCaloricDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float maxWeightKg, float minCaloriesPerDay) {
        super(daysDuration, purpose, allowedFood);
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    @Override
    public boolean isCompatible(Person person) {
        if (super.isCompatible(person)) { // True
            return person.getWeight() < this.maxWeightKg;
            // iv. If they weigh more than the limit set by the HyperCaloricDiet, they cannot be following this diet (for health reasons).
        }
        return false;
    }

    @Override
    public boolean isFoodAllowed(Food food) {
        return true;
    }

    public float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }

    public void setMinCaloriesPerDay(float minCaloriesPerDay) {
        this.minCaloriesPerDay = minCaloriesPerDay;
    }
}
