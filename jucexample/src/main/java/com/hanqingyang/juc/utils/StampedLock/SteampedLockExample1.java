package com.hanqingyang.juc.utils.StampedLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * @ClassName SteampedLockExample1
 * @Author 韩清阳
 * @Description
 * @Date 2020/1/10  16:42
 * @Version 1.0
 **/
public class SteampedLockExample1 {

    private static final StampedLock lock = new StampedLock();

    private static List<Long> DATA  = new ArrayList<>();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable readTask = () ->{
          for (;;){
              read();;
          }
        };

        Runnable writeTask = ()->{
          for (;;){
              write();
          }
        };

        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(writeTask);

    }

    public static void read(){

        long stamp = lock.tryOptimisticRead();
        if(lock.validate(stamp)){
            try{
                lock.readLock();
                Optional.of(
                        DATA.stream().map(String::valueOf).collect(Collectors.joining("#","R-",""))
                ).ifPresent(System.out::println);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlockRead(stamp);
            }
        }

       /* long stamped = -1;
        try{
            stamped = lock.readLock();
            Optional.of(
                    DATA.stream().map(String::valueOf).collect(Collectors.joining("#","R-",""))
            ).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlockWrite(stamped);
        }*/
    }

    public static void write(){
        long stamped = -1;
        try{
            stamped = lock.writeLock();
            DATA.add(System.currentTimeMillis());
            Optional.of("W => ").ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlockWrite(stamped);
        }
    }
}
