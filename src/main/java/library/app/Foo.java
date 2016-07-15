package library.app;

import javafx.scene.control.ComboBox;
import library.model.Recipe;

import java.util.List;

public class Foo {

    static List<String> myStrings;
    static List<Float>  myFloats;

    static ComboBox<Recipe> myComboBox;

    public static List<String> getStrings() { return myStrings; }
    public static List<Float> getFloats() { return myFloats; }

    public static ComboBox<Recipe> getMyComboBox(){
        return myComboBox;
    }

    public static void addStrings(List<String> evenMoreStrings) {
        myStrings.addAll(evenMoreStrings);
    }

}