package com.hanqingyang.juc.completeableFuture;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName CompleteableFutureExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/15  14:56
 * @Version 1.0
 **/
public class CompleteableFutureExample {

    public static void main(String[] args) throws InterruptedException {

        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executorService).whenComplete((v,t)->System.out.println("DONE"));

        System.out.println("i am is done");
        executorService.shutdown();
        Thread.currentThread().join();*/



        /*ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (!future.isDone()){

        }
        System.out.println("DONE");
        executorService.shutdown();*/


/*        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = IntStream.range(0, 10).boxed().map(i -> (Callable<Integer>) () -> get()).collect(toList());
        executorService.invokeAll(callableList).stream().map(future -> {
            try {
                return future.get();
            }catch (Exception e) {
                throw new RuntimeException();
            }
        }).parallel().forEach(CompleteableFutureExample::diplay);*/

        IntStream.range(0,10).boxed().forEach(i -> CompletableFuture.supplyAsync(CompleteableFutureExample::get)
                                                                    .thenAccept(CompleteableFutureExample::diplay)
                .whenComplete((v,t)->System.out.println(i +" DONE"))
        );
        Thread.currentThread().join();

    }

    private static void diplay(int data){
        int value = ThreadLocalRandom.current().nextInt(20);

        try {
            System.out.println(Thread.currentThread().getName() + "  get will be sleep" +value);
            TimeUnit.SECONDS.sleep(value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  get  execute done "+data);
    }


    private static int get(){
        int value = ThreadLocalRandom.current().nextInt(20);

        try {
            System.out.println(Thread.currentThread().getName() + " will be sleep" +value);
            TimeUnit.SECONDS.sleep(value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " execute done "+value);
        return value;
    }
}
