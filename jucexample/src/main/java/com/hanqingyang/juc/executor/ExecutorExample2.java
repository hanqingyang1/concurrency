package com.hanqingyang.juc.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName ExecutorExample2
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/13  16:31
 * @Version 1.0
 **/
public class ExecutorExample2 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callableList = IntStream.range(0, 20).boxed().map(i ->
                (Callable<String>) () -> {
                    System.out.println(Thread.currentThread().getName() );
                    sleep(2);
                    return "Task-" + i;
                }
        ).collect(Collectors.toList());


        List<Future<String>> futures = executorService.invokeAll(callableList);
        futures.stream().forEach(future ->{
            try {
                String s = future.get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
    }

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
