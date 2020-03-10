package com.hanqingyang.juc.blocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExampleTest {


    private ArrayBlockingQueueExample example;

    @Before
    public void setUp(){
        example = new ArrayBlockingQueueExample();
    }
    @After
    public  void tearDown(){
        example = null;
    }


    @Test
    public void testAddMethod(){
        ArrayBlockingQueue queue = example.create(5);
//        queue.add();
    }

}