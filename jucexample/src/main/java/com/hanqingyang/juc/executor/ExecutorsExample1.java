package com.hanqingyang.juc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName ExecutorsExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/13  15:46
 * @Version 1.0
 **/
public class ExecutorsExample1 {

    public static void main(String[] args) throws InterruptedException {
//        useCacheThreadPool();
        useFixedsizeThradPool();
    }

    private static void useSingleThreadPool(){
        ExecutorService executorSerive = Executors.newSingleThreadExecutor();


    }

    /*
    *
     * @Author 韩清阳
     * @Description  public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>())
     * @Date  2020/1/13  16:06
     * @Param []
     * @return void
     **/
    public static void  useFixedsizeThradPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        IntStream.range(0,100).boxed().forEach(i->{
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "[ " + i+ "]");
            });
        });
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdown();
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

    }

    /*
    *
     * @Author 韩清阳
     * @Description  (0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>()
     * @Date  2020/1/13  16:04
     * @Param []
     * @return void
     **/
    private static void useCacheThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        IntStream.range(0,100).boxed().forEach(i->{
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "[ " + i+ "]");
            });
        });
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdown();
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
    }
}
