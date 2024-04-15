package org.example.h4.functionalInterface;

import java.util.function.Consumer;

public class ConsumerHW {
    public static void greeting(String inp, Consumer<String> consumer){
        consumer.accept(inp);
    }

    public static void modify(Double num, Consumer<Double> consumer){
        consumer.accept(num);
    }

    public static void main(String[] args) {
        Consumer<String> greet = inp -> { System.out.println("Hello " + inp + ", Good morning.");};
        Consumer<String> ask = inp -> { System.out.println("What are you currently working on " + inp + "?");};

        Consumer<Double> mul = b ->{
            System.out.println("Initial balance is: " + b );
            b *= 2;
            System.out.println("Final balance after multiplying is: " + b);
        };

        Consumer<Double> half = b ->{
            System.out.println("Initial balance is: " + b );
            b /= 2;
            System.out.println("Final balance after halving is: " + b);
        };

        greeting("Surbhi", greet);
//        greet.accept("Surbhi");

        greeting("Siri", ask);
      //  ask.accept("Siri");

        modify(100.0, mul);
        modify(150.0, half);

    }
}
