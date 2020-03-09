package com.hanqingyang.concurrent.chapter4;

import java.util.Arrays;

/**
 * @ClassName ThreadLifeCycleClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  9:56
 * @Version 1.0
 **/
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
    }
}
