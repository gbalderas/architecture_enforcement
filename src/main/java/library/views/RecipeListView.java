package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class RecipeListView implements FxmlView<RecipeListViewModel>, Initializable{

    @FXML
    public ListView<String> recipesList;

    @InjectViewModel
    private RecipeListViewModel viewModel;

    public void initialize(URL location, ResourceBundle resources) {
        recipesList.itemsProperty().bind(viewModel.getItemsProperty());

    }

    @FXML
    public void clickedItem(MouseEvent event) {
        String selectedRecipe = recipesList.getSelectionModel().getSelectedItem();
        if(selectedRecipe == null)
            return;
        viewModel.recipeClicked(selectedRecipe);
    }
}
