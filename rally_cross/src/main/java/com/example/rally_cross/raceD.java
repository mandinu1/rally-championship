package com.example.rally_cross;

import java.io.Serializable;
import java.time.LocalDate;

public class raceD implements Serializable {
    final String date, location,position1,position2,position3 ;


   public raceD(String date,String location, String position1, String position2, String position3){
       this.date = date;
       this.location= location;
       this.position1= position1;
       this.position2 = position2;
       this.position3=position3;

   }
    public String getDate(){
        return date;
    }
    public String getLocation(){
        return location;
    }
    public String getPosition1(){
        return position1;
    }
    public String getPosition2(){
        return position2;
    }
    public String getPosition3(){
        return position3;
    }

}
