package com.hanqingyang.concurrent.chapter1;

/**
 * @ClassName SingletonObject1
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/19  19:09
 * @Version 1.0
 **/
public class SingletonObject1 {

    private static final  SingletonObject1 instance = new SingletonObject1();
    private SingletonObject1(){

    }
    public static SingletonObject1 getInstance(){
        return instance;
    }
}
