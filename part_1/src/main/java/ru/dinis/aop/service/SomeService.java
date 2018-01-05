package ru.dinis.aop.service;


import org.springframework.stereotype.Component;

/**
 * Create by dinis of 05.01.18.
 */
@Component
public class SomeService {

    public int getIntValue() {
        return 5;
    }

    public double getDoubleValue() {
        return 5.6;
    }

    public int difer() {
        return 5/2;
    }

}
