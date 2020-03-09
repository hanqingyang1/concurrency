package com.hanqingyang.juc.completeableFuture;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/15  16:11
 * @Version 1.0
 **/
public class CompletableFutureExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        supplyAsync();
//        Future<?> future = runAsync();
//        future.get();

//        Future<Void> future = completed("hello");
//        System.out.println(future.isDone());

//        System.out.println(anyOf().get());
        allOf();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void allOf(){
        CompletableFuture.allOf(CompletableFuture.runAsync(()->{
            try {
                System.out.println("1=========== start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("1=========== end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)-> System.out.println(v+ "=========over=======")),

                CompletableFuture.supplyAsync(()->{
                    try {
                        System.out.println("2============start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("2============ end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello";
                }).whenComplete((v,t)-> System.out.println(v + "================over========"))
        );
    }

    private static Future<?> anyOf() {
      return CompletableFuture.anyOf(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("1======= start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("1 ========= end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v, t) -> System.out.println("=======voer=======")),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("2============== start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("2 ============== end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello";
                }).whenComplete((v, t) -> System.out.println("=======over======"))
       );
    }


    private static Future<Void> completed(String data){
        return CompletableFuture.completedFuture(data).thenAccept(System.out::println);
    }

    private static Future<?> runAsync(){
       return CompletableFuture.runAsync(()->{
            try {
                System.out.println("obj ==== start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("obj ===== end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)-> System.out.println("=======over======"));
    }

    public static void supplyAsync() {
        CompletableFuture.supplyAsync(Object::new).thenAccept(obj -> {
            try {
                System.out.println("obj  start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("obj end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> "Hello").thenAcceptAsync(s -> {
            try {
                System.out.println("String   start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("String " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), () -> System.out.println("=====finished========"));
    }

    private static void supplyAsync2() {
        CompletableFuture.supplyAsync(Object::new)
                .thenAccept(obj -> {
                    try {
                        System.out.println("obj start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("obj " + obj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).runAfterBoth(CompletableFuture.supplyAsync(() -> "Hello word")
                .thenAccept(s -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        }), () -> System.out.println("=====finished======"));
    }
}
