package com.example.rally_cross;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main extends Application {
    static ArrayList<driverD> DriverDetails = new ArrayList<>(); // array list to save  drivers
    static ArrayList<raceD> raceDetails = new ArrayList<>(); // array list to save race details

    @Override
    public void start(Stage stage) throws IOException {
       // load();
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("console.fxml"));  // linking console fxml
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch();

    }
//       public void load (){
//           try {
//               FileReader fileReader =  new FileReader("Drivers.txt");   // reading from the text file when the program starts
//               BufferedReader bufferedReader = new BufferedReader(fileReader);
//               FileReader raceReader =  new FileReader("raceDetail.txt");
//               BufferedReader bufferedDate = new BufferedReader(raceReader);
//
//               String savedDrivers= bufferedReader.readLine();
//               String SavedRace = bufferedDate.readLine();
//               while (savedDrivers!=null){
//                   String[] driver = savedDrivers.split(" ");
//                   String name = driver[0];
//                   int age = Integer.parseInt(driver[1]);
//                   String team = driver[2];
//                   String car = driver[3];
//                   int cPoints = Integer.parseInt(driver[4]);
//                   driverD savedDriver = new driverD(name,age,team,car,cPoints);
//                   DriverDetails.add(savedDriver);       // adding the details saved in the text file to array
//                   savedDrivers = bufferedReader.readLine();
//               }
//               fileReader.close();
//               while (SavedRace != null){
//                   String[]raceDate = SavedRace.split(" ");
//                   String date = raceDate[0];
//                   String location = raceDate[1];
//                   String position1 = raceDate[2];
//                   String position2= raceDate[3];
//                   String position3 = raceDate[4];
//                   raceD savedDate = new raceD(date,location,position1,position2,position3);
//                   raceDetails.add(savedDate);         // adding the  race details saved in the text file to array
//                   SavedRace = bufferedDate.readLine();
//
//               }
//
//
//
//
//           }catch (IOException e){
//               e.printStackTrace();
//           }
//       }
//    }
}