package com.hanqingyang.concurrent.chapter16;

import java.util.Random;

/**
 * @ClassName CounterIncrement
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/19  8:39
 * @Version 1.0
 **/
public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int counter = 0;

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
            try{
                while(!terminated){
                    System.out.println(Thread.currentThread().getName() + counter++);
                    Thread.sleep(random.nextInt(1000));
                }
            }catch (Exception e){
                //e.printStackTrace();
            }finally{
                this.clean();
            }
    }

    private void clean(){
        System.out.println("The Thread clean  ,  counter = " +counter);
    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
