package com.free;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassNameWaitNotify
 * @Description
 * @Author Free
 * @Date2021/10/13 23:42
 * @Version V1.0
 **/
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("1");
    }
    static class Wait implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + "falg is true. wa@"+
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();

                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread() + "flag is false. running@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock. notify @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                //SleepUtils.second(5);
            }
        }
    }

}
