package com.hanqingyang.juc.completableFuture2;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName CompletableFutureExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/3/9  13:20
 * @Version 1.0
 **/
public class CompletableFutureExample1 {

    public static void main(String[] args) throws InterruptedException {
/*        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> future =executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (!future.isDone()){

        }
        //线程执行结束后打印
        System.out.println("DONE");*/

        /*
        *
         * @Author 韩清阳
         * @Description  异步执行一个runnable
         * @Date  2020/3/9  13:37
         * @Param [args]
         * @return void
         *
         *  runAsync(Runnable runnable) //异步执行一个runnable
         *  runAsync(Runnable runnable,Executor executor)
         **/
/*        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,t)->{//v 上一步返回值 t ：返回的异常
            System.out.println("DONE");
            t.printStackTrace();
            t.getMessage();
            System.out.println(v);
        });
        System.out.println("CompletableFuture,不置顶Executor的的话 线程为守护线程不会block ，主线程结束，守护线程就会立即结束");

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                int i = 1/0;
//                System.out.println("异常之后");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, executorService).whenComplete((v, t)->{//v 上一步返回值 t ：返回的异常
//
//            System.out.println("DONE");
//            t.printStackTrace();
//            System.out.println(t.getMessage());
//            System.out.println(v);
//        });
//        System.out.println("CompletableFuture,不置顶Executor的的话 线程为守护线程不会block ，主线程结束，守护线程就会立即结束");
//        executorService.shutdown();


        /*
        *
         * @Author 韩清阳
         * @Description  使用executorService。invokeAll顺序执行，future.get()要全部执行完才能执行下一步display
         * （不能执行完一个直接执行这个的下一步，要等到全部执行完再能一起开始下一步）
         * 需要使用CompletableFuture解决这个问题
         * @Date  2020/3/9  21:12
         * @Param [args]
         * @return void
         **/
      /*  ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = IntStream.range(0, 10).boxed()
                .map(i -> (Callable<Integer>) () -> get())
                .collect(Collectors.toList());

        executorService.invokeAll(callableList).stream().map(future -> {
            try {
                //需要全部执行完get（），全部返回上一步的所有结果后才能执行下一步 display方法，
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).parallel().forEach(CompletableFutureExample1::display);*/

      /*
      *
       * @Author 韩清阳
       * @Description
        *
        * 使用completableFuture解决上面的问题，执行完一个不需要等其他的执行完直接执行当前任务的下一步
        *
        * runAsync(Runnable runnable)	使用ForkJoinPool.commonPool()作为它的线程池执行异步代码。
       * runAsync(Runnable runnable, Executor executor)	使用指定的thread pool执行异步代码。
       *
       *supplyAsync 方法接受一个生产者（Supplier）作为参数，返回一个 CompletableFuture对象。
       * 生产者方法会交由 ForkJoinPool池中的某个执行线程（ Executor ）运行，但是你也可以使用 supplyAsync 方法的重载版本，
       * 传递第二个参数指定线程池执行器执行生产者方法。
       *
       * thenApply当前阶段正常完成以后执行，而且当前阶段的执行的结果会作为下一阶段的输入参数。
       * thenApplyAsync默认是异步执行的。这里所谓的异步指的是不在当前线程内执行。
       *
       * 可以看到，thenAccept和thenRun都是无返回值的。如果说thenApply是不停的输入输出的进行生产，那么thenAccept和thenRun就是在进行消耗。
       * 它们是整个计算的最后两个阶段。同样是执行指定的动作，同样是消耗，二者也有区别：
       * thenAccept接收上一阶段的输出作为本阶段的输入 　　
       * thenRun根本不关心前一阶段的输出，根本不不关心前一阶段的计算结果，因为它不需要输入参数
       * @Date  2020/3/9  21:16
       * @Param [args]
       * @return void
       **/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
      IntStream.range(0,10).boxed()
              .forEach(i -> CompletableFuture.supplyAsync(CompletableFutureExample1::get,executorService)
                      //thenAccept接收上一阶段的输出作为本阶段的输入 　　
//              .thenAccept(j -> CompletableFutureExample1.display(j))
                      .thenAccept(CompletableFutureExample1::display)
                      //执行结束输出
              .whenComplete((v,t)-> System.out.println(i + "DONE")));

//            Thread.currentThread().join();
        executorService.shutdown();
    }

    private static void display(int data){

        int value = ThreadLocalRandom.current().nextInt(20);

        try {
            System.out.println(Thread.currentThread().getName() + "display will be sleep"+ value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"display execute done" + data);
    }

    private static int get(){
        int value = ThreadLocalRandom.current().nextInt(20);

        try {
            System.out.println(Thread.currentThread().getName() + "get will be sleep"+ value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"get execute done" + value);
        return value;
    }
}
