package com.example.demo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static List<Integer> maxValues(int numberOfStudents, List<Integer> positions){
        List<Integer> result = initZeros(numberOfStudents);
        List<Integer> studentsIndexes = initStudents(numberOfStudents);

        for (int position : positions) {
            for (int i = 0; i < studentsIndexes.size(); i++) {
                int index = studentsIndexes.get(i);
                int distance = Math.abs(index - position);
                result.set(index, Math.max(distance, result.get(index)));
            }


            List<Integer> indexesOfBoredStudents = new ArrayList<>();
            for (Integer index : studentsIndexes) {
                if (result.get(index) >= Math.max(Math.abs(index - position), Math.abs(index))){
                    indexesOfBoredStudents.add(index);
                }
            }
            studentsIndexes.removeAll(indexesOfBoredStudents);
        }

        return result;
    }

    private static List<Integer> initStudents(int numberOfStudents) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            result.add(i);
        }
        return result;

    }

    private static List<Integer> calculateMaximums(List<Integer> currentValues, List<Integer> currentMaximums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentValues.size(); i++) {
            Integer a = currentMaximums.get(i);
            Integer b = currentValues.get(i);
            int max = Math.max(a, b);
            result.add(max);
        }
        return result;
    }

    private static List<Integer> calculateDistances(int position, int numberOfStudents) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            result.add(Math.abs(i - position));
        }
        return result;
    }

    private static List<Integer> initZeros(int numberOfStudents) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            result.add(0);
        }
        return result;
    }
}
