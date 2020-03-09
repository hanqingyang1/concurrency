package com.hanqingyang.concurrent.chapter14;

/**
 * @ClassName CountDown
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/14  9:01
 * @Version 1.0
 **/
public class CountDown {
    private final int total;

    private int counter = 0;
    public CountDown(int total) {
        this.total = total;
    }

    private void down(){
        synchronized(this){
            counter++;
            this.notifyAll();
        }
    }
    private void await() throws InterruptedException {
        synchronized(this){
            while(counter != total){
                this.wait();
            }
        }
    }
}
