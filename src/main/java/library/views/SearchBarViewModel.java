package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import library.model.SearchConstellations;


/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class SearchBarViewModel implements ViewModel{

    private StringProperty searchFieldTextProperty = new SimpleStringProperty();

    public StringProperty getSearchFieldTextProperty() {
        return searchFieldTextProperty;
    }

    public void search(String query) {
        ObservableList<String> constellations = SearchConstellations.getConstellations(query);

        ConstellationListViewModel.getINSTANCE().getItemsProperty().setValue(constellations);
    }


    public void searchWasEmpty() {
        ConstellationListViewModel.getINSTANCE().resetList();
    }
}
