package com.example.vehicletaxcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label resultLabel;

    @FXML
    private ChoiceBox<VehicleType> vehicleTypeChoice;

    @FXML
    private TextField engineCapacityField;

    @FXML
    private TextField manufactureYearField;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void calculateTax(ActionEvent event) {
        try {
            int engineCapacity = Integer.parseInt(engineCapacityField.getText());
            int manufactureYear = Integer.parseInt(manufactureYearField.getText());
            VehicleType vehicleType = vehicleTypeChoice.getValue();

            Vehicle vehicle;
            switch (vehicleType) {
                case CAR:
                    vehicle = new Car(engineCapacity, manufactureYear);
                    break;
                case BUS:
                    vehicle = new Bus(engineCapacity, manufactureYear);
                    break;
                case TRUCK:
                    vehicle = new Truck(engineCapacity, manufactureYear);
                    break;
                default:
                    vehicle = new Car(engineCapacity, manufactureYear);
            }

            double tax = vehicle.calculateTax();
            resultLabel.setText("Tax: " + String.format("%.2fsom", tax));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }
}
