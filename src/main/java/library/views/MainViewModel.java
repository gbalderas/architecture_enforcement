package library.views;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewModel;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class MainViewModel implements ViewModel{

    private static final Stage recipeStage = new Stage();

    public MainViewModel() {
        recipeStage.setTitle("My New Stage Title");
        recipeStage.setScene(new Scene(FluentViewLoader.fxmlView(RecipeView.class).load().getView()));
    }


    public static Stage getRecipeStage() {
        return recipeStage;
    }
}
