package com.hanqingyang.concurrency.chapter6;

/**
 * @ClassName ThreadCloseGraceful
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/9  19:34
 * @Version 1.0
 **/
public class ThreadCloseGraceful {

    private static class Worker extends Thread{
        private volatile boolean start = true;
        @Override
        public void run() {
            while (start){

            }
        }
        public void shutdown(){
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }
}
