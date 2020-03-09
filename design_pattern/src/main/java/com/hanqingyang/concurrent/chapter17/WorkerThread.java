package com.hanqingyang.concurrent.chapter17;

import java.util.Random;

/**
 * @ClassName WorkerThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/20  8:43
 * @Version 1.0
 **/
public class WorkerThread extends Thread {

    private final Channel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
