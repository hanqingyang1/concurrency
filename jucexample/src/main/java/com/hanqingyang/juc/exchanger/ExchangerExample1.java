package com.hanqingyang.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @ClassName ExchangerExample1
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/17  9:00
 * @Version 1.0
 **/
public class ExchangerExample1 {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "  start .");
            try {
                String result = exchanger.exchange("I am thread a");
                System.out.println(Thread.currentThread().getName()+" GET VALUE" +result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "   end .");
        },"==A==").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "  start .");
            try {
                String result = exchanger.exchange("I am thread b");
                System.out.println(Thread.currentThread().getName()+" GET VALUE" +result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "   end .");
        },"==B==").start();
    }
}
