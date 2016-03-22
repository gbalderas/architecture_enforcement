package library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class Search {
    
    public static ObservableList<String> forRecipes(String query){
        List<String> list = RecipeMap.getRecipeMap().entrySet().stream()
                .filter(item -> containsQuery(item.getValue(), query.toLowerCase()))
                .map(item -> item.getValue().getName())
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(list);
        
    }

    private static Boolean containsQuery(Recipe recipe, String query){
        return (recipe.getName().toLowerCase().contains(query));
    }

}
