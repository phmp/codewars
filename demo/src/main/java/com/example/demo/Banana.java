package com.example.demo;

import java.util.HashSet;
import java.util.Set;


public class Banana {
    static String BANANAS = "bananas";


    static Set<String> bananas(final String s) {
        Set<String> result = new HashSet<>();
        String withoutWrongLetters = s.replaceAll("[^abns]", "-");
        recursive(result, withoutWrongLetters, 0, 0);
        return result;
    }

    private static void recursive(Set<String> result, String current, int startIndex, int bananaIndex) {
        System.out.println(current);
        for (int currentIndex = startIndex; currentIndex < current.length(); currentIndex++) {
            if (bananaIndex >= BANANAS.length()) {
                current = crossLetter(current, currentIndex);
                continue;
            }

            Character letter = current.charAt(currentIndex);
            if (isNotBorNorA(letter)) {
                current = crossLetter(current, currentIndex);
                continue;
            }

            if (letter.equals(BANANAS.charAt(bananaIndex))) {
                recursive(result, current, currentIndex + 1, bananaIndex + 1);
                recursive(result, crossLetter(current, currentIndex), currentIndex + 1, bananaIndex);
                return;
            } else {
                current = crossLetter(current, currentIndex);
            }

        }

        if (withoutDashesIsBanana(current)) {
            result.add(current);
        }
    }

    private static String crossLetter(String word, int letterIndex) {
        return word.substring(0, letterIndex) + "-" + word.substring(letterIndex + 1);
    }

    private static boolean isNotBorNorA(Character letter) {
        return BANANAS.indexOf(letter) == -1;
    }

    private static boolean withoutDashesIsBanana(String current) {
        return current.replaceAll("-", "").equals(BANANAS);
    }

}
