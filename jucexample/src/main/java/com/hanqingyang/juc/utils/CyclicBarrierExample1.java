package com.hanqingyang.juc.utils;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierExample1
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/11  16:42
 * @Version 1.0
 **/
public class CyclicBarrierExample1 {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部结束");
            }
        });

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println("T1 开始工作");
                cyclicBarrier.await();
                System.out.println("T1 工作结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("T2 开始工作");
                cyclicBarrier.await();
                System.out.println("T2 工作结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());

    }
}
