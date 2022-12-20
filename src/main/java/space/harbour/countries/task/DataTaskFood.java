package space.harbour.countries.task;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventType;
import space.harbour.countries.domain.Food;
import space.harbour.countries.service.FoodService;

import java.util.List;

public class DataTaskFood extends Task<List<Food>> {

    public DataTaskFood(){
    }


    public void addEventHandker(EventType<WorkerStateEvent> workerStateSucceeded, Object o) {
    }

    @Override
    protected List<Food> call() throws Exception {
        FoodService foodService= new FoodService();

            return foodService.getAllFood();

    }


}
