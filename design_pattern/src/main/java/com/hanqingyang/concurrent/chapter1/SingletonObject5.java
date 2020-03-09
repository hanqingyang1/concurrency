package com.hanqingyang.concurrent.chapter1;

/**
 * @ClassName SingletonObject5
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/19  19:38
 * @Version 1.0
 **/
public class SingletonObject5 {

    private SingletonObject5(){}

    private static class InstanceHolder{
        private static final SingletonObject5 instance = new SingletonObject5();
    }
    public static SingletonObject5 getInstance(){
        return InstanceHolder.instance;
    }


}
