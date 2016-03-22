package library.model;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeMapMock {

    private Map<String,Recipe> recipeMap = new TreeMap<>();

    public RecipeMapMock() {

        addRecipes(
                new Recipe("Corn Soup", "Easy", "None","Cook Corn in butter, blend with chicken broth, cook for 30 minutes", new String[]{"water", "corn", "butter"}),
                new Recipe("Sushi", "Medium", "Wash Rice, Slice everything in thin slices", "Add rice to Nori Sheet, add ingredients and roll", new String[]{"Sushi Rice, Water, Nori Sheet, your Ingredients"})
        );

    }

    private void addRecipes(Recipe... recipes){
        Arrays.stream(recipes).forEach(c -> recipeMap.put(c.getName(), c));
    }

    public Map<String, Recipe> getRecipeMap() {
        return recipeMap;
    }

}
