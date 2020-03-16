package com.dyrhoi.filehandler;

import com.dyrhoi.model.Car;
import com.dyrhoi.model.Garage;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static void importCarsToFile(String filename, Garage garage) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));

        String line;
        int counter = 0;
        int carsAdded = 0;
        while(in.hasNextLine()) {
            line = in.nextLine();
            String[] carData = line.split(";");
            try {
                //Make;Model;Horsepower;MPG_City
                Car car = new Car(carData[0], carData[1], Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
                if(carData[1].matches("(?s).*\\b\\ddr")) {
                    String carModel = carData[1].replaceAll("\\s\\b\\ddr", "");
                    car.setModel(carModel);

                    String carDoors = carData[1].replaceAll(carModel, "");
                    carDoors = carDoors.replaceAll("\\D", "");
                    car.setDoors(Integer.parseInt(carDoors));
                }
                garage.addCar(car);
                carsAdded++;
            } catch (Exception e) {
                System.out.println("Error in adding car on line: " + (counter + 1));
            }
            counter++;
        }
    }

    public static void exportCarsToFile(String filename, Garage garage, String[] filter) throws IOException {
        File file = new File(filename);
        if(file.createNewFile()) {
            System.out.println("Generated new file: " + file.toString());
        }
        else {
            System.out.println("Found existing file: " + file.toString());
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            Garage tempGarage = new Garage();
            String filterType = filter[0];
            if(filterType.equalsIgnoreCase("make")) {
                String make = filter[1];
                tempGarage.addCars(garage.getCarsByMake(make));
            }
            else if(filterType.equalsIgnoreCase("milesperhour")) {
                String identifier = filter[1];
                double value = Double.parseDouble(filter[2]);
                tempGarage.addCars(garage.getCarsByMilesPerGallon(identifier, value));
            }
            else if(filterType.equalsIgnoreCase("horsepower")) {
                String identifier = filter[1];
                double value = Double.parseDouble(filter[2]);
                tempGarage.addCars(garage.getCarsByHorsepower(identifier, value));
            }
            else {
                tempGarage.addCars(garage.getGarage());
            }

            StringBuilder sb = new StringBuilder();
            for(Car car : tempGarage.getGarage()) {
                sb.append(car.toCSV()).append("\n");
            }

            bw.write(sb.toString());
        }
    }

}
