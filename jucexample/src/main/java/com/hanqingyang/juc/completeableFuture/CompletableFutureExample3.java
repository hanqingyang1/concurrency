package com.hanqingyang.juc.completeableFuture;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample3
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/16  14:20
 * @Version 1.0
 **/
public class CompletableFutureExample3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

       /* CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello").whenComplete((v, t) -> System.out.println(v + "====over===="));
        System.out.println(future.get());*/

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
                future.thenAcceptAsync(System.out::println);
       /* CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> "Hello")
                .handleAsync((s,t)->{
                    return s.length();
                });*/
//                .thenApply(String::length);
       /* .thenApplyAsync(s -> {
            try {
                System.out.println("2 ========  start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("2 ========= end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("======over=====");
            return s.length();
        });*/

        System.out.println(future.get());
    }
}
