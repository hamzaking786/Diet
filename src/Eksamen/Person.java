package Eksamen;

import java.util.ArrayList;

public class Person {

    //Attributes
    private int weight;
    private Food favoriteFood;
    private Diet diet;
    private ArrayList<Food> allergies;

    public Person(int weight, Food favoriteFood, ArrayList<Food> allergies) {
        this.weight = weight;
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public ArrayList<Food> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<Food> allergies) {
        this.allergies = allergies;
    }

    public boolean favoriteFood(boolean b) {
        return true;
    }
}

