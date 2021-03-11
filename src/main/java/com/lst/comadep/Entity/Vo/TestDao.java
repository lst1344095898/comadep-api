package com.lst.comadep.Entity.Vo;

public class TestDao<T>{
    private String testName;
    private T number;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

}
