package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class MainViewModel implements ViewModel{


    private static MainViewModel instance;

    private Stage recipeStage = new Stage();

    public MainViewModel(){
        instance = this;
    }



    public Stage getRecipeStage() {
        return recipeStage;
    }

    public void setRecipeStage(Stage stage){
        this.recipeStage = stage;
    }

    public static MainViewModel getInstance(){
        return instance;
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
