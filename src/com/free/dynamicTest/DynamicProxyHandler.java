package com.free.dynamicTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassNameDynamicProxyHandler
 * @Description
 * @Author Free
 * @Date2021/10/14 23:54
 * @Version V1.0
 **/
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理工作了.");
        return method.invoke(proxyed, args);
    }
}
