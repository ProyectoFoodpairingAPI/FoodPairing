package space.harbour.countries.task;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventType;
import space.harbour.countries.domain.Food;
import space.harbour.countries.service.FoodService;

import java.util.List;

public class DataTaskFood extends Task<List<Food>> {

    public DataTaskFood(){

    }


    @Override
    protected List<Food> call() throws Exception {
        FoodService foodService= new FoodService();
            System.out.println("FoodService call lanzado");

            //return JSONtoFoodList.getFoodList(foodService.getFoodCategory("pizza"));
            return foodService.getFoodCategory("pizza");

    }



}
