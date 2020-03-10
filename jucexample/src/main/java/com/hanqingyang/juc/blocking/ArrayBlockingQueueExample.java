package com.hanqingyang.juc.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName ArrayBlockingQueueExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/17  14:56
 * @Version 1.0
 **/
public class ArrayBlockingQueueExample {
    public static void main(String[] args) {

    }


    public <T>ArrayBlockingQueue<T> create(int size){
        return new ArrayBlockingQueue<>(size);
    }
}
