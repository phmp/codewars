package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.demo.Solution.maxValues;


class SolutionTest {

    public static List<String> bitPattern(List<Integer> numbers){

        StringBuilder leftResult = new StringBuilder();
        StringBuilder rightResult = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            Integer theNumber = numbers.get(i);

            List<Integer> left = numbers.subList(0, i);
            if(left.contains(theNumber)){
                leftResult.append("1");
            } else {
                leftResult.append("0");
            }

            List<Integer> right = numbers.subList(i+1, numbers.size());
            if(right.contains(theNumber)){
                rightResult.append("1");
            } else {
                rightResult.append("0");
            }

        }

        return List.of(leftResult.toString(), rightResult.toString());
    }

    @Test
    void test1() {
        List<Integer> numbers = List.of(3,0,1,4);
        List<Integer> result = maxValues(5, numbers);
        Assertions.assertEquals(List.of(4,3,2,3,4), result);
    }
}