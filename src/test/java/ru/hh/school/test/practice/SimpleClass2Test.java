package ru.hh.school.test.practice;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleClass2Test {

    @Test
    public void testDoMultiply() {
        final double multiply = SimpleClass.doMultiply(List.of(1, 2, 3));

        assertEquals(6.0, multiply, 0.000001);
    }

    @Test
    public void testDoMultiplyEmpty() {
        final double multiply = SimpleClass.doMultiply(List.of());

        assertEquals(0.0, multiply, 0.000001);
    }

    @Test
    public void testDoMultiplyNull() {
        final double multiply = SimpleClass.doMultiply(null);

        assertEquals(0.0, multiply, 0.000001);
    }

    @Test
    @Ignore
    public void coverage100DontDoIt() throws Exception {
        System.out.println("Don't do it! It's only for 100% Pitest coverage");
        Constructor<SimpleClass> constructor = SimpleClass.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}