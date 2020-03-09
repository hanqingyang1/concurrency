package com.hanqingyang.concurrent.chapter6;

/**
 * @ClassName ReadWriteLockClient
 * @Author 韩清阳
 * @Description //
 * @Date 2019/10/30  14:09
 * @Version 1.0
 **/
public class ReadWriteLockClient {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData,"faksjfkasdjfkdladj").start();
        new WriterWorker(sharedData,"FAKSJFKASDJFKDLADJ").start();
    }
}
