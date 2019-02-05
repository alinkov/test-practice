package ru.hh.school.test.practice;

import org.junit.Test;

import java.util.List;

public class SimpleClassTest {

    @Test
    public void testDoMultiply() {
        SimpleClass.doMultiply(List.of(1, 2, 3));
        SimpleClass.doMultiply(List.of());
        SimpleClass.doMultiply(null);
    }
}