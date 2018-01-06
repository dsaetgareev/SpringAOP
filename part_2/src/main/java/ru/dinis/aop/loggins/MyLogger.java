package ru.dinis.aop.loggins;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * Create by dinis of 05.01.18.
 */
@Component
@Aspect
public class MyLogger {
    @Pointcut("execution(* ru.dinis.aop.interfaces.Manager.*(..))")
    private void allMethods() {
    }
    @Around("allMethods() && execution(java.util.Map *(..))")
    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinPoint.getSignature().toShortString());

        Object output = null;

        try {
            output = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toShortString() + "time: " + time + "ms");
        return output;
    }
    @AfterReturning(pointcut = "allMethods() && execution(java.util.Map *(..))", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin>>");

        if (obj instanceof Set) {
            Set set = (Set) obj;
            System.out.println(set.size());
            System.out.println("I am set");
            for (Object object : set) {
                System.out.println(object);
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            System.out.println(map.size());
            System.out.println("I am map");
            for (Object object : map.keySet()) {
                System.out.println("key: " + object + ", " + map.get(object));
            }
        }
    }

}
