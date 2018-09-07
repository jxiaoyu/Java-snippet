package me.rivermind.proxy.fixed;

import proxy.impl.BookFacadeImpl;

public class TestProxy {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade)proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }
}
