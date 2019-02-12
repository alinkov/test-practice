package ru.hh.school.test.practice;

public class SomeFeature {
    private final SomeService someService;

    public SomeFeature(SomeService someService) {
        this.someService = someService;
    }

    public int doSomething1(int param) {
        return someService.doSomething1(param * param) * 2;
    }

    public String doSomething2(String param) {
        if (param == null) {
            return "";
        }
        return someService.doSomething2(param + "_TEST");
    }
}
