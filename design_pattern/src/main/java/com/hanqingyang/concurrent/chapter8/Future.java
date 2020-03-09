package com.hanqingyang.concurrent.chapter8;

public interface Future<T> {

    T get() throws  InterruptedException;
}
