package com.hanqingyang.juc.executor;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName ThreadPoolExecutorTask
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/13  14:55
 * @Version 1.0
 **/
public class ThreadPoolExecutorTask {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,30,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), r -> {
            Thread t = new Thread(r);
            //设置为守护线程，可以被主线程打断
            t.setDaemon(true);
            return t;
        },new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0,20).boxed().forEach(i->{
            executor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "[ "+ i + "] finish done" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.HOURS);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======================over====================");
    }

}
