package com.hanqingyang.juc.completableFuture2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample3
 * @Author 韩清阳
 * @Description
 * @Date 2020/3/10  14:51
 * @Version 1.0
 **/
public class CompletableFutureExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
//                future.thenApply(String::length);
                future.thenApplyAsync(s -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("done");
                    return s.length();
                });

        /*
        *
         * @Author 韩清阳
         * @Description
         * future.whenComplete执行结果
         * dgdsgHello
         * done
         * Hello
         * future.whenCompleteAsync 执行结果
         * Hello
         * dgdsgHello
         * done
         * @Date  2020/3/10  14:53
         * @Param [args]
         * @return void
         **/
      /*  CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
                future.whenCompleteAsync((v,t)->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("dgdsg"+ v);
                    System.out.println("done");
                });*/
//                .whenComplete((v, t) -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("dgdsg"+ v);
//                    System.out.println("done");
//                });
        System.out.println(future.get());
        Thread.currentThread().join();
    }
}
