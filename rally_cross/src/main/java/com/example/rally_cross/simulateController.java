package com.example.rally_cross;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.*;

import static com.example.rally_cross.main.DriverDetails;
import static com.example.rally_cross.main.raceDetails;


public class simulateController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML   // linking the table in java fx with id
    private DatePicker date;
    @FXML
    private TextField locations;
    @FXML
    private TableView<driverD> tableView;
    @FXML
    private TableColumn<driverD, String> position;
    @FXML
    private TableColumn<driverD, Integer> points ;
    public void navigatorBack(ActionEvent actionEvent) throws IOException { //back button

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("console.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void simulate(ActionEvent actionEvent)throws IOException{

         String raceDate = date.getValue().format(DateTimeFormatter.ofPattern("yyy-MM-dd"));        //https://stackoverflow.com/questions/33789307/how-to-convert-datepicker-value-to-string
         String[]  location = {"Nyirad","Holjes","Montalegre","Barcelona","Riga","Norway"};
        Random rand = new Random();
        int index = rand.nextInt(location.length); // generates a random index from 0 to
        String randLocation = location[index];
        locations.setText(randLocation );
        Collections.shuffle(DriverDetails); // giving positions to drivers
        for (int l =0;l<DriverDetails.size();l++){ // updating  the current points
            if (l==0){DriverDetails.get(l).setCPoints(DriverDetails.get(0).currentPoints+10);
            }
            if (l == 1){
                DriverDetails.get(l).setCPoints(DriverDetails.get(l).currentPoints+7);
            }
            if (l == 2){
                DriverDetails.get(l).setCPoints(DriverDetails.get(l).currentPoints+5);
            }
        }

            raceD race = new raceD(raceDate,randLocation,DriverDetails.get(0).name,DriverDetails.get(1).name,DriverDetails.get(2).name);
            raceDetails.add(race);



        Display();
    }
    public void Display (){ // display the name and current points of drivers according to position
        ObservableList<driverD> raceObserver = FXCollections.observableArrayList(DriverDetails);
        position.setCellValueFactory(new PropertyValueFactory<>("name"));
        points.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));
        tableView.setItems(raceObserver);
    }
}

