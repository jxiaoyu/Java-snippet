package me.rivermind.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author river
 * @date 2017/8/11
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.print("事务开始...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束...");
        return null;
    }
}
