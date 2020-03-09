package com.hanqingyang.concurrent.chapter6;

/**
 * @ClassName ReadWriteLock
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/25  11:17
 * @Version 1.0
 **/
public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;

    public synchronized void readLock(){
        this.waitingReaders++;
        try {
            while (writingWriters > 0){
                this.wait();
            }
            this.readingReaders++;
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            this.waitingReaders--;
        }
    }

    public synchronized void readUnLock(){
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock(){
        this.waitingWriters++;
        try {
            while (this.readingReaders > 0 || this.waitingWriters >0){
                this.wait();
            }
            this.writingWriters++;
        }catch (Exception e){

        }finally{
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnLock(){
        this.writingWriters--;
        this.notifyAll();
    }
}
