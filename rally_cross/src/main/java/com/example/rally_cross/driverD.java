package com.example.rally_cross;

import java.io.*;

public class driverD implements Serializable {
    String name, car, team;
    int age, currentPoints;

    public driverD(String name, int age, String team, String car, int currentPoints) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.car = car;
        this.currentPoints = currentPoints;

    }

    public String getName() {
        return name;
    }  //retrieving  data

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public String getCar() {
        return car;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setAge(int ageNew) {
        this.age = ageNew;
    } // updating details

    public void setCPoints(int cPointsNew) {
        this.currentPoints = cPointsNew;
    }

    public void setName(String nameNew) {
        this.name = nameNew;
    }

    public void setCar(String carNew) {
        this.car = carNew;
    }

    public void setTeam(String teamNew) {
        this.name = teamNew;
    }

}