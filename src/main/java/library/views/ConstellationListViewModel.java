package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.model.ConstellationMap;
import library.model.ConstellationMapMock;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class ConstellationListViewModel implements ViewModel {

    private ObservableList<String> list = FXCollections.observableArrayList();
    private static ConstellationListViewModel INSTANCE;

    public ConstellationListViewModel() {
        INSTANCE = this;
        ConstellationMapMock constellationImplMock = new ConstellationMapMock();
        constellationImplMock.getConstellationMap().forEach((name, constellation) -> list.addAll(name));

        ConstellationMap.setConstellationMap(constellationImplMock.getConstellationMap());
        itemsProperty.setValue(list);
    }

    private ObjectProperty<ObservableList<String>> itemsProperty = new SimpleObjectProperty<>();


    public ObjectProperty<ObservableList<String>> getItemsProperty() {
        return itemsProperty;
    }

    public void constellationClicked(String selectedConstellation) {
        ConstellationInformationViewModel.getINSTANCE().displayConstellationInformation(selectedConstellation);
    }

    public static ConstellationListViewModel getINSTANCE() {
        return INSTANCE;
    }

    public void resetList(){
        itemsProperty.setValue(list);
    }

}
