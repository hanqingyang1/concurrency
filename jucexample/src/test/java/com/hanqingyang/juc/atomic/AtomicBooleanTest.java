package com.hanqingyang.juc.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @ClassName AtomicBooleanTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/4  14:24
 * @Version 1.0
 **/
public class AtomicBooleanTest {

    @Test
    public void testCreateWithOutArguments(){
        AtomicBoolean bool = new AtomicBoolean();
        assertFalse(bool.get());
    }
    @Test
    public void testCreateWithOutArguments1(){
        AtomicBoolean bool = new AtomicBoolean(true);
        assertTrue(bool.get());
    }

    @Test
    public void testGetAndSet(){
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean result = bool.getAndSet(false);
        assertTrue(result);
        System.out.println(bool.get());
    }

    @Test
    public void testCompareAndSet(){
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean resulr = bool.compareAndSet(true, false);
        assertTrue(resulr);
        assertFalse(bool.get());
    }
}
