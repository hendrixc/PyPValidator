/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator;

import com.hendrixc.pypvalidator.utils.DataValidator;
import com.hendrixc.pypvalidator.utils.DataConverter;
import com.hendrixc.pypvalidator.conf.RestrictionConfigurator;
import com.hendrixc.pypvalidator.exeption.ValidationException;
import com.hendrixc.pypvalidator.model.Vehicle;
import com.hendrixc.pypvalidator.service.PredictorService;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Main class for Pico&Placa Predictor. 
 * @author Henry Coral
 */
public class Starter {
    
    private static final String MAIN = "Pico y Placa Predictor\n"
            + "======================\n"
            + "This program works with the original Pico y Placa restrictions\n"
            + "Date format: yyyy-mm-dd; Time format: hh:mm; Plate format: XXX[D]DDD\n"
            + "Samples: 2020-05-01; Time: 15:34; Plate: PCM382\n"
            + "To Exit, input exit";
    
    /**
     * Main method to execute the P&P Predictor, no arguments needed.
     * @param args Defined only as language restriction.
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        RestrictionConfigurator.config();
        DataValidator validator = new DataValidator();
        DataConverter converter = new DataConverter();
        Starter.print(MAIN);
        while (true) {
            try {
                Starter.print("Date (yyyy-mm-dd): ");
                String date = scan.nextLine();
                if ("exit".equalsIgnoreCase(date)) {
                    Starter.print("Good bye!");
                    System.exit(0);
                }
                validator.validateDate(date);
                Starter.print("Time (hh:mm): ");
                String time = scan.nextLine();
                validator.validateTime(time);
                Starter.print("Plate: ");
                String plate = scan.nextLine();
                validator.validatePlate(plate);
                Vehicle vehicle = new Vehicle();
                vehicle.setPlate(plate);
                LocalDateTime ldt = converter.convert(date, time);
                PredictorService ps = new PredictorService();
                Starter.print("Has Restriction:"+ps.predict(vehicle, ldt));
            } catch (ValidationException ex) {
                Starter.print(ex.getMessage());
            }
            
        }
                
    }
    
    /**
     * Printer utility method.
     * @param message Message to be printed.
     */
    private static void print(String message) {
        System.out.println(message);
    }
    
}
