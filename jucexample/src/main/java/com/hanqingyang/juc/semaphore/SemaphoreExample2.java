package com.hanqingyang.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreExample2
 * @Author 韩清阳
 * @Description
 * @Date 2019/12/30  19:15
 * @Version 1.0
 **/
public class SemaphoreExample2 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 2; i++) {
                new Thread(()->{
                    try {
                        System.out.println(Thread.currentThread().getName() + "  in");
                        semaphore.acquire(1);
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(Thread.currentThread().getName() + "  out");
                    }catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        semaphore.release(1);
                    }
                }).start();
        }

        while(true){
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.getQueueLength());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
