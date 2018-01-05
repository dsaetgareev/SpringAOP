package ru.dinis.aop.loggins;


import org.springframework.stereotype.Component;

/**
 * Create by dinis of 05.01.18.
 */
@Component
public class MyLogger {

    public void printValue(Object obj) {
        System.out.println(obj);
    }

    public void init() {
        System.out.println("init");
    }

    public void close() {
        System.out.println("close");
    }

    public void exception() {
        System.out.println("exception");
    }

}
