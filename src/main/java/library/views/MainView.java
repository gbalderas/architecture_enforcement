package library.views;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class MainView implements FxmlView<MainViewModel>, Initializable {



    @InjectViewModel
    MainViewModel viewModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage recipeStage = new Stage();
        recipeStage.setTitle("My New Stage Title");
        recipeStage.setScene(new Scene(FluentViewLoader.fxmlView(RecipeView.class).load().getView()));

        viewModel.setRecipeStage(recipeStage);
    }


}
