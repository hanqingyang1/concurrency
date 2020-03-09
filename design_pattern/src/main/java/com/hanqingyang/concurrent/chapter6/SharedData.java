package com.hanqingyang.concurrent.chapter6;

/**
 * @ClassName SharedData
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/29  8:44
 * @Version 1.0
 **/
public class SharedData {

    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();
    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            this.buffer[i] = '*';
        }
    }

    public char[] read(){
        try {
            lock.readLock();
            return doread();
        }finally {
            lock.readUnLock();
        }
    }

    public void write(char c){
        try{
            lock.writeLock();
             this.dowrite(c);
        }finally {
            lock.writeUnLock();
        }
    }

    private void dowrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
        slowy(10);
    }

    private char[] doread() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];
        }
        slowy(50);
        return newBuf;
    }

    private void slowy(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
