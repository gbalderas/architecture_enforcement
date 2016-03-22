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
    private DialogPane DialogPane;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField DifficultyTextField;

    @FXML
    private TextField IngredientsTextField;

    @FXML
    private TextArea PreparationTextArea;

    @FXML
    private TextArea InstructionsTextArea;

    @InjectViewModel
    private RecipeViewModel viewModel;

    private Button finishButton, cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        finishButton = (Button) DialogPane.lookupButton(ButtonType.FINISH);
        cancelButton = (Button) DialogPane.lookupButton(ButtonType.CANCEL);

        finishButton.setOnAction(event -> {
                viewModel.finishRecipe();
                DialogPane.getScene().getWindow().hide();
        });
        cancelButton.setOnAction(event -> {
            viewModel.cancelRecipe();
            DialogPane.getScene().getWindow().hide();
        });

        NameTextField.textProperty().bindBidirectional(viewModel.getNameProperty());
        DifficultyTextField.textProperty().bindBidirectional(viewModel.getDifficultyProperty());
        IngredientsTextField.textProperty().bindBidirectional(viewModel.getIngredientsProperty());
        PreparationTextArea.textProperty().bindBidirectional(viewModel.getPreparationProperty());
        InstructionsTextArea.textProperty().bindBidirectional(viewModel.getInstructionsProperty());

    }
}
