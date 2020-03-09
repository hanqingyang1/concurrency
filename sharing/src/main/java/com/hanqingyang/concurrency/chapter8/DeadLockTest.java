package com.hanqingyang.concurrency.chapter8;

/**
 * @ClassName DeadLockTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/11  16:24
 * @Version 1.0
 **/
public class DeadLockTest {
    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    otherService.s2();
                }
            }
        }.start();
    }
}
