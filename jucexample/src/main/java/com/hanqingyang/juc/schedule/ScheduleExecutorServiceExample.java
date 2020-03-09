package com.hanqingyang.juc.schedule;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.*;

/**
 * @ClassName ScheduleExecutorServiceExample
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/15  10:02
 * @Version 1.0
 **/
public class ScheduleExecutorServiceExample {

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

        /*ScheduledFuture<?> future = scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("i will be invoke");
        }, 2, TimeUnit.SECONDS);

        System.out.println(future.cancel(true));*/

        scheduledThreadPoolExecutor.scheduleAtFixedRate(()-> System.out.println("i will invoke" + System.currentTimeMillis()),1,2,TimeUnit.SECONDS);


    }


}
