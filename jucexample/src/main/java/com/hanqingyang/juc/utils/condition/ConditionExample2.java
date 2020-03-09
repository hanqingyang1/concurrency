package com.hanqingyang.juc.utils.condition;

import java.sql.Time;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionExample2
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  14:34
 * @Version 1.0
 **/
public class ConditionExample2 {

    private static final Lock lock  = new ReentrantLock();
    private static final Condition PRODUCE_COND = lock.newCondition();
    private static final Condition CONSUME_COND = lock.newCondition();

    private static LinkedList<Long> queue = new LinkedList<>();

    private static final int MAX_CAPACITY = 100;

    public static void producer(){
        lock.lock();
        try {
            while (queue.size() >= MAX_CAPACITY) {
                    PRODUCE_COND.await();
            }
            TimeUnit.SECONDS.sleep(1);
            long value = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " 生产 " + value);
            queue.addLast(value);
            CONSUME_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }


    public static void consumer(){
        lock.lock();
        try{
            while(queue.size()<= 0){
                CONSUME_COND.await();
            }
            TimeUnit.SECONDS.sleep(1);
            Long value = queue.removeFirst();
            System.out.println(Thread.currentThread().getName() + " 消费 " +value);
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
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
