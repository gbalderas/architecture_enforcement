package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gerardo.balderas on 14.07.2016.
 */
public class MasterDetailAllView implements Initializable, FxmlView<MasterDetailAllViewModel>{

    @InjectViewModel
    MasterDetailAllViewModel viewModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
