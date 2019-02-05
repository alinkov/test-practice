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