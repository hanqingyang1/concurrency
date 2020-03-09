package com.hanqingyang.jucAtomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicIntegerTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/3  8:51
 * @Version 1.0
 **/
public class AtomicIntegerTest {


    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(12);
        boolean flag = integer.compareAndSet(12, 20);
        System.out.println(integer.get());
        System.out.println(flag);
    }
}
