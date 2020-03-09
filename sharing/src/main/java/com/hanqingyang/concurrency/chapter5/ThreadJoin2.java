package com.hanqingyang.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @ClassName ThreadJoin2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  16:29
 * @Version 1.0
 **/
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread is running");
                Thread.sleep(10_000);
                System.out.println("thread id done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();
        thread.join(100);

        Optional.of("子线程执行结束").ifPresent(System.out::println);
        IntStream.range(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName()+ " -> "+ i));

    }
}
