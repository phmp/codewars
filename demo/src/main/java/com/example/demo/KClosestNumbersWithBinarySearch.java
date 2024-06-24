package com.example.demo;

import java.util.List;

public class KClosestNumbersWithBinarySearch {
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

    public static List<Integer> closestNumbers(int k, int target, List<Integer> numbers) {

        int indexClosestToTarget = binarySearch(numbers, target);

        if (indexClosestToTarget == 0) {
            return numbers.subList(0, k);
        }

        if (indexClosestToTarget == numbers.size() - 1) {
            return numbers.subList(numbers.size() - k, numbers.size());
        }

        int leftBoundToTest = indexClosestToTarget - 1;
        int rightBoundToTest = indexClosestToTarget + 1;
        int leftWindowBound = indexClosestToTarget;
        int rightWindowBound = indexClosestToTarget;
        while (rightWindowBound - leftWindowBound < k - 1) {

            int leftTest = numbers.get(leftBoundToTest);
            int rightTest = numbers.get(rightBoundToTest);

            if (distance(leftTest, target) > distance(rightTest, target)) {
                rightWindowBound = rightBoundToTest;
                if (rightBoundToTest + 1 < numbers.size()) {
                    rightBoundToTest++;
                } else {
                    leftWindowBound = rightWindowBound - k + 1;
                    break;
                }
            } else { //when distance is the same extend left bound
                leftWindowBound = leftBoundToTest;
                if (leftBoundToTest - 1 >= 0) {
                    leftBoundToTest--;
                } else {
                    rightWindowBound = leftWindowBound + k - 1;
                    break;
                }
            }
        }
        return numbers.subList(leftWindowBound, rightWindowBound + 1);
    }

    static int distance(int a, int b) {
        return Math.abs(a - b);
    }

    static int binarySearch(List<Integer> numbers, int target) {
        int low = 0;
        int high = numbers.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers.get(mid) == target) {
                return mid;
            }
            if (numbers.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
