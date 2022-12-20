package space.harbour.countries.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


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
        prepareTableView();
        loadDataFood(); //Crear clase para leer los datos de comida
    }

    private void loadDataFood(){
        progressBar.setVisible(true);


    }
}
