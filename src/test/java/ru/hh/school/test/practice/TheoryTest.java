package ru.hh.school.test.practice;

import org.apache.commons.lang3.StringUtils;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class TheoryTest {
  @DataPoints
  public static TestData[] isEmptyData = new TestData[]{
      new TestData("", true),
      new TestData(" ", false),
      new TestData("some string", false),
  };

  @DataPoint
  public static TestData nullData = new TestData(null, true);

  @Theory
  public void testEmpty(final TestData testData) {
    final boolean actual = StringUtils.isEmpty(testData.input);
    assertEquals(testData.result, actual);
  }

  private static class TestData {
    private String input;
    private boolean result;

    public TestData(String input, boolean result) {
      this.input = input;
      this.result = result;
    }
  }

}
