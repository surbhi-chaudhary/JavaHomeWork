package org.example.h1.shape.subclass;

import org.example.h1.shape.Shape;

public class Rectangle implements Shape {
    private final double length;
    private final double width;

    @Override
    public double getArea() {
        return ( length * width );
    }

    @Override
    public double getPerimeter() {
        return ( 2 * ( length + width ) );
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}
