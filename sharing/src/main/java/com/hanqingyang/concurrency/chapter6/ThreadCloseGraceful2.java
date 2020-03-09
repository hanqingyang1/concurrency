package com.hanqingyang.concurrency.chapter6;

/**
 * @ClassName ThreadCloseGraceful
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/9  19:34
 * @Version 1.0
 **/
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread{
        @Override
        public void run() {
                while(true){
                   if(Thread.interrupted()){
                       break;
                   }
                }
            }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
