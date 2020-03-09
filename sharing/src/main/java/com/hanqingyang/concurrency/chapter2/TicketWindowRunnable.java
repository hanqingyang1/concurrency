package com.hanqingyang.concurrency.chapter2;


/**
 * @ClassName TicketWindowRunnable
 * @Author 韩清阳
 * @Description //
 * @Date 2019/9/5  20:20
 * @Version 1.0
 **/
public class TicketWindowRunnable implements Runnable {

    private static final Integer MAX = 50;

    private static int index = 1;


    public void run() {
        while(index <= MAX){
            System.out.println(Thread.currentThread() + "当前号为" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
