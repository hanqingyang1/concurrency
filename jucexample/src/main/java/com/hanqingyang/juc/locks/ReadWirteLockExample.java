package com.hanqingyang.juc.locks;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReadWirteLockExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/9  8:39
 * @Version 1.0
 **/
public class ReadWirteLockExample {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static  Lock readLock = lock.readLock();
    private static  Lock writeLock = lock.writeLock();

    private static List<Long> data = new ArrayList<>();

    public static void main(String[] args) {

        /*Thread thread = new Thread(ReadWirteLockExample::write);
        thread.start();*/
        Thread thread2 = new Thread(ReadWirteLockExample::read);
        thread2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread(ReadWirteLockExample::read);
        thread1.start();
    }

    public static void write() {
        writeLock.lock();
        try {
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            writeLock.unlock();
        }
    }

    public static void read(){
        readLock.lock();
        try {
            data.forEach(System.out::println);
            System.out.println("++++++++++++++++");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            readLock.unlock();
        }
    }

}
