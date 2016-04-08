package library.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by balderas on 22.03.16.
 */
public class RecipeMap {

    private static Map<String, Recipe> recipes = new TreeMap<>();

    private RecipeMap(){}

    public static void addRecipe(Recipe recipe) {
        recipes.put(recipe.getName(), recipe);

        saveRecipes();
    }

    public static Map<String, Recipe> getRecipes() {
        return recipes;
    }

    public static Recipe getRecipe(String name) {
        return recipes.get(name);
    }

    public static void replaceRecipe(String recipeToEdit, Recipe newRecipe){
        recipes.remove(recipeToEdit);
        addRecipe(newRecipe);
    }


    private static void saveRecipes() {
        JSONArray jsonArray = new JSONArray();

        recipes.forEach((name, recipe) -> {
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

    public static void loadRecipes(){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader("recipes.json"));
            JSONArray recipes = (JSONArray) jsonObject.get("recipes");


            recipes.forEach(jsonRecipe -> {
                Recipe recipe = JsonConverter.convertJsonToRecipe((JSONObject) jsonRecipe);
                RecipeMap.recipes.put(recipe.getName(), recipe);
            });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

}
