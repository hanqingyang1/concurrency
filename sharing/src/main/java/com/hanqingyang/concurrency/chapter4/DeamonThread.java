package com.hanqingyang.concurrency.chapter4;

/**
 * @ClassName DeamonThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  13:58
 * @Version 1.0
 **/
public class DeamonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" running..");
                    Thread.sleep(100000);
                    System.out.println(Thread.currentThread().getName()+" done..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
