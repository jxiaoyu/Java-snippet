package me.rivermind.cl.load;

import java.net.MalformedURLException;

/**
 * @author river
 * @date 2017/8/11
 *
 * leak 的泄漏导致 classLoader 的泄漏，导致 Example 类对象的泄漏 http://zeroturnaround.com/rebellabs/rjc201/
 */
public class Main {
    private static IExample example1;
    private static IExample example2;

    public static void main(String[] args) throws
        InterruptedException, ClassNotFoundException, MalformedURLException,
        InstantiationException, IllegalAccessException {
        example1 = ExampleFactory.newInstance().copy(example1);

        while (true) {
            example2 = ExampleFactory.newInstance().copy(example2);
            ;

            System.out.println("1) " +
                example1.message() + " = " + example1.plusPlus());
            System.out.println("2) " +
                example2.message() + " = " + example2.plusPlus());
            System.out.println();

            Thread.currentThread().sleep(3000);
        }
    }
}