package com.hanqingyang.juc.semaphore;

import java.util.concurrent.Semaphore;

/*
*
 * @Author 韩清阳
 * @Description  
 * @Date  2019/12/30  19:00
 * @Param 
 * @return 
 **/
public class SemaphoreExample1 {

    public static void main(String[] args) {

    }

    static class SemaphoreLock{
        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }
        public void unLock(){
            semaphore.release();
        }
    }
}
