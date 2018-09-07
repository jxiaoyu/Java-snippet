package me.rivermind.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author river
 * @date 2018/8/20
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans.xml");
        String obj = (String) context.getBean("helloWorld");
        System.out.println("test");
    }
}
