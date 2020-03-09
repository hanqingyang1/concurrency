package com.hanqingyang.concurrency.chapter4;

import java.util.Optional;

/**
 * @ClassName ThreadSimpleApi
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  15:39
 * @Version 1.0
 **/
public class ThreadSimpleApi {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        thread.start();
        Optional.of(thread.getName()).ifPresent(System.out::println);
        Optional.of(thread.getId()).ifPresent(System.out::println);
        Optional.of(thread.getPriority()).ifPresent(System.out::println);
    }
}
