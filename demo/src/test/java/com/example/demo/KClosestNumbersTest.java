package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class KClosestNumbersTest {

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 4, 3, List.of(1, 2, 3, 4)),
                Arguments.of(List.of(2, 4, 5, 6, 9), 3, 6, List.of(4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(List<Integer> numbers, int k, int target, List<Integer> expected ){
        Assertions.assertEquals(expected, KClosestNumbers.closestNumbers(k, target, numbers));
    }


}
