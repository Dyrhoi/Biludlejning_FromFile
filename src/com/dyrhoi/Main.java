package com.dyrhoi;

import com.dyrhoi.filehandler.FileHandler;
import com.dyrhoi.model.Garage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Garage garage1 = new Garage();
        String filename = "cars.csv";
        try {
            FileHandler.importCarsToFile(filename, garage1);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + filename);
        }

        System.out.println(garage1.getGarage().size() + " cars added.");
        System.out.println(garage1);

        String exportFilename = "carsExported.csv";
        try {
            //Filters: none, make <make>, horsepower <identifier> <value>, milerperhour <identifier> <value>.
            FileHandler.exportCarsToFile(exportFilename, garage1, new String[] {"none"});
        } catch (IOException e) {
            System.out.println("Error writing to file: " + exportFilename);
        }
    }
}
