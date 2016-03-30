package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */

public class RecipeDescriptionView implements FxmlView<RecipeDescriptionViewModel>, Initializable{

    @FXML
    private Label nameLabel;

    @FXML
    private Label difficultyLabel;

    @FXML
    private Label ingredientsLabel;

    @FXML
    private Label preparationLabel;

    @FXML
    private Label instructionsLabel;

    @InjectViewModel
    private RecipeDescriptionViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameLabel.textProperty().bind(viewModel.getNameProperty());
        difficultyLabel.textProperty().bind(viewModel.getDifficultyProperty());
        ingredientsLabel.textProperty().bind(viewModel.getIngredientsProperty());
        preparationLabel.textProperty().bind(viewModel.getPreparationProperty());
        instructionsLabel.textProperty().bind(viewModel.getCookingInstructionsProperty());

    }
}
