package com.hanqingyang.concurrent.chapter17;

import java.util.Random;

/**
 * @ClassName TransportThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/20  17:02
 * @Version 1.0
 **/
public class TransportThread extends Thread {

    private final Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name,Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; true; i++) {
                Request request = new Request(getName(),i);
                this.channel.put(request);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (Exception e){
            
        }
    }
}
