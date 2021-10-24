package com.free.designMode;

/**
 * @ClassNameLazySingleton
 * @Description 单例模式懒汉式
 * @Author Free
 * @Date2021/10/24 13:48
 * @Version V1.0
 **/
public class LazySingleton {
    //延迟加载保证多线程安全
    //使用volatile 是防止指令重排序，保证对象可见
    private volatile static LazySingleton singleton;

    private LazySingleton (){}

    public static LazySingleton getInstance(){
        //第一层if == null 是为了防止有多个线程同时创建
        if(singleton == null){
            //synchronized 是加锁预防多个线程同时进入该方法创建对象
            synchronized(LazySingleton.class){
                //这里的if == null 是防止有多个线程同时等待锁，
                // 一个执行完了后面一个又继续执行
                if(singleton == null){
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
