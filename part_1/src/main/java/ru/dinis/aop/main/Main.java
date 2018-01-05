package ru.dinis.aop.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dinis.aop.service.SomeService;

/**
 * Create by dinis of 05.01.18.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SomeService service = (SomeService) context.getBean("someService");
        double val = service.difer();
    }

}
