package com.hanqingyang.concurrent.chapter9;

import java.util.Random;

/**
 * @ClassName ClientThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/31  9:21
 * @Version 1.0
 **/
public class ClientThread extends Thread{

    private final RequestQueue queue;

    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQueue queue,String sendValue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
        this.sendValue = sendValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Client Thread "+ sendValue);
            queue.addRequest(new Request(sendValue));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
