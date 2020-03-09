package com.hanqingyang.juc.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName ExecutorServiceExample4
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/14  14:04
 * @Version 1.0
 **/
public class ExecutorServiceExample4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        testInvokeAnyTimeOut();
//        testInvokeAll();
//        testSubmitRunnable();
        testSubmitRunnableWithResult();
    }

    private static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(
                i -> (Callable<Integer>) () -> {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
                    System.out.println(Thread.currentThread().getName() + "  : " + i);
                    return i;
                }
        ).collect(Collectors.toList());

        Integer integer = executorService.invokeAny(callableList);
        System.out.println(integer);
        System.out.println("===============finished=================");
    }



    private static void testInvokeAnyTimeOut() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(
                i -> (Callable<Integer>) () -> {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
                    System.out.println(Thread.currentThread().getName() + "   :  " + i);
                    return i;
                }
        ).collect(Collectors.toList());
        Integer value = executorService.invokeAny(callableList, 2, TimeUnit.SECONDS);
        System.out.println("====================finished====================");
    }

    private static void testInvokeAll() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 10).boxed().map(
                i -> (Callable<Integer>) () -> {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                    System.out.println(Thread.currentThread().getName() + "   : " + i);
                    return i;
                }
        ).collect(Collectors.toList());

        List<Future<Integer>> futures = executorService.invokeAll(callableList);
        futures.stream().map(future ->{
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                }
                ).forEach(System.out::println);
    }


    private static void testSubmitRunnable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(future.get());
    }

    private static void testSubmitRunnableWithResult() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String result = "done";
        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, result);
        System.out.println(future.get());
    }
}
