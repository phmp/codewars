package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfTwoValues {

    static List<Integer> solution(List<Integer> numbers, Integer target) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if(set.contains(target - number)) {
                return List.of(target - number, number);
            }
            set.add(number);
        }
        return List.of();
    }

}
