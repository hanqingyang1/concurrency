package com.hanqingyang.jucAtomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CompareAndSetLock
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/4  8:47
 * @Version 1.0
 **/
public class CompareAndSetLock {
    private final AtomicInteger integer = new AtomicInteger(0);

    private Thread lockedThread;

    public void tryLock() throws RuntimeException {
        boolean success = integer.compareAndSet(0, 1);
        if (!success) {
            throw new RuntimeException();
        } else {
            lockedThread = Thread.currentThread();
        }
    }

    public void unLock() {
        if (0 == integer.get()) {
            return;
        }
        if (lockedThread == Thread.currentThread())
            integer.compareAndSet(1, 0);
    }

}
