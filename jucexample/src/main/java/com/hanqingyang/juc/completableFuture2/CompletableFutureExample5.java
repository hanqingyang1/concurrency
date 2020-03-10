package com.hanqingyang.juc.completableFuture2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureExample5
 * @Author 韩清阳
 * @Description
 * @Date 2020/3/10  18:36
 * @Version 1.0
 **/
public class CompletableFutureExample5 {


    public static void main(String[] args) {

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
