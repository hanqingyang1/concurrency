package com.hanqingyang.juc.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ExecutorServiceExample3
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/14  10:35
 * @Version 1.0
 **/
public class ExecutorServiceExample3 {

    public static void main(String[] args) {
//        test();
        testAllowsCoreThreadTimeOut();
    }

    public static void test(){
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println(executorService.getActiveCount());
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executorService.getActiveCount());
        executorService.allowsCoreThreadTimeOut();
    }

    public static void testAllowsCoreThreadTimeOut(){
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.setKeepAliveTime(10,TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executorService.allowsCoreThreadTimeOut());


    }
}
