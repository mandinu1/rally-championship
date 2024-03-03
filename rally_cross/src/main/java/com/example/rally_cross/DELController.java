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
import java.util.ResourceBundle;

import static com.example.rally_cross.main.DriverDetails;

public class DELController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //table view
    @FXML
    private TableView<driverD> tableView;
    @FXML
    public TableColumn<driverD, String> name;
    @FXML
    public TableColumn<driverD, Integer> age;
    @FXML
    public TableColumn<driverD, String> team;
    @FXML
    public TableColumn<driverD, String> car;

    @FXML
    private TableColumn<driverD, Integer> currentpoints;


    public void initialize(URL url, ResourceBundle resourceBundle) {



        ObservableList<driverD> DriverObserver = FXCollections.observableArrayList(DriverDetails);// writing the array list to an observable list
        name.setCellValueFactory(new PropertyValueFactory<>("name")); // displaying the driver details in a table
        age.setCellValueFactory(new PropertyValueFactory<>("age"));  //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        team.setCellValueFactory(new PropertyValueFactory<>("team"));
        car.setCellValueFactory(new PropertyValueFactory<>("car"));
        currentpoints.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));
        tableView.setItems(DriverObserver);


    }
    public void removeCustomer(ActionEvent actionEvent)throws IOException {  // selecting the driver from the table and deleting
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
        DriverDetails.remove(selectedID);
    }

    public void navigatorBack(ActionEvent actionEvent) throws IOException { // back button

        Parent root = FXMLLoader.load(getClass().getResource("console.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }


}


