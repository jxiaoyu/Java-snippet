package me.rivermind.cl.load;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author river
 * @date 2017/8/11
 */
public class ExampleFactory {
    public static IExample newInstance() throws
        ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        URLClassLoader tmp =
            new URLClassLoader(urls) {
                @Override
                public Class loadClass(String name) throws ClassNotFoundException {
                    if ("example.Example".equals(name) || "leak.Leak".equals(name)) { return findClass(name); }
                    return super.loadClass(name);
                }
            };

        return (IExample)tmp.loadClass("example.Example").newInstance();
    }
}