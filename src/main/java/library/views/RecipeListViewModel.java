package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.model.Recipe;
import library.model.RecipeMap;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeListViewModel implements ViewModel {

    private ObservableList<String> list = FXCollections.observableArrayList();
    private static RecipeListViewModel instance;
    private ObjectProperty<ObservableList<String>> itemsProperty = new SimpleObjectProperty<>();

    public RecipeListViewModel() {
        instance = this;
        RecipeMap.loadRecipes();
        RecipeMap.getRecipes().forEach((name, recipe) -> list.add(name));
        itemsProperty.setValue(list.sorted());
    }


    public ObjectProperty<ObservableList<String>> getItemsProperty() {
        return itemsProperty;
    }

    public void recipeClicked(String selectedRecipe) {
        RecipeDescriptionViewModel.getInstance().displayRecipe(selectedRecipe);
    }

    public static RecipeListViewModel getInstance() {
        return instance;
    }

    public void resetList() {
        itemsProperty.setValue(list.sorted());
    }

    public void addNewRecipe() {
        MainViewModel.getInstance().getRecipeStage().showAndWait();
        Recipe newRecipe = RecipeViewModel.getInstance().getRecipe();
        if (newRecipe != null) {
            RecipeMap.addRecipe(newRecipe);
            list.add(newRecipe.getName());
        }
    }

    public void editRecipe(String selectedRecipe) {
        Recipe recipe = RecipeMap.getRecipe(selectedRecipe);
        RecipeViewModel.getInstance().setRecipeFields(recipe);
        MainViewModel.getInstance().getRecipeStage().showAndWait();
        recipe = RecipeViewModel.getInstance().getRecipe();
        if (recipe != null) {
            RecipeMap.replaceRecipe(selectedRecipe, recipe);
            list.remove(selectedRecipe);
            list.add(recipe.getName());
            recipeClicked(recipe.getName());
        }

    }

}
