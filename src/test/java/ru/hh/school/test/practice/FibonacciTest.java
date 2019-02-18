package ru.hh.school.test.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTest {
  private int fInput;
  private int fExpected;

  public FibonacciTest(int input, int expected) {
    System.out.println("Run constructor with params " + input + "\t" + expected);
    fInput = input;
    fExpected = expected;
  }

  @Parameterized.Parameters(name = "{index}: fib({0})={1}")
  public static Iterable<Object[]> data() {
    return List.of(new Object[][]{
        {0, 0},
        {1, 1},
        {2, 1},
        {3, 2},
        {4, 3},
        {5, 5},
        {6, 8},
        {7, 13}
    });
  }

  @Test
  public void test() {
    assertEquals(fExpected, Fibonacci.compute(fInput));
  }
}
