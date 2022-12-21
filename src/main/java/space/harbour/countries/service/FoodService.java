package space.harbour.countries.service;

import com.google.gson.JsonObject;
import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.harbour.countries.domain.Country;
import space.harbour.countries.domain.Food;
import space.harbour.countries.task.JSONtoFoodList;
import space.harbour.countries.util.Constants;

import java.io.IOException;
import java.util.List;

public class FoodService {
    private FoodApiService api;
    //private final RestTemplate restTemplate;

    public FoodService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://world.openfoodfacts.org/cgi/search.pl?")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FoodApiService.class);
    }

    public List<Food> getAllFood() {
        Call<List<Food>> allFoodCall = api.getAllFood();
        System.out.println("allfood:"+allFoodCall.request().url());
        try {
            Response<List<Food>> response = allFoodCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }
    //ejemplo:
    //https://world.openfoodfacts.org/cgi/search.pl?categories_tags_en=pizza&search_simple=1&action=process&json=1
    //eso funciona
    public List<Food> getFoodCategory(String Category) {
        Call<JsonObject> foodCall = api.getCategory(Category);
        System.out.println("getFoodCategory:"+foodCall);
        try {
            //Response<List<Food>> response = JSONtoFoodList.getFoodList(foodCall.execute().body());
            System.out.println("getFoodCategory:"+foodCall.execute());
            List<Food> response = JSONtoFoodList.getFoodList(foodCall.execute().body());
            System.out.println("getFoodCategory:"+response);
            return response;
        } catch (IOException ioe) {
            System.out.println("getFoodCategory:Error");
            ioe.printStackTrace();
        }

        return null;
    }
/*
    public List<Food> getFoodCategoryRest(String Category) {
        String apiUrl="https://world.openfoodfacts.org/cgi/search.pl?categories_tags_en="+Category;
        try {
            return restTemplate.getForObject(apiUrl, List.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }*/


}
