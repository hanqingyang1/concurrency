package com.hanqingyang.juc.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName FaileAtomicIntegerFieldUpdaterTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/5  8:59
 * @Version 1.0
 **/
public class FaileAtomicIntegerFieldUpdaterTest {


    /*
    *
     * @Author 韩清阳
     * @Description 不能访问TestMe的私有变量
     * @Date  2019/12/5  9:06
     * @Param []
     * @return void
     **/
    @Test(expected = RuntimeException.class)
    public void testPrivateFieldAccessError(){
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class,"i");
        TestMe testMe = new TestMe();
        updater.compareAndSet(testMe,0,1);
    }

    /*
    *
     * @Author 韩清阳
     * @Description  传入对象为null    报 java.lang.ClassCastException
     * @Date  2019/12/5  9:12
     * @Param []
     * @return void
     **/
    @Test
    public void testObjectIsNull(){
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class,"i");
        TestMe testMe = new TestMe();
        updater.compareAndSet(null,0,1);
    }
}
