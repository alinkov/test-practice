package ru.hh.school.test.practice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder()
public class OrderTest {
  private static final StringBuilder sb = new StringBuilder();

  @AfterClass
  public static void afterClass() {
    sb.append("afterClass\n");
    System.out.println(sb);
  }

  @BeforeClass
  public static void beforeClass() {
    sb.append("beforeClass\n");
    System.out.println(sb);
  }

  @After
  public void tearDown() {
    sb.append("tearDown\n");
    System.out.println(sb);
  }

  @Before
  public void setUp() {
    sb.append("setUp\n");
    System.out.println(sb);
  }

  @Test
  public void test1() {
    sb.append("test1\n");
    System.out.println(sb);
  }

  @Test
  public void test2() {
    sb.append("test2\n");
    System.out.println(sb);
  }
}
