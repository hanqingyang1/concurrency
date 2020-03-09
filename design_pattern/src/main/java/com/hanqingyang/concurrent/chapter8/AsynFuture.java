package com.hanqingyang.concurrent.chapter8;

/**
 * @ClassName AsynFuture
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  15:26
 * @Version 1.0
 **/
public class AsynFuture<T> implements Future<T> {

    private volatile boolean done = false;

    private T result;

    public void done(T result){
        synchronized(this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized(this){
            while(!done){
                this.wait();
            }
        }
        return result;
    }
}
