package com.hanqingyang.concurrency.chapter6;

/**
 * @ClassName ThreadInterrupt
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/7  16:49
 * @Version 1.0
 **/
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        thread.start();

            Thread.sleep(100);

        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
