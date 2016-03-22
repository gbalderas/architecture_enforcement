package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.model.Recipe;
import library.model.RecipeMap;
import library.model.RecipeMapMock;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeListViewModel implements ViewModel {

    private ObservableList<String> list = FXCollections.observableArrayList();
    private static RecipeListViewModel INSTANCE;
    private ObjectProperty<ObservableList<String>> itemsProperty = new SimpleObjectProperty<>();

    public RecipeListViewModel() {
        INSTANCE = this;
        RecipeMapMock recipeMapMock = new RecipeMapMock();
        recipeMapMock.getRecipeMap().forEach((name, recipe) -> list.add(name));
        RecipeMap.setRecipeMap(recipeMapMock.getRecipeMap());

        itemsProperty.setValue(list);
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
        itemsProperty.setValue(list);
    }

    public void addNewRecipe() {
        MainViewModel.getRecipeStage().showAndWait();
        Recipe newRecipe = RecipeViewModel.getRecipe();
        if(newRecipe != null){
            RecipeMap.addRecipe(newRecipe);
            list.add(newRecipe.getName());
        }

    }
}
