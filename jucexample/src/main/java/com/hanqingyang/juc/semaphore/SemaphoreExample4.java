package com.hanqingyang.juc.semaphore;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreExample4
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/6  16:55
 * @Version 1.0
 **/
public class SemaphoreExample4 {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(5);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.drainPermits();
                System.out.println(semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                semaphore.release(5);
            }
            System.out.println("t1 finished");
        });
        t1.start();

        TimeUnit.MILLISECONDS.sleep(50);

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                semaphore.release();
            }
            System.out.println("t2 finished");
        });

        t2.start();
    }
}
