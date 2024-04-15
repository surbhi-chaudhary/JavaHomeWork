package org.example.h4.functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionHW {

    static BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    static BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
    static BiFunction<Integer, Integer, Integer> multi = (a, b) -> a * b;
    static BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;
    static BiFunction<String, String, Integer> total = (a, b) -> a.length() + b.length();

    public static int arithmetic( int a, int b, BiFunction<Integer, Integer, Integer> operation ){
        return operation.apply(a,b);
    }

    public static int merger( String a, String b, BiFunction<String, String, Integer> operation ){
        return operation.apply(a,b);
    }

    public static void main( String args[] ){
        System.out.println("Addition result = " + arithmetic(2,3,add));
        System.out.println("Subtraction result = " + arithmetic(2,3,sub));
        System.out.println("Multiplication result = " + arithmetic(2,3,multi));
        System.out.println("Division result = " + arithmetic(2,3,divide));

        System.out.println("Merging result = " + merger("Test cases","executed",total));
    }
}
