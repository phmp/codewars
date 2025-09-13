package com.example.demo;

public class BigNumbers {

    public static void main(String[] args) {
        System.out.println(add("1", "2"));
        System.out.println(add("1000000000000000000", "1000000000000000000"));
    }

    public static String add(String a, String b) {
        return a;
    }

    static String add(StringBuffer x, Integer a, Integer b){
        return "";
    }

}