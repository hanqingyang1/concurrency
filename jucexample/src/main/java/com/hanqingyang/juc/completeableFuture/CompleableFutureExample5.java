package com.hanqingyang.juc.completeableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompleableFutureExample5
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/16  16:18
 * @Version 1.0
 **/
public class CompleableFutureExample5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        getNow();
//        complete();
        testJoin();
        Thread.currentThread().join();
    }

    private static void testJoin(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "hello";
        });
        System.out.println(future.join());
    }

    private static void complete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "Hello";
        });
        boolean world = future.complete("world");
        System.out.println(world);
        System.out.println(future.get());
    }

    private static void getNow() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "Hello";
        });
        String result = future.getNow("word");
        System.out.println(result);
        System.out.println(future.get());
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
