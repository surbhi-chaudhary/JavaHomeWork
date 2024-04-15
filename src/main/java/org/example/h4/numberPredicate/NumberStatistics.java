package org.example.h4.numberPredicate;

import java.util.List;
import java.util.function.Predicate;

public class NumberStatistics {

    public int sum(List<Integer> list ){
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double avg(List<Integer> list ){
        return list.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public int max(List<Integer> list ){
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public int min(List<Integer> list ){
        return list.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}
