package com.hanqingyang.concurrent.chapter8;

/**
 * @ClassName FutureTask
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  15:16
 * @Version 1.0
 **/
public interface FutureTask<T> {
    T call();
}
