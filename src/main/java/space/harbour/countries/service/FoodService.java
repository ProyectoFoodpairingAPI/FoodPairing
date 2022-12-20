package space.harbour.countries.service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.harbour.countries.domain.Country;
import space.harbour.countries.domain.Food;
import space.harbour.countries.util.Constants;

import java.io.IOException;
import java.util.List;

public class FoodService {
    private FoodApiService api;

    public FoodService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://world.openfoodfacts.org/api/v0/product/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FoodApiService.class);
    }

    public List<Food> getAllFood() {
        Call<List<Food>> allFoodCall = api.getAllFood();
        try {
            Response<List<Food>> response = allFoodCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }


}
