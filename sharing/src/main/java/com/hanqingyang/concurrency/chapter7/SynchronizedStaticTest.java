package com.hanqingyang.concurrency.chapter7;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @ClassName SynchronizedStaticTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/10  20:26
 * @Version 1.0
 **/
public class SynchronizedStaticTest {
    public static void main(String[] args) {
        new Thread("T1"){
            @Override
            public void run() {
                SynchronizedStatic.m1();
            }
        }.start();


        new Thread("T2"){
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                SynchronizedStatic.m3();
            }
        }.start();
    }
}
