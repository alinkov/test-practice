package ru.hh.school.test.practice;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleClass2Test {

    @Test
    public void testDoMultiply() {
        assertEquals(6.0, SimpleClass.doMultiply(List.of(1, 2, 3)), 0.000001);
    }

    @Test
    public void testDoMultiplyEmpty() {
        assertEquals(0.0, SimpleClass.doMultiply(List.of()), 0.000001);
        SimpleClass.doMultiply(null);
    }

    @Test
    public void testDoMultiplyNull() {
        assertEquals(0.0, SimpleClass.doMultiply(null), 0.000001);
    }

}