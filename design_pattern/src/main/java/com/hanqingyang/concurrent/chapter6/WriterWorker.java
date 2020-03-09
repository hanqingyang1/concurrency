package com.hanqingyang.concurrent.chapter6;

import java.util.Random;

/**
 * @ClassName WriterWorker
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  11:06
 * @Version 1.0
 **/
public class WriterWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filter;

    private int index = 0;

    public WriterWorker(SharedData data,String filter){
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try{
            while(true){
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c = filter.charAt(index);
        index++;
        if(index > filter.length()){
            this.index = 0;
        }
        return c;
    }
}
