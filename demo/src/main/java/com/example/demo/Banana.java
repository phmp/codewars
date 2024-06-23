package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;


public class Banana {
    static String BANANAS = "bananas";


    static Set<String> bananas(final String s) {
        return simpleBanana(s, 0, 0);
    }

    private static Set<String> simpleBanana(String current, int startIndex, int startBananaIndex) {
        Set<String> result = new HashSet<>();
        for (int currentIndex = startIndex, banannasIndex = startBananaIndex; currentIndex < current.length(); currentIndex++) {
            if(banannasIndex >= BANANAS.length()){
                current = crossLetter(current, currentIndex);
                continue;
            }

            Character letter = current.charAt(currentIndex);
            if (isNotBorNorA(letter)) {
                current = crossLetter(current, currentIndex);
                continue;
            }

            if (letter.equals(BANANAS.charAt(banannasIndex))){
                Set<String> withTheSameLetter = simpleBanana(current, currentIndex+1, banannasIndex+1);
                Set<String> withCrossedLetter = simpleBanana(crossLetter(current, currentIndex), currentIndex+1, banannasIndex);
                return mergeSet(withTheSameLetter, withCrossedLetter);
            } else {
                current = crossLetter(current, currentIndex);
            }

        }

        if(withoutDashesIsBanana(current)) {
            result.add(current);
        }

        return result;
    }

    private static String crossLetter(String word, int letterIndex) {
        return word.substring(0, letterIndex) + "-" + word.substring(letterIndex+1);
    }

    private static boolean isNotBorNorA(Character letter) {
        return BANANAS.indexOf(letter) == -1;
    }

    private static boolean withoutDashesIsBanana(String current) {
        return current.replaceAll("-","").equals(BANANAS);
    }

    public static Set<String> mergeSet(Set<String> a, Set<String> b)
    {
        Set<String> mergedSet = new HashSet<>();
        mergedSet.addAll(a);
        mergedSet.addAll(b);
        return mergedSet;
    }
}
