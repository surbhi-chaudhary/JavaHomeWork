package org.example.h1.vehicle.subclass;

import org.example.h1.vehicle.Drivable;
import org.example.h1.vehicle.Vehicle;

public class MotorCycle extends Vehicle implements Drivable {
    @Override
    public void startEngine() {
        System.out.println("MotorCycle engine is started");
    }

    @Override
    public void accelerate() {
        System.out.println("MotorCycle is accelerated");
    }

    @Override
    public void brake() {
        System.out.println("Applying MotorCycle's brake.");
    }

    public void putOnHelmet(){
        System.out.println("Can you put on helmet.");
    }
}
