package com.hanqingyang.concurrency.chapter4;

/**
 * @ClassName DeamonThread2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  14:26
 * @Version 1.0
 **/
public class DeamonThread2 {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                        while (true){
                            System.out.println("内部现成正在监听心跳");
                            Thread.sleep(1000);
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                System.out.println("线程结束");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //thread.setDaemon(true);
        System.out.println("");
        thread.start();
    }
}
