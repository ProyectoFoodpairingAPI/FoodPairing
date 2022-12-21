package space.harbour.countries.service;

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
                .baseUrl("https://world.openfoodfacts.org/api/v0/product/")
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

    public List<Food> getFoodCategory(String Category) {
        Call<List<Food>> foodCall = api.getCategory(Category);
        System.out.println("getFoodCategory:"+foodCall);
        try {
            Response<List<Food>> response = JSONtoFoodList.getFoodList(foodCall.execute());
            System.out.println("getFoodCategory:"+response);
            return response.body();
        } catch (IOException ioe) {
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
