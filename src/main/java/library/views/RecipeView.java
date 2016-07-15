package library.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import library.model.Recipe;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private ComboBox<Recipe> comboBox = new ComboBox<>();
    private Recipe recipe = new Recipe("a","b","c","d", new String[]{"a"});;

    private Button finishButton;
    private Button cancelButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox = new ComboBox<>();
        System.out.println(comboBox.toString());
        recipe = new Recipe("a","b","c","d", new String[]{"a"});
        Object a = getMyList();
        Object b = getMyObjectList();
        ((List<Recipe>) b).add(recipe);
        ((List<Recipe>) a).size();
        recipe.getName();
        System.out.println(((List<Recipe>) b).get(0));
        ObservableList<Recipe> list = FXCollections.observableArrayList();
        list.forEach(System.out::println);
        comboBox.itemsProperty().setValue(list);
        list.add(recipe);

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


    private List<Recipe> myList = new ArrayList<>();

    public List<Recipe> getMyList(){
        return myList;
    }

    public void setMyList(String test,  List<Recipe> list, int something, String string){
        myList = list;
    }

    public void setRecipe(Recipe r , String bla){
        recipe = r;
    }

    private Object getMyObjectList(){
        return getMyList();
    }

}
