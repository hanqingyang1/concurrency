package com.hanqingyang.concurrent.chapter13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ConsumerThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/13  13:44
 * @Version 1.0
 **/
public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;

    private final static Random random = new Random(System.currentTimeMillis());
    public ConsumerThread(MessageQueue messageQueue, int seq){
        super("COMSUMER - "+seq);
        this.messageQueue= messageQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + "get message "+message);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
