package com.hanqingyang.concurrent.chapter10;

/**
 * @ClassName ThreadLocalSimpleTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/5  8:43
 * @Version 1.0
 **/
public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "hanqingyang";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        //threadLocal.set("han");
        Thread.sleep(1000);
        System.out.println(threadLocal.get());
    }

}
