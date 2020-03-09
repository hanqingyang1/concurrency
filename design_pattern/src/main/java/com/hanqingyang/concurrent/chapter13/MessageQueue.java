package com.hanqingyang.concurrent.chapter13;

import java.util.LinkedList;

/**
 * @ClassName MessageQueue
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/13  9:15
 * @Version 1.0
 **/
public class MessageQueue {

    private final LinkedList<Message> queue;

    private final static int DEFAULT_MAX_LIMIT = 100;

    private final int limit;

    public MessageQueue() {
       this(DEFAULT_MAX_LIMIT);
    }

    public MessageQueue(final int limit){
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public void put(Message message){
        synchronized(queue){
            while(queue.size() > limit){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public  Message take(){
        synchronized(queue){
            while(queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }
    public int getMaxLimit(){
        return this.limit;
    }

    public int getMessageQueue(){
        synchronized(queue){
            return queue.size();
        }
    }
}
