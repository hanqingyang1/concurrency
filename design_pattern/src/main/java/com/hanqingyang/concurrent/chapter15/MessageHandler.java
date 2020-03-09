package com.hanqingyang.concurrent.chapter15;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MessageHandler
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/15  9:06
 * @Version 1.0
 **/
public class MessageHandler {

    private final static Random random = new Random(System.currentTimeMillis());

    //使用executor 线程池

    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message){

        executor.execute(() ->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("the message well be handler by"+Thread.currentThread().getName() + "  " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


    }

    public void shutdown() throws InterruptedException {
        ((ExecutorService)executor).shutdown();
        while(!((ExecutorService)executor).awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("还有任务在执行");
        }
    }

/*    public void request(Message message){
        new Thread(() -> {
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("the message well be handler by"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }*/
}
