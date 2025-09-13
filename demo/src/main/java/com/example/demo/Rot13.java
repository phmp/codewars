package com.example.demo;

import java.util.stream.Collectors;

public class Rot13 {

    public static void main(String[] args) {
        Integer a = 1;
        Character A = 'a';

//        Character letter = Character.valueOf(A - 1);
        System.out.println(A -1);
        System.out.println(rot13("test"));
        System.out.println(rot13("Test"));
    }

    public static String rot13(String str) {
        return  str.chars().boxed().map(integer -> (char) getAnInt(integer)).map(Object::toString).collect(Collectors.joining());
    }

    private static int getAnInt(Integer integer) {
        if(integer >= 'a' && integer <= 'z'){
            return (integer + 13 - 'a') % 26 + 'a';
        }
        if(integer >= 'A' && integer <= 'Z'){
            return (integer + 13 - 'A') % 26 + 'A';
        }
        return integer;
    }
}
