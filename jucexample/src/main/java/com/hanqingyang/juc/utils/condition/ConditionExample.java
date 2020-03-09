package com.hanqingyang.juc.utils.condition;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  8:41
 * @Version 1.0
 **/
public class ConditionExample {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static int data = 0;

    private static boolean noUse = true;

    public static void buildData(){
        try {
            lock.lock();
            while(noUse){
                condition.await();
            }
            data++;
            Optional.of("P"+data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
            noUse =true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void take(){
        try{
            lock.lock();
            while(!noUse){
                condition.await();
            }
//            data --;
            noUse = false;
            TimeUnit.SECONDS.sleep(1);
            Optional.of("C"+data).ifPresent(System.out::println);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            for(;;){
                buildData();
            }
        }).start();
        new Thread(()->{
            for(;;){
                take();
            }
        }).start();
    }
}
