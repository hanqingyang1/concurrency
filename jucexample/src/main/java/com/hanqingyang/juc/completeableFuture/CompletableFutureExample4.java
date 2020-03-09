package com.hanqingyang.juc.completeableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample4
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/16  15:26
 * @Version 1.0
 **/
public class CompletableFutureExample4 {

    public static void main(String[] args) throws InterruptedException {
//        thenAcceptBoth();
//        acceptEither();
//        combine();
        compose();
        Thread.currentThread().join();
    }

    private static void compose(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("start compose1");
            sleep(5);
            System.out.println("end compose1");
            return "compose1";
        }).thenCompose(s -> CompletableFuture.supplyAsync(()->{
            System.out.println("start compose2");
            sleep(5);
            System.out.println("end compose2");
            return s.length();
        })).thenAccept(System.out::println);
    }

    private static void combine(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("start combine1");
            sleep(5);
            System.out.println("end combine1");
            return "combine1";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            System.out.println("start combine2");
            sleep(5);
            System.out.println("end combine2");
            return 100;
        }),(v,i)->v.length()+i).whenComplete((v,t)-> System.out.println(v));
    }

    private static void acceptEither(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("start acceptEither1");
            sleep(5);
            System.out.println("end acceptEither1");
            return "acceptEither1";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            System.out.println("start acceptEither2");
            sleep(5);
            System.out.println("end acceptEither2");
            return "acceptEither2";
        }),System.out::println);
    }

    private static void thenAcceptBoth(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("start supplyAsync");
            sleep(5);
            System.out.println("end supplyAsync");
            return "thenAcceptBoth";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            System.out.println("start thenAcceptBoth");
            sleep(5);
            System.out.println("end thenAcceptBoth");
            return 100;
        }),(v,t)-> System.out.println(v+"-" + t));
    }


    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
