package com.hanqingyang.concurrency.chapter2;

/**
 * @ClassName Bank
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/5  20:00
 * @Version 1.0
 **/
public class Bank {
    public static void main(String[] args) {
        TicketWindow window1 = new TicketWindow("一号柜台");
        window1.start();
        TicketWindow window2 = new TicketWindow("二号柜台");
        window2.start();
        TicketWindow window3 = new TicketWindow("三号柜台");
        window3.start();
    }
}
