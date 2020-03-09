package com.hanqingyang.concurrency.chapter7;

/**
 * @ClassName SynchronizedStatic
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/10  20:22
 * @Version 1.0
 **/
public class SynchronizedStatic {

    public synchronized static void m1(){
        System.out.println("m1 "+ Thread.currentThread().getName());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2(){
        System.out.println("m2 " +Thread.currentThread().getName());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static void m3(){
        System.out.println("m3 " +Thread.currentThread().getName());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
