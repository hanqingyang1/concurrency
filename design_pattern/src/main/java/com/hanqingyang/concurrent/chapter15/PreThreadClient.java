package com.hanqingyang.concurrent.chapter15;

import java.util.stream.IntStream;

/**
 * @ClassName PreThreadClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/15  9:13
 * @Version 1.0
 **/
public class PreThreadClient {

    public static void main(String[] args) throws InterruptedException {
         MessageHandler messageHandler = new MessageHandler();

         IntStream.rangeClosed(0,10).forEach(i ->{
             messageHandler.request(new Message(String.valueOf(i)));
         });
         messageHandler.shutdown();
    }



}
