package ru.hh.school.test.practice;

import java.util.Collection;

public class SimpleClass {
    public static double doMultiply(Collection<Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.;
        }
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .reduce(1, (a, b) -> a * b);
    }

    private SimpleClass() {
    }
}
