package Eksamen;

public class Food {
    //Attributes
    public String name;
    public float caloriesPer100g;
    public boolean isVegan;
    public FoodType type;

    //Construction
    public Food(String name, float caloriesPer100g, boolean isVegan, FoodType type) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.isVegan = isVegan;
        this.type = type;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(float caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    /*
    * Assumption that same type food are the same
    * TODO: Add this assumption to the test plan
     */
    public boolean equals(Food food2) {
        return this.type == food2.type;
    }

    //Creating an enum object before attribute
    public enum FoodType {
        RECIPE,
        PROTEIN,
        CARB,
        FAT
    }
}
