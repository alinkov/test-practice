package ru.hh.school.test.practice;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static junit.framework.TestCase.fail;

@RunWith(Categories.class)
@Categories.IncludeCategory(CategoriesTest.SlowTests.class)
@Suite.SuiteClasses( { CategoriesTest.A.class, CategoriesTest.B.class })
public class CategoriesTest {
  public interface FastTests {
  }

  public interface SlowTests {
  }

  public static class A {
    @Test
    public void a() {
      fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
    }
  }

  @Category( { SlowTests.class, FastTests.class })
  public static class B {
    @Test
    public void c() {

    }
  }
}
