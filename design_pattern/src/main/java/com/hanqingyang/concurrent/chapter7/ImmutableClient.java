package com.hanqingyang.concurrent.chapter7;

import java.util.stream.IntStream;

/**
 * @ClassName ImmutableClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  14:36
 * @Version 1.0
 **/
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("fdslfj", "qingdao");
        IntStream.range(0,5).forEach(i ->{
            new UsePersonThread(person).start();
        });
    }
}
