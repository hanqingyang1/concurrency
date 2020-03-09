package com.hanqingyang.concurrency.chapter8;

/**
 * @ClassName OtherService
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/10  20:44
 * @Version 1.0
 **/
public class OtherService {

    private DeadLock deadLock;

    private final Object lock = new Object();
    public void s1(){
        synchronized(lock){
            System.out.println("s1============");
        }
    }

    public void s2(){
        synchronized(lock){
            System.out.println("s2==========");
            deadLock.m2();
        }

    }
    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
