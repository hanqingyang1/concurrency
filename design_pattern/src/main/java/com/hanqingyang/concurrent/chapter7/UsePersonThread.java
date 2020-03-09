package com.hanqingyang.concurrent.chapter7;

/**
 * @ClassName UsePersonThread
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  14:31
 * @Version 1.0
 **/
public class UsePersonThread extends Thread {

    private Person person;

    public UsePersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + " person "+person.toString());
        }
    }
}
