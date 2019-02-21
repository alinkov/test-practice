package ru.hh.school.test.practice;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StubTest {
    private final SomeServiceStub serviceStub = new SomeServiceStub();
    private final SomeFeature someFeature = new SomeFeature(serviceStub);

    @Test
    public void doSomething1() {
        //only call without verify. Bad test
        someFeature.doSomething1(0);
    }

    @Test
    public void doSomething1Verify() {
        int param = 10;
        //call method
        someFeature.doSomething1(param);
        //verify
        // Не работает, т.к. это Stub
        // Mockito.verify(serviceStub, Mockito.times(1))
        // .doSomething1(Mockito.eq(param * param));
    }

    @Test
    public void doSomething1Return() {
        int param = 10;
        int answer = 100;
        // Не работает, т.к. это Stub
        // Mockito.when(serviceStub.doSomething1(param * param)).thenReturn(answer);
        //call method
        final int result = someFeature.doSomething1(param);
        //verify
        assertEquals(answer, result);
        // Не работает, т.к. это Stub
        // Mockito.verify(serviceStub, Mockito.times(1))
        // .doSomething1(Mockito.eq(param * param));
    }

    @Test
    public void doSomething2Null() {
        //call method
        final String result = someFeature.doSomething2(null);
        //verify
        assertNotNull(result);
    }

    @Test
    public void doSomething2Verify() {
        var str = "It's only test";
        //call method
        someFeature.doSomething2(str);
        //verify
        // Не работает, т.к. это Stub
        // Mockito.verify(serviceStub, Mockito.times(1)).doSomething2(Mockito.endsWith("_TEST"));
    }

    @Test
    public void doSomething2Return() {
        //preparation
        var str = "It's only test 2";
        var answer = "IT'S ONLY TEST 2_TEST";
        // Не работает, т.к. это Stub
        // Mockito.when(serviceStub.doSomething2(Mockito.endsWith("_TEST"))).thenReturn(answer);
        //call method
        final String result = someFeature.doSomething2(str);
        //verify
        assertEquals(answer, result);
        // Не работает, т.к. это Stub
        // Mockito.verify(serviceStub, Mockito.times(1))
        // .doSomething2(Mockito.endsWith("_TEST"));
    }

}
