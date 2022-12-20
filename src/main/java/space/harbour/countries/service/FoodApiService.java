package space.harbour.countries.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import space.harbour.countries.domain.Country;
import space.harbour.countries.domain.Food;

import java.util.List;

public interface FoodApiService {
    @GET("/v3.1/all")
    Call<List<Food>> getAllFood();


}
