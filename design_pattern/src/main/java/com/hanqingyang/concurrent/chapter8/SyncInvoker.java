package com.hanqingyang.concurrent.chapter8;

/**
 * @ClassName SyncInvoker
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  15:46
 * @Version 1.0
 **/
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> submit = futureService.submit(() -> {
        try {
                Thread.sleep(10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINSH";
        },System.out::println);

        System.out.println("----------------------------");
        System.out.println("do other ");
        Thread.sleep(1000);
        System.out.println("==============");
//        System.out.println(submit.get());

    }
}
