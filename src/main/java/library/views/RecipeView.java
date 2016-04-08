package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeView implements FxmlView<RecipeViewModel>, Initializable{

    @FXML
    private DialogPane dialogPane;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField difficultyTextField;

    @FXML
    private TextField ingredientsTextField;

    @FXML
    private TextArea preparationTextArea;

    @FXML
    private TextArea instructionsTextArea;

    @InjectViewModel
    private RecipeViewModel viewModel;

    private Button finishButton;
    private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        finishButton = (Button) dialogPane.lookupButton(ButtonType.FINISH);
        cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);

        finishButton.setOnAction(event -> {
                viewModel.finishRecipe();
                dialogPane.getScene().getWindow().hide();
        });
        cancelButton.setOnAction(event -> {
            viewModel.cancelRecipe();
            dialogPane.getScene().getWindow().hide();
        });

        nameTextField.textProperty().bindBidirectional(viewModel.getNameProperty());
        difficultyTextField.textProperty().bindBidirectional(viewModel.getDifficultyProperty());
        ingredientsTextField.textProperty().bindBidirectional(viewModel.getIngredientsProperty());
        preparationTextArea.textProperty().bindBidirectional(viewModel.getPreparationProperty());
        instructionsTextArea.textProperty().bindBidirectional(viewModel.getInstructionsProperty());
    }
}
