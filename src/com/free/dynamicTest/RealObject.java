package com.free.dynamicTest;

/**
 * @ClassNameRealObject
 * @Description
 * @Author Free
 * @Date2021/10/14 23:54
 * @Version V1.0
 **/
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething.");
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
