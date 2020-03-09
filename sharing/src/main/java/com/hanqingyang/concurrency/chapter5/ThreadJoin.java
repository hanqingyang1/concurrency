package com.hanqingyang.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @ClassName ThreadJoin
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  16:06
 * @Version 1.0
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + "-> " + i));
        });
        Thread thread1 = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + "-> " + i));
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        Optional.of("所有线程执行结束").ifPresent(System.out::println);

        IntStream.range(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> "+ i));
    }
}
