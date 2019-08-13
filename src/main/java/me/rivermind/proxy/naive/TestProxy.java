package me.rivermind.proxy.naive;

import me.rivermind.proxy.naive.impl.BookFacadeImpl;

/**
 * @author river
 * @date 2017/8/11
 */
public class TestProxy {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade)proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }
}
