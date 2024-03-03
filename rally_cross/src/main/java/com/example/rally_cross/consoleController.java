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
import javafx.stage.Stage;

import java.io.*;
import java.nio.channels.Pipe;
import java.util.ArrayList;

import static com.example.rally_cross.main.DriverDetails;
import static com.example.rally_cross.main.raceDetails;


public class consoleController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void navigatorAdd(ActionEvent actionEvent) throws IOException {   // button to add details

        Parent root = FXMLLoader.load(getClass().getResource("ADD.fxml"));    // linking front page and the adding details page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void navigatorDelete(ActionEvent actionEvent) throws IOException {         // button to delete details

        Parent root = FXMLLoader.load(getClass().getResource("DEL.fxml"));     // linking front page and the deleting details page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

    }

    public void navigatorUpdate(ActionEvent actionEvent) throws IOException { // button to update details

        Parent root = FXMLLoader.load(getClass().getResource("UPD.fxml"));   // linking front page and the update details page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void standingTable(ActionEvent actionEvent) throws IOException { // button to view the standing table

        Parent root = FXMLLoader.load(getClass().getResource("StandingTable.fxml"));    // linking front page and the standing table page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void simulateRace(ActionEvent actionEvent) throws IOException { // button to simulating race page

        Parent root = FXMLLoader.load(getClass().getResource("simulate.fxml"));    // linking front page and the simulating race page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void viewdate(ActionEvent actionEvent) throws IOException { // button to view  race details

        Parent root = FXMLLoader.load(getClass().getResource("dates.fxml")); // linking front page and the  view race details page
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

    }


    public void save(ActionEvent actionEvent) throws Exception { // button to  write details  to text file
        try {
            FileWriter file = new FileWriter("Drivers.txt");
            FileWriter race=  new FileWriter("raceDetail.txt");
            for (int i = 0; i < DriverDetails.size(); i++) {
                file.write(DriverDetails.get(i).name + " " + DriverDetails.get(i).age + " "
                        + DriverDetails.get(i).team + " " + DriverDetails.get(i).car + " " + DriverDetails.get(i).currentPoints);
                file.write("\n");
            }
            for (int x= 0;x<raceDetails.size();x++){
                race.write(raceDetails.get(x).date+" "+raceDetails.get(x).location+" "+raceDetails.get(x).position1+
                        " "+raceDetails.get(x).position2+" "+raceDetails.get(x).position3);
                race.write("\n");
            }
            file.close();
            race.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }
        public void reload (ActionEvent actionEvent) throws Exception { // button to read  details  to enable resume capabilities
        DriverDetails.clear();
        raceDetails.clear();
        try {
            FileReader fileReader =  new FileReader("Drivers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileReader raceReader =  new FileReader("raceDetail.txt");
            BufferedReader bufferedDate = new BufferedReader(raceReader);

            String savedDrivers= bufferedReader.readLine();
            String SavedRace = bufferedDate.readLine();
            while (savedDrivers!=null){
                String[] driver = savedDrivers.split(" ");
                String name = driver[0];
                int age = Integer.parseInt(driver[1]);
                String team = driver[2];
                String car = driver[3];
                int cPoints = Integer.parseInt(driver[4]);
                driverD savedDriver = new driverD(name,age,team,car,cPoints);
                DriverDetails.add(savedDriver);
                savedDrivers = bufferedReader.readLine();
                }
            fileReader.close();
            while (SavedRace != null){
                String[]raceDate = SavedRace.split(" ");
                String date = raceDate[0];
                String location = raceDate[1];
                String position1 = raceDate[2];
                String position2= raceDate[3];
                String position3 = raceDate[4];
                raceD savedDate = new raceD(date,location,position1,position2,position3);
                raceDetails.add(savedDate);
                SavedRace = bufferedDate.readLine();

            }




        }catch (IOException e){
            e.printStackTrace();
        }

        }

    public void exist (ActionEvent actionEvent) throws IOException { // button to exist the program
       System.exit(0);

    }
    }
