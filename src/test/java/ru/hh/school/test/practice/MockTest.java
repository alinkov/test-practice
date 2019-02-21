package ru.hh.school.test.practice;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MockTest {
    //preparation
    private SomeService service = Mockito.mock(SomeService.class);
    private SomeFeature someFeature = new SomeFeature(service);

    @Test
    public void doSomething1() {
        //only call method bad test
        someFeature.doSomething1(0);
    }

    @Test
    public void doSomething1Verify() {
        int param = 10;
        someFeature.doSomething1(param);
        //verify
        Mockito.verify(service, Mockito.times(1))
            .doSomething1(Mockito.eq(param * param));
    }

    @Test
    public void doSomething1Return() {
        //preparation
        int param = 10;
        int answer = 15_000;
        Mockito.when(service.doSomething1(param * param)).thenReturn(answer);
        //call method
        final int result = someFeature.doSomething1(param);
        //verify
        assertEquals(answer * 2, result);
        Mockito.verify(service, Mockito.times(1))
            .doSomething1(Mockito.eq(param * param));
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
        Mockito.verify(service, Mockito.times(1))
            .doSomething2(Mockito.endsWith("_TEST"));
    }

    @Test
    public void doSomething2Return() {
        var str = "It's only test 2";
        var answer = "Good!!!";
        Mockito.when(service.doSomething2(Mockito.endsWith("_TEST")))
            .thenReturn(answer);
        //call method
        final String result = someFeature.doSomething2(str);
        //verify
        assertEquals(answer, result);
        Mockito.verify(service, Mockito.times(1))
            .doSomething2(Mockito.endsWith("_TEST"));
    }
}
