package org.example.h4.functionalInterface.functionHW;

import java.util.function.Function;

public class FunctionHW {

    public static double convert1( Double d, Function<Double, Double> func){
        return func.apply(d);
    };

    public static Person convert2(String inp, Function<String, Person> func ){
        return func.apply(inp);
    };

    public static void main(String args[]){
        Function<Double, Double> miles = d -> ( 1.6*d);
        Function<Double, Double> mtr = d -> ( d/1000.0);

        Function<String, Person> per = x -> ( new Person(x) );

        System.out.println("Converting the given distance 12Km to mile: " + convert1(12.0, miles));
        System.out.println("Converting the given distance 12Km to meters: " + convert1(12.0, mtr));

        Person result = convert2("Siri", per);
        System.out.println(result.name);
    }

}
