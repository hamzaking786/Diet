package Eksamen;

import java.util.ArrayList;

public class LowCarbDiet extends Diet {
    //Attributes
    private float minWeightKg;

    //Construction
    public LowCarbDiet(float minWeightKg, int daysDuration, String purpose, ArrayList<Food> allowedFood) {
        super(daysDuration, purpose, allowedFood);
        this.minWeightKg = minWeightKg;
    }

    @Override
    public boolean isCompatible(Person person) {
        if (super.isCompatible(person)) {
            // iii. If they weigh less than the limit set by the LowCarbDiet, they cannot be following this diet (for health reasons).
            return person.getWeight() >= this.minWeightKg;
        }
        return false;
    }

    @Override
    public boolean isFoodAllowed(Food food) {
        // TODO: 1.e: The maximum carb-type foods that can be included in a LowCarbDiet is two.
        int counter = 0;
        for (Food f : this.getAllowedFood()) {
            if (f.getType() == Food.FoodType.CARB) {
                counter++;
            }
        }
        return counter < 2 || food.getType() != Food.FoodType.CARB;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
