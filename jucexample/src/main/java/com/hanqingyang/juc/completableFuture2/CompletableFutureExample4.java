package com.hanqingyang.juc.completableFuture2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample4
 * @Author 韩清阳
 * @Description
 * @Date 2020/3/10  16:06
 * @Version 1.0
 **/
public class CompletableFutureExample4 {


    public static void main(String[] args) throws InterruptedException {
//        thenAcceptBoth();
//        acceptEither();
//        runAfterBoth();
//        runAfterEither();
//        combine();
        compose();
        Thread.currentThread().join();
    }


    /*
    *
     * @Author 韩清阳
     * @Description  thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作。
     * 执行结果
     * 开始执行 compose1
     * compose1 执行结束
     * 开始执行 compose2
     * compose2 执行结束
     * 8
     * @Date  2020/3/10  18:31
     * @Param []
     * @return void
     **/
    private static void compose(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 compose1");
            sleep(5);
            System.out.println("compose1 执行结束");
            return "compose1";
        }).thenCompose(s->CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 compose2");
            sleep(5);
            System.out.println("compose2 执行结束");
            return s.length();
        })).thenAccept(System.out::println);
    }

    /*
    *
     * @Author 韩清阳
     * @Description  thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
     * 执行结果：(s,i)->s.length()>i  s为 第一个completableFuture的返回值    i 为第二个completableFuture的返回值
     * 开始执行 combine1
     * 开始执行 combine2
     * combine2 执行结束
     * combine1 执行结束
     * false
     * @Date  2020/3/10  16:58
     * @Param []
     * @return void
     **/
    private static void combine(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 combine1");
            sleep(5);
            System.out.println("combine1 执行结束");
            return "combine1";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 combine2");
            sleep(5);
            System.out.println("combine2 执行结束");
            return 100;
        }),(s,i)->s.length()>i).whenComplete((v,t)-> System.out.println(v));
    }


    /*
    *
     * @Author 韩清阳
     * @Description  runAfterEither: 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）
     * 执行结果
     *开始执行 runAfterEither1
     * 开始执行 runAfterEither2
     * runAfterEither2 执行结束
     * DONE
     * runAfterEither1 执行结束
     * @Date  2020/3/10  16:49
     * @Param []
     * @return void
     **/
    private static void runAfterEither(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 runAfterEither1");
            sleep(5);
            System.out.println("runAfterEither1 执行结束");
            return "runAfterEither1";
        }).runAfterEitherAsync(CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 runAfterEither2");
            sleep(3);
            System.out.println("runAfterEither2 执行结束");
            return "runAfterEither2";
        }),()-> System.out.println("DONE"));
    }

    /*
    *
     * @Author 韩清阳
     * @Description  runAfterBoth :两个CompletionStage，都完成了计算才会执行下一步的操作（Runnable）无返回值
     *执行结果
     * 开始执行 runAfterBoth1
     * 开始执行 runAfterBoth2
     * runAfterBoth2 执行结束
     * runAfterBoth1 执行结束
     * DONE
     * @Date  2020/3/10  16:44
     * @Param []
     * @return void
     **/
    private static void runAfterBoth(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 runAfterBoth1");
            sleep(5);
            System.out.println("runAfterBoth1 执行结束");
            return "runAfterBoth1";
        }).runAfterBothAsync(CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 runAfterBoth2");
            sleep(5);
            System.out.println("runAfterBoth2 执行结束");
            return "runAfterBoth2";
        }),()-> System.out.println("DONE"));
    }


    /*
    *
     * @Author 韩清阳
     * @Description  两个completableFuture的返回值要求必须一样，返回其中的一个
     * 执行结果：两个都会执行，但只返回其中一个的结构，应该是最先完成的那个的结果
     * 开始执行 supplyAsync
     * 开始执行 acceptEither
     * supplyAsync 执行结束
     * acceptEither 执行结束
     * thenAcceptAsync*******
     * @Date  2020/3/10  16:34
     * @Param []
     * @return void
     **/
    private static void acceptEither(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 supplyAsync");
            sleep(5);
            System.out.println("supplyAsync 执行结束");
            return "thenAcceptAsync";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 acceptEither");
            sleep(5);
            System.out.println("acceptEither 执行结束");
            return "100";
        }),(s)->{
            System.out.println(s+"*******");
        });
    }

    /*
    *
     * @Author 韩清阳
     * @Description  当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
     *
     * 执行结果
     * 开始执行 supplyAsync
     * 开始执行 thenAcceptBoth
     * supplyAsync 执行结束
     * thenAcceptBoth 执行结束
     * thenAcceptAsync*******  s:第一个completablefuture的返回结果
     * 100*******   i: 第二个completableFuture返回的结果
     * @Date  2020/3/10  16:21
     * @Param []
     * @return void
     **/
    private static void thenAcceptBoth(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 supplyAsync");
            sleep(5);
            System.out.println("supplyAsync 执行结束");
            return "thenAcceptAsync";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行 thenAcceptBoth");
            sleep(5);
            System.out.println("thenAcceptBoth 执行结束");
            return 100;
        }),(s,i)->{
            System.out.println(s+"*******");
            System.out.println(i+"*******");
        });
    }

    /*
    *
     * @Author 韩清阳
     * @Description  休眠
     * @Date  2020/3/10  16:08
     * @Param [seconds]
     * @return void
     **/
    private static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
