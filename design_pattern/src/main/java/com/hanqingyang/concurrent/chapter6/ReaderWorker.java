package com.hanqingyang.concurrent.chapter6;

/**
 * @ClassName ReaderWorker
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  13:55
 * @Version 1.0
 **/
public class ReaderWorker extends  Thread {

    private final SharedData data;
    public ReaderWorker(SharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true){
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads "+ String.valueOf(readbuf));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
