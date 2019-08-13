package me.rivermind.proxy.naive.impl;

import me.rivermind.proxy.cglib.BookFacade;

/**
 * @author river
 * @date 2017/8/11
 */
public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook() {
        System.out.println("增加图书方法...");
    }
}
