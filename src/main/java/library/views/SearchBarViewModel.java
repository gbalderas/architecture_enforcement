package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import library.model.Search;


/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class SearchBarViewModel implements ViewModel{

    private StringProperty searchFieldTextProperty = new SimpleStringProperty();

    public StringProperty getSearchFieldTextProperty() {
        return searchFieldTextProperty;
    }

    public void search() {
        String query = searchFieldTextProperty.getValue();
        if(query.isEmpty()){
            searchWasEmpty();
            return;
        }

        ObservableList<String> recepes = Search.forRecipes(query);

        RecipeListViewModel.getINSTANCE().getItemsProperty().setValue(recepes);
    }


    public void searchWasEmpty() {
        RecipeListViewModel.getINSTANCE().resetList();
    }
}
