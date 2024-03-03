package com.example.rally_cross;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.rally_cross.main.DriverDetails;
import static com.example.rally_cross.main.raceDetails;

public class datesController implements Initializable {  // displaying race details sorted according date at the initialized
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<raceD> tableView;
    @FXML
    private TableColumn<raceD, LocalDate> date;
    @FXML
    private TableColumn<raceD, String> location;
    @FXML
    private TableColumn<raceD, String> place1;
    @FXML
    private TableColumn<raceD, String> place2;
    @FXML
    private TableColumn<raceD, String> place3;


    @FXML @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int a = 0; a < raceDetails.size(); a++){
            for (int x = 0; x < raceDetails.size() - 1; x++) {

                if (raceDetails.get(x).getDate().compareTo(raceDetails.get(x + 1).getDate()) > 0) {  //bubble sort to date
                    raceD newDate = raceDetails.get(x);
                    raceDetails.set(x, raceDetails.get(x + 1));
                    raceDetails.set(x + 1, newDate);
                }

            }
        }

        ObservableList<raceD>  race = FXCollections.observableArrayList(raceDetails);
        date.setCellValueFactory(new PropertyValueFactory<raceD,LocalDate>("date")); // displaying in table
        location.setCellValueFactory(new PropertyValueFactory<raceD,String>("location"));
        place1.setCellValueFactory(new PropertyValueFactory<raceD,String>("position1"));
        place2.setCellValueFactory(new PropertyValueFactory<raceD,String>("position2"));
        place3.setCellValueFactory(new PropertyValueFactory<raceD,String>("position3"));
        tableView.setItems(race);
     }

    public void navigatorBack(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("console.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
