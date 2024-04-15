package org.example.h2.concreteClass;

import org.example.h2.ShippingStrategy;

public class PriorityShipping implements ShippingStrategy {

    @Override
    public double calculateShippingCost(double weight) {
        return ( 150.0 + ( 30 * weight ) ) ;
    }
}
