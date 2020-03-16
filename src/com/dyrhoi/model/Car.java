package com.dyrhoi.model;

public class Car {
    private static int autoIncrementId = 0;

    private String make;
    private String model;
    private double horsePower;
    private double milesPerGallon;
    private int doors;
    private int id;

    public Car(String make, String model, double horsePower, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.milesPerGallon = milesPerGallon;
        this.id = autoIncrementId;
        autoIncrementId++;
    }

    public Car(int id, String make, String model, double horsePower, double milesPerGallon) {
        this(make, model, horsePower, milesPerGallon);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(double milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", milesPerGallon=" + milesPerGallon +
                ", id=" + id +
                '}';
    }

    public String toCSV() {
        return id + ";" + make + ";" + model + ";" + doors + ";" + horsePower + ";" + milesPerGallon;
    }

}
