package library.views;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.model.RecipeMap;
import library.scopes.MyScope;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeListViewModel implements ViewModel {

    @InjectScope
    private MyScope scope;

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
        SimpleStringProperty stringProperty = new SimpleStringProperty(selectedRecipe);
        scope.setSelectedElement(stringProperty);
        scope.publish("something_has_changed");

        RecipeDescriptionViewModel.getInstance().displayRecipe(selectedRecipe);
    }

    public static RecipeListViewModel getInstance() {
        return instance;
    }

    public void resetList() {
        itemsProperty.setValue(list.sorted());
    }


}
