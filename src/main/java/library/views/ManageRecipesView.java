package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.07.2016.
 */
public class ManageRecipesView implements Initializable, FxmlView<ManageRecipesViewModel> {

    @InjectViewModel
    ManageRecipesViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void addNewRecipe(ActionEvent event) {
        viewModel.addNewRecipe();
    }

    @FXML
    public void editRecipe(ActionEvent actionEvent) {
        viewModel.editRecipe();
    }
}
