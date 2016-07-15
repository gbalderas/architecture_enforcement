package library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class Search {

    private Search(){}

    public static ObservableList<String> forRecipes(String query){
        List<String> list = RecipeMap.getRecipes().entrySet().stream()
                .filter(item -> containsQuery(item.getValue(), query.toLowerCase()))
                .map(item -> item.getValue().getName())
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(list);
        
    }

    private static Boolean containsQuery(Recipe recipe, String query){
        return recipe.getName().toLowerCase().contains(query);
    }

     Button awtButton = new Button("AWT");
     JButton swingButton = new JButton("Swing");
     static javafx.scene.control.Button javafxButton = new javafx.scene.control.Button("javaFX");

    private void someMethod(){
        awtButton.getName();


        Button awtButton = new Button("new awt");
        awtButton.getLabel();

        JButton swingButton = new JButton("new swing");
        swingButton.getText();

        javafx.scene.control.Button javafxButton = new javafx.scene.control.Button("new javafx");
        javafxButton.getText();
    }

}
