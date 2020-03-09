package com.hanqingyang.concurrency.chapter6;

import javafx.concurrent.Worker;

/**
 * @ClassName ThreadCloseGraceful
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/9  19:34
 * @Version 1.0
 **/
public class ThreadCloseGraceful3 {



    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.excute(() -> {
            while (true){

            }
        });
        threadService.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }

}
