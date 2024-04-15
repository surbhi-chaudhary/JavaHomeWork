package org.example.h2.concreteClass;

import org.example.h2.ShippingStrategy;

public class StandardShipping implements ShippingStrategy {

    @Override
    public double calculateShippingCost(double weight) {
        return (50.0 + ( 10 * weight ));
    }
}

