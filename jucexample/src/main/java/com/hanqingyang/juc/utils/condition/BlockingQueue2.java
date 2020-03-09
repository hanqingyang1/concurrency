package com.hanqingyang.juc.utils.condition;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName BlockingQueue2
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  10:57
 * @Version 1.0
 **/
public class BlockingQueue2 {

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(1);

    private static  AtomicInteger data = new AtomicInteger(0);

    public static void producer(){
        try {
            TimeUnit.SECONDS.sleep(1);
            queue.put(data.incrementAndGet());
            Optional.of("P"+data).ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void consumer(){
        try {
            TimeUnit.SECONDS.sleep(1);
            Integer take = queue.take();
            Optional.of("C"+take).ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            for (;;){
                producer();
            }
        }).start();
        new Thread(()->{
            for (;;){
                producer();
            }
        }).start();
        new Thread(()->{
            for (;;){
                producer();
            }
        }).start();

        new Thread(()->{
            for (;;){
                consumer();
            }
        }).start();
        new Thread(()->{
            for (;;){
                consumer();
            }
        }).start();
    }
}
