package com.hanqingyang.juc.utils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName CountDownLatchExample1
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/10  16:24
 * @Version 1.0
 **/
public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
            //1
        int[] data = query();
        //2
        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnable(data,i, countDownLatch));
        }
        //3
//        executor.awaitTermination(1,TimeUnit.HOURS);
        countDownLatch.await();
        System.out.println("all of work finish done ");
        executor.shutdown();

    }

    static class SimpleRunnable implements Runnable{
        private final int[] data;
        private final int index;
        private final CountDownLatch countDownLatch;

        SimpleRunnable(int[] data, int index, CountDownLatch countDownLatch) {
            this.data = data;
            this.index = index;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = data[index];
            if(value%2 == 0){
                data[index] = value * 2;
            }else {
                data[index] = value * 10;
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+ "finished");
        }
    }

    private static int[] query(){
        return  new int[]{0,1,2,3,4,5,6,7,8,9};
    }
}
