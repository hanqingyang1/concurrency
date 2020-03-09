package com.hanqingyang.concurrency.chapter9;

/**
 * @ClassName ProduceConsumerVersion1
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/11  16:46
 * @Version 1.0
 **/
public class ProduceConsumerVersion1 {

    private final Object LOCK = new Object();

    private int i = 1;

    public void produce(){
        synchronized(LOCK){
            while (true) {
                if(i > 20 ) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("p -> " + i++);
                }else {

                    notifyAll();

                }
            }
        }
    }

    public void consumer(){
        synchronized (LOCK){
            while (i <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("c -> " + i--);
                notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();

        new Thread("p"){
            @Override
            public void run() {
                while(true){
                    produceConsumerVersion1.produce();
                }
            }
        }.start();

        new Thread("c"){
            @Override
            public void run() {
                while(true){
                    produceConsumerVersion1.consumer();
                }
            }
        }.start();
    }
}
