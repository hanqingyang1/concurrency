package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName OctalObserver
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  8:57
 * @Version 1.0
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        super(subject);
    }
    @Override
    public void update() {
        System.out.println("Octal String " + Integer.toOctalString(subject.getState()));
    }
}
