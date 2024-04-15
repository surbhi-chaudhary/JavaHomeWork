package org.example.h1.payable.subclass;

import org.example.h1.payable.Payable;

public class Contractor implements Payable {

    private final String name;
    private final Double hourlyRate;

    public Contractor(String name, Double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        //payment for 40 hours
        double payment = hourlyRate * 40.0;
        return payment;
    }
}
