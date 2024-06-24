package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SumOfTwoValuesTest {

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(List.of(2, 7, 11, 15), 9, List.of(2, 7)),
                Arguments.of(List.of(12, 7, 11, 15), 22, List.of(7, 15)),
                Arguments.of(List.of(3, 2, 4), 6, List.of(2, 4))
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(List<Integer> numbers, int target, List<Integer> expected) {
        Assertions.assertEquals(expected, SumOfTwoValues.solution(numbers, target));
    }
}
