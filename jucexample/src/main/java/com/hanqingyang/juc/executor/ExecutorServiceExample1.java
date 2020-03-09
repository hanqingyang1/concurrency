package com.hanqingyang.juc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ExecutorServiceExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/14  9:30
 * @Version 1.0
 **/
public class ExecutorServiceExample1 {

    public static void main(String[] args) {
//        isShutdown();
        isTerminated();
    }


    private static void isTerminated(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    private static void isShutdown(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }
}
