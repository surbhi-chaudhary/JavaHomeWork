package org.example.h2;

public class ShippingCalculator {
    private final ShippingStrategy shippingStrategy;

    public ShippingCalculator(ShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }

    public double calculateShippingCost(double weight){
        return shippingStrategy.calculateShippingCost(weight);
    }
}
