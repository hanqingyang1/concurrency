package com.hanqingyang.juc.semaphore;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreExample3
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/6  16:28
 * @Version 1.0
 **/
public class SemaphoreExample3 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println("t1  finished");
        });
        t1.start();
        TimeUnit.MILLISECONDS.sleep(50);

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquireUninterruptibly();
              //  TimeUnit.SECONDS.sleep(5);
            } finally{
                semaphore.release();
            }
            System.out.println("t2 finished");
        });
        t2.start();

        TimeUnit.MILLISECONDS.sleep(50);
        t2.interrupt();


    }
}
