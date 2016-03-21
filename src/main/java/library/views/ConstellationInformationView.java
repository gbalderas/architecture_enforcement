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
public class ConstellationInformationView implements FxmlView<ConstellationInformationViewModel>, Initializable{

    @FXML
    public Label abbreviationLabel;

    @FXML
    public Label nameLabel;

    @FXML
    public Label familyLabel;

    @FXML
    public Label meaningLabel;

    @InjectViewModel
    private ConstellationInformationViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.textProperty().bind(viewModel.getNameProperty());
        abbreviationLabel.textProperty().bind(viewModel.getAbbvProperty());
        familyLabel.textProperty().bind(viewModel.getFamilyProperty());
        meaningLabel.textProperty().bind(viewModel.getMeaningProperty());
    }
}
