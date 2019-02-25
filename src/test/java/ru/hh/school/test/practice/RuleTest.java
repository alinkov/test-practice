package ru.hh.school.test.practice;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RuleTest {
  @Rule
  public final TemporaryFolder folder = new TemporaryFolder();

  @Rule
  public final Timeout timeout = new Timeout(1000, TimeUnit.MILLISECONDS);

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Ignore
  @Test
  public void anotherInfinity() {
    while (true);
  }

  @Test
  public void testFileWriting() throws IOException {
    final File log = folder.newFile("debug.log");
    final FileWriter logWriter = new FileWriter(log);
    logWriter.append("Hello, ");
    logWriter.append("World!!!");
    logWriter.flush();
    logWriter.close();
  }

  @Test
  public void testExpectedException() {
    thrown.expect(NullPointerException.class);
    Integer test = null;
    int forNpe = test;
  }
}
