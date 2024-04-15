package org.example.h1.shape.subclass;

import org.example.h1.shape.Shape;

public class Circle implements Shape {

    private final double radius;
    @Override
    public double getArea() {
        return ( 3.14 * radius * radius );
    }

    @Override
    public double getPerimeter() {
        return ( 2 * 3.14 * radius);
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
