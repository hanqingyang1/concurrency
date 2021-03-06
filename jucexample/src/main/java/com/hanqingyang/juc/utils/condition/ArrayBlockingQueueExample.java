package com.hanqingyang.juc.utils.condition;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ArrayBlockingQueueExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  10:36
 * @Version 1.0
 **/
public class ArrayBlockingQueueExample {

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(1);

    private static  volatile int data = 0;

    public static void put(){
        try {
            queue.put(++data);
            Optional.of("P" + data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void take(){
        try {
            TimeUnit.SECONDS.sleep(1);
            int data = queue.take();
            Optional.of("C"+data).ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        new Thread(()->{
            for (;;){
                put();
            }
        }).start();

        new Thread(()->{
            for (;;){
                take();
            }
        }).start();
    }
}
