package com.hanqingyang.juc.utils.condition;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ConditionExampleByQueue
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  10:08
 * @Version 1.0
 **/
public class ConditionExampleByQueue {

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

    private static volatile int data = 0;

    public static void put(){
        data ++;
        try {
            Optional.of("P"+data).ifPresent(System.out::println);
            queue.put(data);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void take(){
        try {
            Integer data = queue.take();
            Optional.of("C"+data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            for(;;)
            put();
        }).start();

        new Thread(()->{
            for (;;)
            take();
        }).start();
    }
}
