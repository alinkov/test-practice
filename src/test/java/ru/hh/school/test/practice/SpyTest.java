package ru.hh.school.test.practice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SpyTest {
    private SomeFeature someFeature;
    private SomeService service;

    @Before
    public void setUp() {
        service = Mockito.spy(new SomeServiceStub());
        someFeature = new SomeFeature(service);
    }

    // TESTS AS MOCK

    @Test
    public void doSomething1Verify() {
        int param = 10;
        someFeature.doSomething1(param);
        Mockito.verify(service, Mockito.times(1)).doSomething1(Mockito.eq(param * param));
    }

    @Test
    public void doSomething1Return() {
        int param = 10;
        int answer = 15_000;
        Mockito.when(service.doSomething1(param * param)).thenReturn(answer);
        assertEquals(answer * 2, someFeature.doSomething1(param));
        Mockito.verify(service, Mockito.times(1)).doSomething1(Mockito.eq(param * param));
    }

    @Test
    public void doSomething2Null() {
        assertNotNull(someFeature.doSomething2(null));
    }

    @Test
    public void doSomething2Verify() {
        var str = "It's only test";
        someFeature.doSomething2(str);
        Mockito.verify(service, Mockito.times(1)).doSomething2(Mockito.endsWith("_TEST"));
    }

    @Test
    public void doSomething2Return() {
        var str = "It's only test 2";
        var answer = "Good!!!";
        Mockito.when(service.doSomething2(Mockito.endsWith("_TEST"))).thenReturn(answer);
        assertEquals(answer, someFeature.doSomething2(str));
        Mockito.verify(service, Mockito.times(1)).doSomething2(Mockito.endsWith("_TEST"));
    }


    //TESTS AS A STUB

    @Test
    public void doSomething1ReturnStub() {
        int param = 10;
        int answer = 100;
        assertEquals(answer, someFeature.doSomething1(param));
    }

    @Test
    public void doSomething2ReturnStub() {
        var str = "It's only test 2";
        var answer = "IT'S ONLY TEST 2_TEST";
        assertEquals(answer, someFeature.doSomething2(str));
    }
}
