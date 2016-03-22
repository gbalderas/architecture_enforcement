package library.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by balderas on 22.03.16.
 */
public class Recipe {


    final private ArrayList<String> ingredients = new ArrayList<>();
    final private String name;
    final private String difficulty;
    final private String preparation;
    final private String cookingInstructions;


    public Recipe(String name, String difficulty, String preparation, String cookingInstructions, String[] ingredients) {
        this.name = name;
        this.difficulty = difficulty;
        this.preparation = preparation;
        this.cookingInstructions = cookingInstructions;
        Collections.addAll(this.ingredients, ingredients);
    }


    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }
}
