package space.harbour.countries.controller;


import javafx.collections.FXCollections;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import space.harbour.countries.domain.Country;
import space.harbour.countries.domain.Food;
import space.harbour.countries.task.DataTaskFood;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class FoodController implements Initializable{

    public TextField nameCountry;
    public TextField regionCountry;
    public TextField subregionCountry;
    public TextField PopulationCountry;
    public TableView<Food> dataTableFood;
    public ProgressBar progressBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareText();
        prepareTableView();
        loadDataFood(); //Crear clase para leer los datos de comida

    }

    private void prepareText(Country c1) {
        String nameCountryText = nameCountry.getText();
        nameCountryText= c1.getName();
        String regionText= regionCountry.getText();
        regionText=c1.getRegion();
        String subregText = subregionCountry.getText();
        subregText=c1.getSubregion();
        String populationText= PopulationCountry.getText();
        populationText= String.valueOf(c1.getPopulation());

    }

    private void loadDataFood(){
        progressBar.setVisible(true);
        DataTaskFood dataTaskFood=new DataTaskFood();
        dataTaskFood.addEventHandker(WorkerStateEvent.WORKER_STATE_SUCCEEDED, workerStateEvent -> {
            progressBar.setVisible(false);
            List<Food> foodList= dataTaskFood.getValue();
            dataTableFood.setItems(FXCollections.observableArrayList(foodList));
        });
        new Thread(dataTaskFood).start();
    }

    private void prepareTableView(){
        TableColumn<Food, String> nameColumn = new TableColumn<>("Food Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dataTableFood.getColumns().add(nameColumn);
    }

    public void atrasApp(ActionEvent event){ //No va para atras directamente sale de la app
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == ButtonType.OK) {
                System.exit(0);
            }
        });
    }
}
