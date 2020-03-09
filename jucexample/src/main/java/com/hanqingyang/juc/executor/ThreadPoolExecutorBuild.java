package com.hanqingyang.juc.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolExecutorBuild
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/13  14:10
 * @Version 1.0
 **/
public class ThreadPoolExecutorBuild {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        int activeCount = -1;
        int queueSize = -1;
        while(true){
            if(executor.getActiveCount() != activeCount || executor.getQueue().size() != queueSize) {
                System.out.println(executor.getActiveCount());
                System.out.println(executor.getCorePoolSize());
                System.out.println(executor.getMaximumPoolSize());
                System.out.println(executor.getKeepAliveTime(TimeUnit.SECONDS));
                System.out.println(executor.getQueue().size());

                activeCount = executor.getActiveCount();
                queueSize = executor.getQueue().size();
            }
        }
    }

    /*
    *
     * @Author 韩清阳
     * @Description  int corePoolSize,   线程池线程数量
                              int maximumPoolSize, 做大线程数
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler

     * @Date  2020/1/13  14:15
     * @Param []
     * @return void
     **/
    public static ThreadPoolExecutor buildThreadPoolExecutor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,30,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),r -> {
            Thread t = new Thread(r);
            return t;
        },new ThreadPoolExecutor.AbortPolicy());
        System.out.println("the ThreadPoolExecutor create done");

        executor.execute(()->sleepSeconds(100));
        executor.execute(()->sleepSeconds(100));
        executor.execute(()->sleepSeconds(100));
        executor.execute(()->sleepSeconds(100));
        return executor;
    }


    public static void sleepSeconds(int seconds){

        try {
            System.out.println(Thread.currentThread().getName() + "sleeped");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
