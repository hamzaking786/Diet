package Eksamen;

import java.util.ArrayList;

public class VeganDiet extends Diet {

    //Attributes
    private float minWeightKg;

    //Construction
    public VeganDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood) {
        super(daysDuration, purpose, allowedFood);
    }

    public VeganDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, float minWeightKg) {
        super(daysDuration, purpose, allowedFood);
        this.minWeightKg = minWeightKg;
    }

    @Override
    public boolean isCompatible(Person person) {
        if (super.isCompatible(person)) {
            //  i. If their favorite food is non-vegan, they cannot follow a VeganDiet.
            //  iii. If they weigh less than the limit set by the VeganDiet, they cannot be following this diet (for health reasons).

            if (!person.getFavoriteFood().isVegan()) {
                return false;
            }

            return !(person.getWeight() < this.minWeightKg);
        }
        return false;
    }

    public boolean isFoodAllowed(Food food) {
        return food.isVegan;
    }
}
