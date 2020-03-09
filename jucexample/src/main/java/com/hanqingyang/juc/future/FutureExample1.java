package com.hanqingyang.juc.future;

import java.util.concurrent.*;

/**
 * @ClassName FutureExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/14  15:51
 * @Version 1.0
 **/
public class FutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

      testGet();

    }


    private static void testGet() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println("=======================================");
        System.out.println(future.get(5,TimeUnit.SECONDS));
        System.out.println(future.get());
    }


    private static void testCancle(){

    }
}
