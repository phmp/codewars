package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

public class BananaTest {

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("banana", Set.of()),
                Arguments.of("banggana", Set.of()),
                Arguments.of("bananas", Set.of("bananas")),
                Arguments.of("bananass", Set.of("bananas-", "banana-s")),
                Arguments.of("bananaws", Set.of("banana-s"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(String input, Set<String> expected ){
        Assertions.assertEquals(expected, Banana.bananas(input));
    }


}
