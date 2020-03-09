package com.hanqingyang.jucAtomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicIntegerFieldUpdaterTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/5  8:38
 * @Version 1.0
 **/
public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Me> updater = AtomicIntegerFieldUpdater.newUpdater(Me.class,"i");
        Me me = new Me();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final int MAX = 20;
                    for (int j = 0; j < MAX; j++) {
                        int v = updater.getAndIncrement(me);
                        System.out.println(Thread.currentThread().getName() +"   => " + v);
                    }
                }
            }).start();
        }
    }

    static class Me{
        volatile int i;
    }
}
