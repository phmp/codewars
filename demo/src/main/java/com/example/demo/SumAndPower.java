package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class SumAndPower {

    //codewars
    //5 kyu
    //Numbers that are a power of their sum of digits
    public static void main(String[] args) {
//        powerSumDigTerm(1);

//        powerSumDigTerm(2);
//        powerSumDigTerm(3);
        powerSumDigTerm(4);
    }

    private static List<Long> theNumbers = new ArrayList<>(){
        {
            add(81L);
            add(512L);
            add(2401L);
            add(4913L);
        }
    };

    public static long powerSumDigTerm(int n) {

        if(theNumbers.size() >= n){
            Long result = theNumbers.get(n - 1);
            System.out.println("result "+ result);
            return result;
        }
        while (n != theNumbers.size()){
            calculateNext();
        }


        Long result = theNumbers.get(theNumbers.size() - 1);
        System.out.println("result "+ result);
        return result;
    }

    private static void calculateNext() {
        long start = theNumbers.get(theNumbers.size()-1);
        for (long i = start +1; i< 10000000; i++){
//            System.out.println("checks " + i);
            if(isTheNumber(i)){
                theNumbers.add(i);
                return;
            }
        }
        throw new RuntimeException("too many operations");
    }

    private static boolean isTheNumber(long number){
        long sum = sumOfDigits(number);
        return isPowerOf(sum, number);
    }


    private static boolean isPowerOf(long base, long number) {
        if (base ==1){
            return false;
        }

        long currentPower = 1;
        long x = 0;
        do {
            x = (long) Math.pow(base,currentPower);
            if (x == number) {
//                System.out.println("this is it " + number);
                return true;
            }
            currentPower++;
        } while (x<number);
        return false;
    }

    static long sumOfDigits(long number){
        long sum = 0;

        while (number != 0)
        {
            sum = sum + number % 10;
            number = number/10;
        }

        return sum;
    }

}
