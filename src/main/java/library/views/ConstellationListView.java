package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.03.2016.
 */
public class ConstellationListView implements FxmlView<ConstellationListViewModel>, Initializable{

    @FXML
    public ListView<String> constellationList;

    @InjectViewModel
    private ConstellationListViewModel viewModel;

    public void initialize(URL location, ResourceBundle resources) {
        constellationList.itemsProperty().bind(viewModel.getItemsProperty());

//        Date date = new Date();
    }

    @FXML
    public void clickedItem(Event event) {
        String selectedConstellation = constellationList.getSelectionModel().getSelectedItem();
        if(selectedConstellation == null)
            return;
        viewModel.constellationClicked(selectedConstellation);
    }


}
