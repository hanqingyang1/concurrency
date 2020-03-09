package com.hanqingyang.concurrent.chapter13;

/**
 * @ClassName ProducerConsumerClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/13  14:05
 * @Version 1.0
 **/
public class ProducerConsumerClient {
    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();


        new ProducerThread(messageQueue,1).start();
        new ConsumerThread(messageQueue,1).start();
    }
}
