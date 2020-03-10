package com.hanqingyang.juc.completableFuture2;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample2
 * @Author 韩清阳
 * @Description
 * @Date 2020/3/10  8:57
 * @Version 1.0
 **/
public class CompletableFutureExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        supplyAsync();
//        Future<?> future = runAsync();
//        System.out.println(future.get());
//        completed("hello");
//        System.out.println(anyof().get()+"***");
        allof();
        Thread.currentThread().join();
    }


    /*
    *
     * @Author 韩清阳
     * @Description  allof 全都执行，可同时执行多个CompletableFuture
     * 执行结果
     * 1 all =============== start
     * 2 all =============== start
     * 2 all ============= end
     * Hello =======over=====
     * =1 all ============= end
     * =======over=======
     * @Date  2020/3/10  14:22
     * @Param []
     * @return void
     **/
    private static void allof(){
        CompletableFuture.allOf(CompletableFuture.runAsync(()->{
            try {
                System.out.println("1 all =============== start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("1 all ============= end");
                //有异常情况下 需要使用future.get()获取
//                int i= 1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)-> System.out.println("=======over=======")),
                CompletableFuture.supplyAsync(()->{
                    try {
                        System.out.println("2 all =============== start");
                        TimeUnit.SECONDS.sleep(4);
                        System.out.println("2 all ============= end");
                        //有异常情况下 需要使用future.get()获取
//                int i= 1/0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Hello";
                }).whenComplete((v,t)-> System.out.println(v + " =======over======")));
    }

    /*
    *
     * @Author 韩清阳
     * @Description  两个异步方法都同时执行，但仅返回其中一个的执行结果
     * * 执行结果
     * 1 all =============== start
     * 2 all =============== start
     * 2 all ============= end
     * Hello =======over=====
     * Hello***
     * =1 all ============= end
     * =======over=======
     * @Date  2020/3/10  14:13
     * @Param []
     * @return java.util.concurrent.Future<?>
     **/
    private  static Future<?> anyof(){
       return CompletableFuture.anyOf( CompletableFuture.runAsync(()->{
            try {
                System.out.println("1 =============== start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("1 ============= end");
                //有异常情况下 需要使用future.get()获取
//                int i= 1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)-> System.out.println("======over=======")),
        CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("2 =============== start");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("2 ============= end");
                //有异常情况下 需要使用future.get()获取
//                int i= 1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).whenComplete((v,t)-> System.out.println(v + "  =====over======")));
    }


    /*
    *
     * @Author 韩清阳
     * @Description  completedFuture:队已完成的数据直接进行下一步处理，
     * 执行结果：
     * helloworld
     * @Date  2020/3/10  14:03
     * @Param [data]
     * @return void
     **/
    private static void completed(String data){
        CompletableFuture.completedFuture(data).thenApply(s -> {
            return  s+"world";
        }).whenComplete((v,t)-> System.out.println(v));
    }

//    private static void completed(List<String> data){
//        data.stream().forEach(i ->CompletableFuture.supplyAsync(()->i));
//    }



    /*
    *
     * @Author 韩清阳
     * @Description  异步执行一个runnable 执行结束后返回一个 over
     * Future<?> future = runAsync();
     * 执行结果
     * obj =============== start
     * obj ============= end
     * ====over==
     * null： System.out.println(future.get());的返回值,  如果有异常 future.get（）会返回抛出的异常，如果不调用不会返回异常
     * @Date  2020/3/10  13:32
     * @Param []
     * @return java.util.concurrent.Future<?>
     **/
    private static Future<?> runAsync() {
        return CompletableFuture.runAsync(()->{
            try {
                System.out.println("obj =============== start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("obj ============= end");
                //有异常情况下 需要使用future.get()获取
                int i= 1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //v  ： 返回值     t： 返回的异常
        }).whenComplete((v,t)-> System.out.println("====over==="));
    }



    /*
    *
     * @Author 韩清阳
     * @Description
     * runAfterBoth 返回一个新的CompletionStage，当这个和另一个给定的阶段都正常完成时，执行给定的动作。
     * 假设有两个线程A和B，这两个线程都是异步执行的，但是不确定A和B何时执行完毕，但是需要在A和B都执行完毕后运行线程C c就是runAfterBoth中的runnable
     *thenAcceptAsync 改为thenAccept可变为顺序执行
     * 执行结果
     * obj =============== start
     * String  =============== start
     * obj ============= java.lang.Object@378bf50
     * String  ============= Hello
     * finished
     * @Date  2020/3/10  13:00
     * @Param []
     * @return void
     **/
    private static void supplyAsync(){
        CompletableFuture.supplyAsync(Object::new)
                .thenAcceptAsync(obj ->{
                    try {
                        System.out.println("obj =============== start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("obj ============= "+obj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).runAfterBoth(CompletableFuture.supplyAsync(()->"Hello")
                .thenAcceptAsync(s ->{
                    try {
                        System.out.println("String  =============== start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("String  ============= "+s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }),()-> System.out.println("finished"));
    }



}
