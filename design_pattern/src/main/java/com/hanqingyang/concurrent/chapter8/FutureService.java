package com.hanqingyang.concurrent.chapter8;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.function.Consumer;

/**
 * @ClassName FutureService
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  15:19
 * @Version 1.0
 **/
public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task){
        AsynFuture<T> asynFuture = new AsynFuture();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
