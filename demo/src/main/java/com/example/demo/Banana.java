package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;


public class Banana {
    static String BANANAS = "bananas";


    static Set<String> bananas(final String s) {
        List<Character> input = s.chars().mapToObj(a -> (char) a).toList();

        return simpleBanana(input, 0, 0);
    }

    private static Set<String> simpleBanana(List<Character> input, int startIndex, int startBananaIndex) {
        System.out.println("input: " + input);
        System.out.println("startIndex: " + startIndex);
        System.out.println("startBananaIndex: " + startBananaIndex);

        Set<String> result = new HashSet<>();
        List<Character> current = new ArrayList<>(input);
        for (int currentIndex = startIndex, banannasIndex = startBananaIndex; currentIndex < current.size(); currentIndex++) {
            if(banannasIndex >= BANANAS.length()){
                current.set(currentIndex, '-');
                continue;
            }

            Character letter = current.get(currentIndex);
            if (isNotBorNorA(letter)) {
                current.set(currentIndex, '-');
                continue;
            }

            if (letter.equals(BANANAS.charAt(banannasIndex))){
                Set<String> withTheSameLetter = simpleBanana(current, currentIndex+1, banannasIndex+1);
                current.set(currentIndex, '-');
                Set<String> withCrossedLetter = simpleBanana(current, currentIndex+1, banannasIndex);

                return mergeSet(withTheSameLetter, withCrossedLetter);
            } else {
                current.set(currentIndex, '-');
            }

        }

        if(withoutDashesIsBanana(current)) {
            result.add(current.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        return result;
    }

    private static boolean isNotBorNorA(Character letter) {
        return BANANAS.indexOf(letter) == -1;
    }

    private static boolean withoutDashesIsBanana(List<Character> current) {
        return current.stream().filter(a -> a != '-').map(String::valueOf).collect(Collectors.joining()).equals(BANANAS);
    }

    public static Set<String> mergeSet(Set<String> a, Set<String> b)
    {
        Set<String> mergedSet = new HashSet<>();
        mergedSet.addAll(a);
        mergedSet.addAll(b);
        return mergedSet;
    }
}
