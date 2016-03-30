package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.model.Recipe;
import library.model.RecipeMap;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeListViewModel implements ViewModel {

    private ObservableList<String> list = FXCollections.observableArrayList();
    private static RecipeListViewModel INSTANCE;
    private ObjectProperty<ObservableList<String>> itemsProperty = new SimpleObjectProperty<>();

    public RecipeListViewModel() {
        INSTANCE = this;
        try {
            RecipeMap.loadRecipes();
            RecipeMap.getRecipeMap().forEach((name, recipe) -> list.add(name));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        itemsProperty.setValue(list.sorted());
    }


    public ObjectProperty<ObservableList<String>> getItemsProperty() {
        return itemsProperty;
    }

    public void recipeClicked(String selectedRecipe) {
        RecipeDescriptionViewModel.getINSTANCE().displayRecipe(selectedRecipe);
    }

    public static RecipeListViewModel getINSTANCE() {
        return INSTANCE;
    }

    public void resetList(){
        itemsProperty.setValue(list.sorted());
    }

    public void addNewRecipe() {
        MainViewModel.getRecipeStage().showAndWait();
        Recipe newRecipe = RecipeViewModel.getINSTANCE().getRecipe();
        if(newRecipe != null){
            RecipeMap.addRecipe(newRecipe);
            list.add(newRecipe.getName());
        }
    }

    public void editRecipe(String selectedRecipe){
        Recipe recipe = RecipeMap.getRecipe(selectedRecipe);
        RecipeViewModel.getINSTANCE().setRecipeFields(recipe);
        MainViewModel.getRecipeStage().showAndWait();
        recipe = RecipeViewModel.getINSTANCE().getRecipe();
        if(recipe != null){
            RecipeMap.replaceRecipe(selectedRecipe, recipe);
            list.remove(selectedRecipe);
            list.add(recipe.getName());
        }

        recipeClicked(recipe.getName());

    }

}
