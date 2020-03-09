package com.hanqingyang.concurrency.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName CaptureService
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/17  12:32
 * @Version 1.0
 **/
public class CaptureService {
    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10").stream()
                .map(CaptureService::createCapterThread)
                .forEach(t ->{
                    t.start();
                    worker.add(t);
                });
        worker.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("join 结束").ifPresent(System.out::println);
    }


    public static Thread createCapterThread(String name){
        return new Thread(() ->{

        },name);
    }
}
