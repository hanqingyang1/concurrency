package com.hanqingyang.juc.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchExample2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/10  17:22
 * @Version 1.0
 **/
public class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                System.out.println("初始化数据");
                try {
                    Thread.sleep(1000);
                    countDownLatch.await();
                    System.out.println("执行其他方法");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("异步执行");
                try {
                    Thread.sleep(1000);
                    System.out.println("异步执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    countDownLatch.countDown();
                }
            }
        }.start();

        Thread.currentThread().join();
    }
}
