package com.hanqingyang.concurrent.chapter16;

/**
 * @ClassName ConterTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/19  8:53
 * @Version 1.0
 **/
public class ConterTest {
    public static void main(String[] args) {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterIncrement.close();
    }
}
