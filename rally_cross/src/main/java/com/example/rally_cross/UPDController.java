package com.example.rally_cross;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.rally_cross.main.DriverDetails;

public class UPDController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<driverD> updateDriverOld = new ArrayList<>();
    // java fx text fields
    @FXML
    private TextField Seached;
    @FXML
    private TextField nameOld;
    @FXML
    private TextField ageOld;
    @FXML
    private TextField teamOld;
    @FXML
    private TextField carOld;
    @FXML
    private TextField cpointsOld;
    @FXML
    private TextField newData;



    public void navigatorBack(ActionEvent actionEvent) throws IOException {  // going back to console

        Parent root = FXMLLoader.load(getClass().getResource("console.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root ,600,400);
        stage.setScene(scene);
        stage.show();
    }
    public void search (ActionEvent actionEvent)throws IOException{
        boolean searchedName = false;

        String updateName = Seached.getText().toUpperCase(); // getting the name that need to be updated from the user and search it in the array
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                updateDriverOld.add(DriverDetails.get(i));
               searchedName = true;
               display();                                  // displaying the old data of the driver if the name in available

            }
        }

    }
    public void display()throws IOException{              // displaying  driver details
        for (driverD driver : updateDriverOld) {
            // Appending the string representation of each driver object to the text property of the TextField
            nameOld.appendText(driver.getName().toString() + "\n");
            ageOld.appendText(Integer.toString(driver.getAge()) + "\n");
            teamOld.appendText(driver.team.toString() + "\n");
            carOld.appendText(driver.car.toString() + "\n");
            cpointsOld.appendText(Integer.toString(driver.currentPoints) + "\n");

        }
    }
    public void updateName (ActionEvent actionEvent) throws IOException{     // updating name
        String newName = newData.getText().toUpperCase();
        String updateName = Seached.getText().toUpperCase();
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                DriverDetails.get(i).setName(newName);
                    }
        }
        nameOld.clear();
        ageOld.clear();
        teamOld.clear();
        carOld.clear();
        cpointsOld.clear();
        newData.clear();
    }
    public void updateAge (ActionEvent actionEvent) throws IOException{   //updating age
        String newAge = newData.getText().toUpperCase();String updateName = Seached.getText().toUpperCase();
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                DriverDetails.get(i).setAge(Integer.parseInt(newAge));
            }
        }
        nameOld.clear();
        ageOld.clear();
        teamOld.clear();
        carOld.clear();
        cpointsOld.clear();
        newData.clear();
    }
    public void updateCar (ActionEvent actionEvent) throws IOException{  //updating car
        String newCar = newData.getText().toUpperCase();String updateName = Seached.getText().toUpperCase();
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                DriverDetails.get(i).setCar(newCar);
            }
        }nameOld.clear();
        ageOld.clear();
        teamOld.clear();
        carOld.clear();
        cpointsOld.clear();
        newData.clear();
    }
    public void updateTeam (ActionEvent actionEvent) throws IOException{   //updating team
        String newTeam = newData.getText().toUpperCase();String updateName = Seached.getText().toUpperCase();
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                DriverDetails.get(i).setTeam(newTeam);
            }
        }nameOld.clear();
        ageOld.clear();
        teamOld.clear();
        carOld.clear();
        cpointsOld.clear();
        newData.clear();
    }
    public void updateCurrentPoints (ActionEvent actionEvent) throws IOException{  //updating current points
        String newPoints = newData.getText().toUpperCase();
        String updateName = Seached.getText().toUpperCase();
        if(!UpdateValidation(updateName)){
            return;
        }
        for (int i =0 ; i<DriverDetails.size();i++) {
            if (updateName.equals(DriverDetails.get(i).name)){
                DriverDetails.get(i).setCPoints(Integer.parseInt(newPoints));
            }
        }nameOld.clear();
        ageOld.clear();
        teamOld.clear();
        carOld.clear();
        cpointsOld.clear();
        newData.clear();
    }
    public boolean UpdateValidation(String Name){       // validations
        for (driverD driverDetail : DriverDetails) {
            if (!Name.equals(driverDetail.name)) {
                System.out.println("Driver doesn't exists. Enter another name or choose ADD option.");
                return false;
            }
        }
        return true;
    }
}
