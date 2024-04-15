package org.example.h4.numberPredicate;

import java.util.ArrayList;
import java.util.List;

public class NumberFilter {

    public List<Integer> filterNumbers( List<Integer> list, NumberPredicate numberPredicate ){
        List<Integer> res = new ArrayList<>();
        for (int x : list){
            if (numberPredicate.test(x)){
                res.add(x);
            }
        }
        return res;
    }
}
