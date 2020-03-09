package com.hanqingyang.concurrent.chapter9;

import java.util.Random;

/**
 * @ClassName ServerThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/1  8:47
 * @Version 1.0
 **/
public class ServerThread extends Thread {
    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while(!flag){
            Request request = queue.getRequest();
            if(null == request){
                System.out.println("the request enpty");
                continue;
            }
            System.out.println("Server -> "+ request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close(){
        this.flag = true;
        this.interrupt();
    }
}
