package com.hanqingyang.concurrency.chapter7;


/**
 * @ClassName Bank2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/5  20:23
 * @Version 1.0
 **/
public class Bank2 {
    public static void main(String[] args) {
        TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(ticketWindowRunnable, "一号窗口");
        Thread thread2 = new Thread(ticketWindowRunnable, "二号窗口");
        Thread thread3 = new Thread(ticketWindowRunnable, "三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
