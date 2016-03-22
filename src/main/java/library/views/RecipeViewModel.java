package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.model.Recipe;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeViewModel implements ViewModel {



    private static Recipe recipe;
    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty difficultyProperty = new SimpleStringProperty();
    private StringProperty ingredientsProperty = new SimpleStringProperty();
    private StringProperty preparationProperty = new SimpleStringProperty();
    private StringProperty instructionsProperty = new SimpleStringProperty();


    public RecipeViewModel(){

    }


    public void finishRecipe(){

        String[] ingredients = ingredientsProperty.get().split(";");
        String name = nameProperty.get();
        String difficulty = difficultyProperty.get();
        String preparation = preparationProperty.get();
        String instructions = instructionsProperty.get();

        recipe = new Recipe(name, difficulty, preparation, instructions, ingredients);
    }

    public void cancelRecipe(){
        System.out.println("CANCELED RECIPE");
        recipe = null;
    }

    public static Recipe getRecipe() {
        return recipe;
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }


    public StringProperty getDifficultyProperty() {
        return difficultyProperty;
    }

    public StringProperty getIngredientsProperty() {
        return ingredientsProperty;
    }

    public StringProperty getPreparationProperty() {
        return preparationProperty;
    }

    public StringProperty getInstructionsProperty() {
        return instructionsProperty;
    }
}

