package com.hanqingyang.concurrent.chapter14;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @ClassName JDKCountDown
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/14  8:47
 * @Version 1.0
 **/
public class JDKCountDown {

    private final static Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("准备多线程处理任务");
        //开始执行多线程
        IntStream.rangeClosed(1,5).forEach(i -> {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" is work");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("多线程处理任务结束，开始第二阶段任务");
    }
}
