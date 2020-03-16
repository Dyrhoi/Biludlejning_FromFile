package com.dyrhoi.model;

import java.util.ArrayList;

public class Garage {
    private static int autoIncrementId = 0;

    private ArrayList<Car> garage;
    private int id;
    public Garage() {
        this.garage = new ArrayList<>();
        this.id = autoIncrementId;
        autoIncrementId++;
    }

    public ArrayList<Car> getGarage() {
        return garage;
    }

    public void addCar(Car car) {
        garage.add(car);
    }

    public void addCars(ArrayList<Car> cars) {
        garage.addAll(cars);
    }

    public void removeCar(Car car) {
        garage.remove(car);
    }

    public void removeCar(int id) {
        garage.remove(getCarById(id));
    }

    public int getId() {
        return id;
    }

    public Car getCarById(int id) {
        for(Car car : garage) {
            if(car.getId() == id) return car;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Car car : garage) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Car> getCarsByMake(String make) {
        ArrayList<Car> cars = new ArrayList<>();
        for(Car car : garage) {
            if(car.getMake().equalsIgnoreCase(make)) cars.add(car);
        }
        return cars;
    }

    public ArrayList<Car> getCarsByMilesPerGallon(String identifier, double value) {
        ArrayList<Car> cars = new ArrayList<>();
        if(identifier.equalsIgnoreCase(">")) {
            for (Car car : garage) {
                if (car.getMilesPerGallon() > value) cars.add(car);
            }
        }
        else if(identifier.equalsIgnoreCase("==")) {
            for (Car car : garage) {
                if (car.getMilesPerGallon() == value) cars.add(car);
            }
        }
        else if(identifier.equalsIgnoreCase("<")) {
            for (Car car : garage) {
                if (car.getMilesPerGallon() < value) cars.add(car);
            }
        }
        return cars;
    }

    public ArrayList<Car> getCarsByHorsepower(String identifier, double value) {
        ArrayList<Car> cars = new ArrayList<>();
        if(identifier.equalsIgnoreCase(">")) {
            for (Car car : garage) {
                if (car.getHorsePower() > value) cars.add(car);
            }
        }
        else if(identifier.equalsIgnoreCase("==")) {
            for (Car car : garage) {
                if (car.getHorsePower() == value) cars.add(car);
            }
        }
        else if(identifier.equalsIgnoreCase("<")) {
            for (Car car : garage) {
                if (car.getHorsePower() < value) cars.add(car);
            }
        }
        return cars;
    }
}
