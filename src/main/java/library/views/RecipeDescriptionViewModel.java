package library.views;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.model.Recipe;
import library.model.RecipeMap;
import library.scopes.MyScope;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeDescriptionViewModel implements ViewModel {

    @InjectScope
    private MyScope scope;

    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty difficultyProperty = new SimpleStringProperty();
    private StringProperty ingredientsProperty = new SimpleStringProperty();
    private StringProperty preparationProperty = new SimpleStringProperty();
    private StringProperty cookingInstructionsProperty = new SimpleStringProperty();

    private static RecipeDescriptionViewModel instance;

    public RecipeDescriptionViewModel() {
         instance = this;
    }

    public void initialize(){
        scope.subscribe("something_has_changed", (key, payload) -> {
            System.out.println(scope.selectedElementProperty().get());
        });
    }

    public void displayRecipe(String selectedRecipe) {
        Recipe recipe = RecipeMap.getRecipe(selectedRecipe);

        nameProperty.setValue(recipe.getName());
        difficultyProperty.setValue(recipe.getDifficulty());
        preparationProperty.setValue(recipe.getPreparation());
        cookingInstructionsProperty.setValue(recipe.getInstructions());
//        ingredientsProperty.setValue(recipe.getIngredients());
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

    public static RecipeDescriptionViewModel getInstance() {
        return instance;
    }


}
