package com.hanqingyang.juc.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName AtomicIntegerArrayTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/4  17:03
 * @Version 1.0
 **/
public class AtomicIntegerArrayTest {

    @Test
    public void testCreateAtomicIntegerArray(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(10,array.length());
    }
}
