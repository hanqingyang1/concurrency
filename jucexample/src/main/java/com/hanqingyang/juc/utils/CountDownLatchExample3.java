package com.hanqingyang.juc.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CountDownLatchExample3
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/11  8:50
 * @Version 1.0
 **/
public class CountDownLatchExample3 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();

        countDownLatch.await(3000,TimeUnit.MILLISECONDS);
        System.out.println("++++++++++++++++++++");
    }
}
