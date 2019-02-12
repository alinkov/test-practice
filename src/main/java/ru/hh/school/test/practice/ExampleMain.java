package ru.hh.school.test.practice;

import ru.hh.nab.starter.NabApplication;

public class ExampleMain {

  public static void main(String[] args) {
    NabApplication.builder()
      .configureJersey(ExampleJerseyConfig.class).bindToRoot()
      .build().run(ExampleConfig.class);
  }
}
