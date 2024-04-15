package org.example.h2.concreteClass;

import org.example.h2.ShippingStrategy;

public class FreeShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(double weight) {
        if( weight < 1 ){
            return 0;
        }
        return 9999.99;
    }
}
