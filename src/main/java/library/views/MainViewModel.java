package library.views;

import de.saxsys.mvvmfx.ViewModel;
import javafx.stage.Stage;

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

}
