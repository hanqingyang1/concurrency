package com.hanqingyang.concurrent.chapter9;

import java.util.LinkedList;

/**
 * @ClassName RequestQueue
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  16:52
 * @Version 1.0
 **/
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest(){
        synchronized(queue){
            while(queue.size() <= 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
            return queue.removeFirst();
        }
    }

    public void addRequest(Request request){
        synchronized(queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
