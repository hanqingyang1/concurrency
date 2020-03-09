package com.hanqingyang.concurrency.chapter7;

/**
 * @ClassName SynchronizedRunnable
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/10  19:51
 * @Version 1.0
 **/
public class SynchronizedRunnable implements Runnable{

    private static final Integer MAX = 500;

    private  int index = 1;

    private final Object MONITOR = new Object();

    public  void run() {
        while (true) {
            if (ticket()) {
                break;
            }
        }
    }

    public synchronized boolean ticket(){
        if(index > MAX)
            return true;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "当前号为 : " + index++);
        return false;
    }
}
