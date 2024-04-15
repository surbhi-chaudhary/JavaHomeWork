package org.example.h1.vehicle.subclass;

import org.example.h1.vehicle.Drivable;
import org.example.h1.vehicle.Vehicle;

public class Car2 extends Vehicle implements Drivable {
    @Override
    public void startEngine() {
        System.out.println("Car engine is started");
    }

    @Override
    public void accelerate() {
        System.out.println("Car is accelerated");
    }

    @Override
    public void brake() {
        System.out.println("Applying Car's brake.");
    }

    public void openDoors(){
        System.out.println("Can you open the door of car.");
    }
}
