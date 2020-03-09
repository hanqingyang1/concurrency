package com.hanqingyang.juc.utils.condition;

import javax.management.monitor.Monitor;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ComBetweenThread
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  11:34
 * @Version 1.0
 **/
public class ComBetweenThread {

    private static  int data = 0;

    private static final Object MONITOR = new Object();

    private static boolean noUse = false;
    public  static void producer(){
        synchronized(MONITOR) {
            while (noUse) {
                try {

                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of("P=>" +data).ifPresent(System.out::println);
            noUse = true;
            MONITOR.notifyAll();
        }

    }

    public  static void consumer(){
        synchronized(MONITOR) {
            while (!noUse) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of("C=>"+data).ifPresent(System.out::println);
            noUse = false;
            MONITOR.notifyAll();
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            for (;;)
                producer();
        }).start();

        new Thread(()->{
            for (;;)
                consumer();
        }).start();
    }
}
