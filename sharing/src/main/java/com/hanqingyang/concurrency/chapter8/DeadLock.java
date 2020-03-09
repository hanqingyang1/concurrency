package com.hanqingyang.concurrency.chapter8;

/**
 * @ClassName DeadLock
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/10  20:41
 * @Version 1.0
 **/
public class DeadLock {

    private OtherService otherService;

    private final Object lock  = new Object();

    public DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void m1(){
        synchronized(lock){
            System.out.println("m1===");
            otherService.s1();
        }
    }

    public void m2(){
        synchronized (lock){
            System.out.println("m2====");
        }
    }

}
