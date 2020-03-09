package com.hanqingyang.concurrency.chapter7;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @ClassName SynchronizedThis
 * @Author 韩清阳
 * @Description //
 * @Date 2019/9/10  20:10
 * @Version 1.0
 **/
public class SynchronizedThis {

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }
}

class ThisLock{

    public synchronized void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void m2(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
