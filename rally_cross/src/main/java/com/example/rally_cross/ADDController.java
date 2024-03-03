package com.example.rally_cross;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.jar.Attributes;

import static com.example.rally_cross.main.DriverDetails;

public class ADDController {
    private Stage stage;
    private Scene scene;
    private Parent root;

   // fxml input fields
    @FXML
    private TextField name;
    @FXML
    private TextField age;

    @FXML
    private TextField team;
    @FXML
    private TextField car;
    @FXML
    private TextField currentPoints;

    @FXML
    public void addOnClick(ActionEvent event) throws IOException {   // getting user inputs in the gui to variables
        String Name = name.getText().toUpperCase();
        String Age = age.getText();
        String Team = team.getText().toUpperCase();
        String Car = car.getText().toUpperCase();
        String CurrentP = currentPoints.getText();
        if (!addValidation(Name, Age, Team, Car, CurrentP)) {
            return;
        }
        driverD Details = new driverD(Name, Integer.parseInt(Age), Team, Car, Integer.parseInt(currentPoints.getText()));
        DriverDetails.add(Details);     // writing the validated details  array
        name.clear();  // clearing the text fields in javafx text fields
        age.clear();
        team.clear();
        car.clear();
        currentPoints.clear();

    }
    // validations
    @FXML
    public boolean addValidation(String NameIn, String AgeIn, String TeamIn, String CarIn, String PointIn) {

        if (NameIn.equals("")){                // checking whether the  name is  empty
            System.out.println("Name cannot be empty");
            return false;
        }
        if (AgeIn.equals("")) {                 // checking whether the  age is  empty
            System.out.println("Age cannot  be empty");
            return false;
        }
        if (TeamIn.equals("")) {                 // checking whether the  team is  empty
            System.out.println("Enter a team");
            return false;
        }
        if (CarIn.equals("")) {                   // checking whether the car  is  empty
            System.out.println("Enter a car");
            return false;
        }
        if (PointIn.equals("")) {           // checking whether the  current points  is  empty
            System.out.println("Enter current point");
            return false;
        }
        for (driverD driverDetail : DriverDetails) {   //  // checking whether the  name is  already exists
            if (NameIn.equals(driverDetail.name)) {
                System.out.println("Driver exists. Enter another name or choose update option.");
                return false;
            }
        }

        try {                   // checking whether the  age is an integer
            Integer.parseInt(AgeIn);
        }catch (NumberFormatException e){
            System.out.println("Enter numbers only");
            return false;
        }

        try {                  // checking whether the current point is an integer
            Integer.parseInt(PointIn);
        }catch (NumberFormatException e){
            System.out.println("Current points can be  numbers only");
            return false;
        }
        System.out.println("Driver details added successfully ");


        return true;
    }

    public void navigatorBack(ActionEvent actionEvent) throws IOException {   // going back to the console

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("console.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

}
