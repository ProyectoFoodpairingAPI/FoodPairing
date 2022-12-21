package space.harbour.countries.task;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import space.harbour.countries.domain.Food;

import java.lang.reflect.Type;
import java.util.List;

public abstract class JSONtoFoodList {

    public static List<Food> getFoodList(JsonObject json) {

        List<Food> foodList = null;
        Food comida = null;
        JsonArray jsonArray = json.getAsJsonArray("products");

        for(int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            comida = new Food(jsonObject.getAsJsonObject("id").getAsString(),
                    jsonObject.getAsJsonObject("abbreviated_product_name").getAsString(),
                    jsonObject.getAsJsonObject("brands").getAsString(),
                    jsonObject.getAsJsonObject("categories").getAsString()
            );
            foodList.add(comida);

        }
        System.out.println("getFoodList:"+foodList.toString());
        return foodList;
    }
}
