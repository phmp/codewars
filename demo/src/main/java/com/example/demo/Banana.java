package com.example.demo;

import java.util.HashSet;
import java.util.Set;


public class Banana {
    static String BANANAS = "bananas";


    static Set<String> bananas(final String s) {
        Set<String> result = new HashSet<>();
        String withoutWrongLetters = s.replaceAll("[^abns]", "-");
        recursive(result, withoutWrongLetters, 0);
        return result;
    }

    private static void recursive(Set<String> result, String current, int currentIndex) {
        System.out.println(current + " " + currentIndex);
        String currentWithoutCrosses = current.replaceAll("-", "");
        if (currentWithoutCrosses.equals(BANANAS)) {
            result.add(current);
        }
        if(currentWithoutCrosses.length()<BANANAS.length()) {
            return;
        }
        if(currentIndex < current.length()) {
            recursive(result, current, currentIndex + 1);
            if (current.charAt(currentIndex) != '-') {
                recursive(result, crossLetter(current, currentIndex), currentIndex + 1);
            }
        }
    }

    private static String crossLetter(String word, int letterIndex) {
        return word.substring(0, letterIndex) + "-" + word.substring(letterIndex + 1);
    }

}
