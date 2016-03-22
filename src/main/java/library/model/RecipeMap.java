package library.model;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeMap {

    private static Map<String,Recipe> recipeMap = new TreeMap<>();

    public void addRecipes(Recipe... recipes){
        Arrays.stream(recipes).forEach(r -> recipeMap.put(r.getName(), r));
    }

    public static void addRecipe(Recipe recipe){
        recipeMap.put(recipe.getName(), recipe);
    }

    public static void setRecipeMap(Map<String, Recipe> recipesMap) {
        recipeMap = recipesMap;
    }

    public static Map<String, Recipe> getRecipeMap() {
        return recipeMap;
    }

    public static Recipe getRecipe(String name){
        return recipeMap.get(name);
    }

}
