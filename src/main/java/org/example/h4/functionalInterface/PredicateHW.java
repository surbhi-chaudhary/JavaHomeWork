package org.example.h4.functionalInterface;

import java.util.function.Predicate;

public class PredicateHW {

    public static boolean validate(String inp, Predicate<String> predicate){
        return predicate.test(inp);
    }

    public static boolean analysis(Integer num, Predicate<Integer> predicate){
        return predicate.test(num);
    }

    public static void main(String[] args) {
        Predicate<String> hasReqLength = x -> (x.length() > 5);
        Predicate<Integer> isPositive = x -> (x > 0);
        Predicate<Integer> isZero = x -> (x == 0 );
        Predicate<Integer> isNegative = x -> (x < 0);

//        System.out.println(hasReqLength.test("This is for testing"));
//
//        System.out.println("Validate that input have required length: " + validate( "This", hasReqLength)); // false
//        System.out.println("Validate that input have required length: " +  validate( "Passes", hasReqLength)); // true

        System.out.println( "Analysis that 10 is positive: " + analysis( 10, isPositive)); // true
//        System.out.println( "Analysis that 0 is positive: " + analysis( 0, isPositive)); // false
//        System.out.println( "Analysis that -10 is positive: " + analysis( -10, isPositive)); // false
//
        System.out.println( "Analysis that 11 is 0: " + analysis( 10, isZero)); // false
//        System.out.println( "Analysis that 0 is 0: " + analysis( 0, isZero)); // true
//        System.out.println( "Analysis that -11 is 0: " + analysis( -10, isZero)); // false
//
//        System.out.println( "Analysis that 12 is negative: " + analysis( 10, isNegative)); // false
//        System.out.println( "Analysis that 0 is negative: " + analysis( 0, isNegative)); // false
        System.out.println( "Analysis that -12 is negative: " + analysis( -10, isNegative)); // true

    }
}
