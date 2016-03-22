package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.model.Recipe;
import library.model.RecipeMap;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeDescriptionViewModel implements ViewModel {

    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty difficultyProperty = new SimpleStringProperty();
    private StringProperty ingredientsProperty = new SimpleStringProperty();
    private StringProperty preparationProperty = new SimpleStringProperty();
    private StringProperty cookingInstructionsProperty = new SimpleStringProperty();

    private static RecipeDescriptionViewModel INSTANCE;

    public RecipeDescriptionViewModel() {
        INSTANCE = this;
    }

    public void displayRecipe(String selectedRecipe) {
        Recipe recipe = RecipeMap.getRecipe(selectedRecipe);

        nameProperty.setValue(recipe.getName());
        difficultyProperty.setValue(recipe.getDifficulty());
//        ingredientsProperty.setValue(recipe.getIngredients());
        preparationProperty.setValue(recipe.getPreparation());
        cookingInstructionsProperty.setValue(recipe.getCookingInstructions());
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

    public StringProperty getCookingInstructionsProperty(){
        return cookingInstructionsProperty;
    }

    public static RecipeDescriptionViewModel getINSTANCE() {
        return INSTANCE;
    }
}
