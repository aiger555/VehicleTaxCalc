package com.example.vehicletaxcalculator;

public class Bus extends Vehicle {

    public Bus(int engineCapacity, int manufactureYear){
        super(engineCapacity, manufactureYear, VehicleType.BUS);
    }


    @Override
    public double calculateTax() {
        int yearMultiplier;
        if (getManufactureYear() <= 5) {
            yearMultiplier = 5;
        } else if (getManufactureYear() <= 10) {
            yearMultiplier = 4;
        } else if (getManufactureYear() <= 15) {
            yearMultiplier = 2;
        } else {
            yearMultiplier = 1;
        }
//        230104025, Aigerim, Nuralieva
        return 15 * getEngineCapacity() * yearMultiplier;
    }

}
