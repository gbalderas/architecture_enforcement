package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.model.Constellation;
import library.model.ConstellationMap;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class ConstellationInformationViewModel implements ViewModel {

    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty abbvProperty= new SimpleStringProperty();
    private StringProperty familyProperty= new SimpleStringProperty();
    private StringProperty meaningProperty= new SimpleStringProperty();

    private static ConstellationInformationViewModel INSTANCE;

    public ConstellationInformationViewModel() {
        INSTANCE = this;
    }

    public void displayConstellationInformation(String selectedConstellation) {
        Constellation constellation = ConstellationMap.getConstellation(selectedConstellation);

        nameProperty.setValue(constellation.getName());
        abbvProperty.setValue(constellation.getAbbreviation());
        familyProperty.setValue(constellation.getFamily());
        meaningProperty.setValue(constellation.getMeaning());
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public StringProperty getAbbvProperty() {
        return abbvProperty;
    }

    public StringProperty getFamilyProperty() {
        return familyProperty;
    }

    public StringProperty getMeaningProperty() {
        return meaningProperty;
    }

    public static ConstellationInformationViewModel getINSTANCE() {
        return INSTANCE;
    }
}
