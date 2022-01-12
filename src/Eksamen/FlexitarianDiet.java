package Eksamen;

import java.util.ArrayList;

public class FlexitarianDiet extends Diet {

    private float maxMeatGramsPerWeek;
    private Food preferredMeat;

    //Construction
    public FlexitarianDiet(float maxMeatGramsPerWeek, Food preferredMeat, int daysDuration, String purpose, ArrayList<Food> allowedFood) {
        super(daysDuration, purpose, allowedFood);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
        if (preferredMeat != null && !preferredMeat.isVegan() && preferredMeat.getType() == Food.FoodType.PROTEIN) {
            this.preferredMeat = preferredMeat;
        } else {
            throw new IllegalArgumentException("The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein type.");
        }
    }

    @Override
    public boolean isFoodAllowed(Food food) {
        return true;
    }

    public float getMaxMeatGramsPerWeek() {
        return maxMeatGramsPerWeek;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }
}
