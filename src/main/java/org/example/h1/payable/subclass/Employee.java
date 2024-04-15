package org.example.h1.payable.subclass;

import org.example.h1.payable.Payable;

public class Employee implements Payable {

    private final String name;
    private final Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getPaymentAmount() {
        return salary;
    }
}
