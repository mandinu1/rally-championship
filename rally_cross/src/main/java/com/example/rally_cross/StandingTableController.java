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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.rally_cross.main.DriverDetails;

public class StandingTableController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //table view
    @FXML
    public TableView<driverD> tableView;
    @FXML
    public TableColumn<driverD, String> name;
    @FXML
    public TableColumn<driverD, Integer> age;
    @FXML
    public TableColumn<driverD, String> team;
    @FXML
    public TableColumn<driverD, String> car;

    @FXML
    public TableColumn<driverD, Integer> currentpoints;


    public void initialize(URL url, ResourceBundle resourceBundle) { // printing the driver details sorted according to current point in table at the initialing

        //  bubble sorting
        for (int s = 0;s<DriverDetails.size();s++) {
            for (int x = 0; x < DriverDetails.size() - 1; x++) {

                if (DriverDetails.get(x).getCurrentPoints() < DriverDetails.get(x + 1).getCurrentPoints()) {
                    driverD newDriver = DriverDetails.get(x);
                    DriverDetails.set(x, DriverDetails.get(x + 1));
                    DriverDetails.set(x + 1, newDriver);
                }

            }
        }
        ObservableList<driverD> DriverObserver = FXCollections.observableArrayList(DriverDetails);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));  //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        age.setCellValueFactory(new PropertyValueFactory<>("age"));    //https://jenkov.com/tutorials/javafx/tableview.html
        team.setCellValueFactory(new PropertyValueFactory<>("team"));
        car.setCellValueFactory(new PropertyValueFactory<>("car"));
        currentpoints.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));
        tableView.setItems(DriverObserver);
    }

    public void navigatorBack(ActionEvent actionEvent) throws IOException { //back button

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("console.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

}