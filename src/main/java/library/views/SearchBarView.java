package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class SearchBarView implements FxmlView<SearchBarViewModel>, Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    @InjectViewModel
    private SearchBarViewModel viewModel;

    public void initialize(URL location, ResourceBundle resources) {
        searchTextField.textProperty().bindBidirectional(viewModel.getSearchFieldTextProperty());
        searchTextField.setOnKeyReleased(event -> search());
    }

    @FXML
    public void search() {
        if (searchTextField.getText().isEmpty()) {
            viewModel.searchWasEmpty();
        } else {
            viewModel.search(searchTextField.getText());
        }
    }

}
