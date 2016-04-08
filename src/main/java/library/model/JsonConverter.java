package library.model;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by balderas on 23.03.16.
 */
public class JsonConverter {

    private JsonConverter(){}


    public static JSONObject convertRecipeToJson(Recipe recipe){

        JSONObject jsonRecipe = new JSONObject();

        jsonRecipe.put("name", recipe.getName());
        jsonRecipe.put("difficulty", recipe.getDifficulty());
        jsonRecipe.put("preparation", recipe.getPreparation());
        jsonRecipe.put("instructions", recipe.getInstructions());
        jsonRecipe.put("ingredients", recipe.getIngredients());

        return jsonRecipe;
    }


    public static Recipe convertJsonToRecipe(JSONObject jsonRecipe){

        String name = jsonRecipe.get("name").toString();
        String difficulty = jsonRecipe.get("difficulty").toString();
        String preparation = jsonRecipe.get("preparation").toString();
        String instructions = jsonRecipe.get("instructions").toString();

        JSONArray ingredients = (JSONArray) jsonRecipe.get("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        ingredients.forEach(i-> ingredientsList.add(i.toString()));

        return new Recipe(name, difficulty, preparation, instructions, ingredientsList);

    }


}
