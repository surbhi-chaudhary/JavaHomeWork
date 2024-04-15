package org.example.h2.concreteClass;

import org.example.h2.ShippingStrategy;

public class ExpressShipping implements ShippingStrategy {
    public void ShippingStrategy(){
        System.out.println("Express");
    }
    @Override
    public double calculateShippingCost(double weight) {
        return (100.0 + ( 20*weight ));
    }
}

