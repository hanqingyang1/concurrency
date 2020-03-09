package com.hanqingyang.concurrency.chapter7;


/**
 * @ClassName TicketWindowRunnable
 * @Author 韩清阳
 * @Description //
 * @Date 2019/9/5  20:20
 * @Version 1.0
 **/
public class TicketWindowRunnable implements Runnable {

    private static final Integer MAX = 500;

    private  int index = 1;

    private final Object MONITOR = new Object();

    public void run() {
        synchronized(MONITOR){
        while(true) {
            if (index > MAX) {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "当前号为" + index++);
        }
        }
    }
}
