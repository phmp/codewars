package com.example.demo;

import java.util.List;

public class KClosestNumbers {
    /*
    Find k closest numbers
You are given a sorted array of integers, nums, and two integers,
target and k. Your task is to return k number of integers
that are closest to the target value, target. The integers
in the output array should be in sorted order.

An integer, nums[i], is considered to be closer to target,
as compared to nums[j] when |nums[i] - target| < |nums[j] - target|.
However, when |nums[i] - target| == |nums[j] - target|,
the smaller of the two values nums[i] and nums[j] is selected.
     */

    public static List<Integer> closestNumbers(int k, int target, List<Integer> numbers){
        return numbers.stream()
                .sorted((a,b) -> compare(a, b, target))
                .limit(k)
                .sorted()
                .toList();
    }

    private static int compare(Integer a, Integer b, int target) {
        int distance = distance(a, target) - distance(b, target);
        if (distance == 0) return a - b;
        return distance;
    }

    static int distance(int a, int b){
        return Math.abs(a - b);
    }
}
