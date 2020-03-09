package com.hanqingyang.concurrency.chapter7;

/**
 * @ClassName TicketWindow
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/5  19:47
 * @Version 1.0
 **/
public class TicketWindow extends Thread {

    private static final Integer MAX = 50;

    private static  Integer index = 1;

    private String name;

    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run() {

        synchronized (this) {
            while (index <= MAX){
                System.out.println("柜台 ： "+name + "  当前号为 " + index++);
            }
        }
    }
}
