package org.example.h4.functionalInterface;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;
import java.util.function.Supplier;
public class SupplierHW
{
    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();
        LocalTime currentTime = LocalTime.now();

        int hr = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();

        Supplier<String> generate= () ->{
            Random r = new Random();
            int r1 = r.nextInt(0,26);
            char ch = (char) ('A' + r1);

            String time = String.valueOf( hr) + ":" + String.valueOf( minute) + ":" + String.valueOf( second) + "-";
            time += (ch);
            return time;
        };

        Supplier<String> morningMessage = () -> "Good Morning!";
        Supplier<String> afternoonMessage = () -> "Working!";
        Supplier<String> processingMessage = () -> "Processing...";

        String message;
        if ( hr < 12) {
            message = morningMessage.get();
        } else if ( hr < 18) {
            message = afternoonMessage.get();
        } else {
            message = processingMessage.get();
        }

        System.out.println( "Generated random string is " + generate.get());
        System.out.println( "Custom greet message is " + message);

    }
}
