package me.rivermind.proxy.cglib;

import me.rivermind.proxy.cglib.impl.BookFacadeImpl;

/**
 * @author river
 * @date 2017/8/11
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookCglib = (BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());

        bookCglib.addBook();
    }
}
