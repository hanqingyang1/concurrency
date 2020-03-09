package com.hanqingyang.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * @ClassName ProduceConsumerVersion2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/11  17:26
 * @Version 1.0
 **/
public class ProduceConsumerVersion2 {

    private int i = 1;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("p -> " + i);
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            if (isProduce) {
                System.out.println("c -> " + i);
                LOCK.notify();
                isProduce = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 produceConsumerVersion2 = new ProduceConsumerVersion2();
        Stream.of("p1", "p2").forEach(n ->
                new Thread("p") {
                    @Override
                    public void run() {
                        while (true) {
                            produceConsumerVersion2.produce();
                        }
                    }
                }.start()
        );
        Stream.of("c1","c2").forEach(n ->
                new Thread("c") {
                    @Override
                    public void run() {
                        while (true) {
                            produceConsumerVersion2.consumer();
                        }
                    }
                }.start()
        );
    }


}
