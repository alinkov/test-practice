package ru.hh.school.test.practice;

import java.util.Optional;

public class SomeServiceStub implements SomeService {

    @Override
    public int doSomething1(int param) {
        System.out.println("Run Stub!");
        return param / 2;
    }

    @Override
    public String doSomething2(String param) {
        System.out.println("Run Stub!");
        return Optional.ofNullable(param)
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect argument"));
    }
}