package me.rivermind.proxy.fixed;

import me.rivermind.proxy.fixed.impl.BookFacadeImpl;

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
