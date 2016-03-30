package library.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeMap {

    private static Map<String, Recipe> recipeMap = new TreeMap<>();

    public void addRecipes(Recipe... recipes) {
        Arrays.stream(recipes).forEach(r -> recipeMap.put(r.getName(), r));
    }

    public static void addRecipe(Recipe recipe) {
        recipeMap.put(recipe.getName(), recipe);

        saveRecipes();
    }

    public static void setRecipeMap(Map<String, Recipe> recipesMap) {
        recipeMap = recipesMap;
    }

    public static Map<String, Recipe> getRecipeMap() {
        return recipeMap;
    }

    public static Recipe getRecipe(String name) {
        return recipeMap.get(name);
    }

    public static void replaceRecipe(String recipeToEdit, Recipe newRecipe){
        recipeMap.remove(recipeToEdit);
        addRecipe(newRecipe);
    }


    private static void saveRecipes() {
        JSONArray jsonArray = new JSONArray();

        recipeMap.forEach((name, recipe) -> {
            JSONObject jsonRecipe = JsonConverter.convertRecipeToJson(recipe);
            jsonArray.add(jsonRecipe);
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("recipes", jsonArray);

        try (FileWriter fileWriter = new FileWriter("recipes.json")) {
            jsonObject.writeJSONString(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadRecipes() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("recipes.json"));

        JSONArray recipes = (JSONArray) jsonObject.get("recipes");


        recipes.forEach(jsonRecipe -> {
            Recipe recipe = JsonConverter.convertJsonToRecipe((JSONObject) jsonRecipe);
            recipeMap.put(recipe.getName(), recipe);
        });

    }

}
