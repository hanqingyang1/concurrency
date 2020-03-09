package com.hanqingyang.jucAtomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName AtomicStampedReferenceTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/4  16:44
 * @Version 1.0
 **/
public class AtomicStampedReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference atomicRef = new AtomicStampedReference(100,0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    boolean success = atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                    System.out.println(success);
                    success = atomicRef.compareAndSet(101,100,atomicRef.getStamp(),atomicRef.getStamp()+1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int stamp = atomicRef.getStamp();
                    System.out.println("sleep before  "+stamp);
                    TimeUnit.SECONDS.sleep(2);
                    boolean success = atomicRef.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
