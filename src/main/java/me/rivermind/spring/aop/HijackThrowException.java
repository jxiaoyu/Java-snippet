package me.rivermind.spring.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author river
 * @date 2017/8/11
 */
public class HijackThrowException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
