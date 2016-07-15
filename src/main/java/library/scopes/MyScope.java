package library.scopes;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by gerardo.balderas on 14.07.2016.
 */
public class MyScope implements Scope {
    private StringProperty selectedElement = new SimpleStringProperty();

    public StringProperty selectedElementProperty() {
        return selectedElement;
    }

    public void setSelectedElement(StringProperty stringProperty){
        selectedElement = stringProperty;
    }
}