package library.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by balderas on 22.03.16.
 */
public class Recipe {


    private ArrayList<String> ingredients;
    private String name;
    private String difficulty;
    private String preparation;
    private String instructions;


    public Recipe(String name, String difficulty, String preparation, String instructions, String[] ingredients) {
        this.name = name;
        this.difficulty = difficulty;
        this.preparation = preparation;
        this.instructions = instructions;
        this.ingredients = new ArrayList<>();
        Collections.addAll(this.ingredients, ingredients);
    }

    public Recipe(String name, String difficulty, String preparation, String instructions, ArrayList<String> ingredients) {
        this.name = name;
        this.difficulty = difficulty;
        this.preparation = preparation;
        this.instructions = instructions;
        this.ingredients = ingredients;
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

    public String getInstructions() {
        return instructions;
    }
}
