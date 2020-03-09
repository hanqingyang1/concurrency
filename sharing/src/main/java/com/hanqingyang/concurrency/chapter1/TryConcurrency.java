package com.hanqingyang.concurrency.chapter1;

/**
 * @ClassName TryConcurrency
 * @Author 韩清阳
 * @Description //
 * @Date 2019/9/5  18:11
 * @Version 1.0
 **/
public class TryConcurrency {
    public static void main(String[] args) {

        new Thread("Thread1") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("task 1 = " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                for (int j = 0; j < 100 ; j++) {
                    System.out.println("task 2 = "+j);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

     /*   Thread thread = new Thread("Cust-thread"){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("task 1 = "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            }
        };
        thread.start();
        for (int j = 0; j < 1000 ; j++) {
            System.out.println("task 2 = "+j);

        }
*/
      /*  try{
            Thread.sleep(1000*300L);
            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
