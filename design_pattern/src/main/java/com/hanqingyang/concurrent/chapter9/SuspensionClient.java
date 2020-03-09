package com.hanqingyang.concurrent.chapter9;

/**
 * @ClassName SuspensionClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/1  8:59
 * @Version 1.0
 **/
public class SuspensionClient {
    public static void main(String[] args) {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"AKXJS").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverThread.close();
    }
}
