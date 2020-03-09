package com.hanqingyang.juc.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierExample2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/12  8:42
 * @Version 1.0
 **/
public class CyclicBarrierExample2 {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(50);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

/*        TimeUnit.MILLISECONDS.sleep(4000);
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());
        TimeUnit.SECONDS.sleep(2);
        cyclicBarrier.reset();
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());*/
    }
}
