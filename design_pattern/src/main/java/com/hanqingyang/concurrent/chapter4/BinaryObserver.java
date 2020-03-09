package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName BinaryObserver
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/10  17:33
 * @Version 1.0
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String " + Integer.toBinaryString(subject.getState()));
    }
}
