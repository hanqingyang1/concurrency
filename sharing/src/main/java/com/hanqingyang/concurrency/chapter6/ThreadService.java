package com.hanqingyang.concurrency.chapter6;

/**
 * @ClassName ThreadService
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/9  20:35
 * @Version 1.0
 **/
public class ThreadService {
    private Thread executeThread;
    private  boolean finshed = false;

    public void excute(Runnable task){
        executeThread = new Thread(){
            @Override
            public  void run(){
                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();

                try {
                    thread.join();
                    finshed = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        executeThread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public void shutdown(long miils){
        long currentTime = System.currentTimeMillis();
        while (!finshed){
            if(System.currentTimeMillis() - currentTime >= miils){
                System.out.println("任务超时需要结束");
                executeThread.interrupt();
                break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
        finshed = false;
    }

}
