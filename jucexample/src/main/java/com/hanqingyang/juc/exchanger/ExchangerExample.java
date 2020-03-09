package com.hanqingyang.juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName ExchangerExample
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/18  8:53
 * @Version 1.0
 **/
public class ExchangerExample {

    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(()->{
            AtomicReference<Integer> value = new AtomicReference<>(1);
            try {
                while(true){
                    value.set(exchanger.exchange(value.get()));
                    System.out.println("The Thread A has Value " + value.get());
                    TimeUnit.SECONDS.sleep(3);
                }
            }catch (Exception e){

            }
        },"==A==").start();

        new Thread(()->{
            AtomicReference<Integer> value = new AtomicReference<>(2);
            try {
                while(true){
                    value.set(exchanger.exchange(value.get()));
                    System.out.println(" The Thread B has Value "+ value.get());
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"==B==").start();

    }
}
