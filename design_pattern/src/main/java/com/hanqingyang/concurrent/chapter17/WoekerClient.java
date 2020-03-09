package com.hanqingyang.concurrent.chapter17;

/**
 * @ClassName WoekerClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/21  8:40
 * @Version 1.0
 **/
public class WoekerClient {

    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();
        new TransportThread("han",channel).start();
        new TransportThread("qing",channel).start();
        new TransportThread("yang",channel).start();
    }
}
