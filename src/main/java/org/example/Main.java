package org.example;

import org.example.h4.numberPredicate.NumberFilter;
import org.example.h4.numberPredicate.NumberPredicate;
import org.example.h4.numberPredicate.NumberStatistics;
import org.example.h4.stringOperation.StringOperation;
import org.example.h4.stringOperation.StringProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringOperation rev = inp -> {
            StringBuilder ans = new StringBuilder(inp);
            ans.reverse();
            return String.valueOf(ans);
        };

        StringOperation upper = inp -> inp.toUpperCase();

        StringOperation white = inp ->  inp.replace(" ","");

        StringProcessor stringProcessor = new StringProcessor();
        System.out.println(rev.operate("Surbhi"));
        System.out.println("via string processor " + stringProcessor.processString("Surbhi", rev));

        System.out.println(upper.operate("surbhi"));
        System.out.println("via string processor " + stringProcessor.processString("surbhi", upper));

        System.out.println(white.operate("S U R B H I"));
        System.out.println("via string processor " + stringProcessor.processString("S U R B H I ", white));

//////////////////////////////////////////////////////////////////////////////////////////

//        NumberPredicate prime = x -> {
//            if( x < 2 ){
//                return false;
//            }
//            int r = x/2;
//            for (int  i = 2 ; i<= r ; i++){
//                if (x%i == 0 ){
//                    return false;
//                }
//            }
//            return true;
//        };
//
//        NumberPredicate square = x -> {
//            int sqrt = (int)Math.sqrt(x);
//            return ( (sqrt*sqrt) == x );
//        };
//
//        NumberPredicate fibo = x -> {
//            if(( x >= 0) && (x <= 3) ){
//                return true;
//            }
//            int a = 5, b = 8;
//            while( a <= x ){
//                int c = a + b;
//                if( (x == a) || (x == b) || (x == c) ){
//                    return true;
//                }
//                a = b;
//                b = c;
//            }
//            return false;
//        };
//
//        List<Integer> list = List.of(11,22,37,49,89);
//
//        NumberFilter numberFilter = new NumberFilter();
//        System.out.println("Is Prime: " + prime.test(10) );
//        System.out.println( "via numberFilter " + numberFilter.filterNumbers(list, prime) );
//
//        System.out.println("Is square: " + square.test(10) );
//        System.out.println( "via numberFilter " + numberFilter.filterNumbers(list, square) );
//
//        System.out.println("Is fibonacci: " + fibo.test(10) );
//        System.out.println( "via numberFilter " + numberFilter.filterNumbers(list, fibo) );
//
//        NumberStatistics numberStatistics = new NumberStatistics();
//
//        System.out.println("Sum is: " + numberStatistics.sum(list));
//        System.out.println("Average is: " + numberStatistics.avg(list));
//        System.out.println("Min is: " + numberStatistics.min(list));
//        System.out.println("Max is: " + numberStatistics.max(list));
//


//////////////////////////////////////////////////////////////////////////////////////////

//        Circle circle = new Circle(7);
//        Rectangle rectangle = new Rectangle(4, 7);
//
//        System.out.println( circle.getArea() );
//        System.out.println( circle.getPerimeter() );
//        System.out.println( rectangle.getArea() );
//        System.out.println( rectangle.getPerimeter() );

//////////////////////////////////////////////////////////////////////////////////////////

//        Cat cat = new Cat();
//        cat.makeSound();
//        cat.eat();
//
//        Dog dog = new Dog();
//        dog.makeSound();
//        dog.eat();
//
//        Employee employee = new Employee("Mike", 50000.0 );
//        Contractor contractor = new Contractor("Harvey", 10000.0 );
//
//        System.out.println(employee.getPaymentAmount());
//        System.out.println(contractor.getPaymentAmount());

//////////////////////////////////////////////////////////////////////////////////////////

//        Car2 car2 = new Car2();
//        MotorCycle motorCycle = new MotorCycle();
//
//        car2.startEngine();
//        car2.stopEngine();
//        car2.accelerate();
//        car2.brake();
//
//        motorCycle.startEngine();
//        motorCycle.stopEngine();
//        motorCycle.accelerate();
//        motorCycle.brake();
/////////////////////////////////////////////////////////////////////////////////////////

//        StandardShipping standardShipping = new StandardShipping();
//        PriorityShipping priorityShipping = new PriorityShipping();
//        ExpressShipping expressShipping = new ExpressShipping();
//        FreeShipping freeShipping = new FreeShipping();
//
//        ShippingCalculator standard = new ShippingCalculator(standardShipping);
//        ShippingCalculator priority = new ShippingCalculator(priorityShipping);
//        ShippingCalculator express = new ShippingCalculator(expressShipping);
//        ShippingCalculator free = new ShippingCalculator(freeShipping);
//
//        double weight = 10;
//
//        System.out.println("Shipping cost for standard shipping is: " + standard.calculateShippingCost(2.5));
//        System.out.println("Shipping cost for priority shipping is: " + priority.calculateShippingCost(7.8));
//        System.out.println("Shipping cost for express shipping is: " + express.calculateShippingCost(5.0));
//        System.out.println("Shipping cost for free shipping is: " + free.calculateShippingCost(weight));

        //////////////////////////////////////////////////////////////
    }
}