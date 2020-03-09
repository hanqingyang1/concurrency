package com.hanqingyang.concurrent.chapter1;

/**
 * @ClassName SingletonObject3
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/19  19:24
 * @Version 1.0
 **/
public class SingletonObject3 {

    private static SingletonObject3 instance;
    private SingletonObject3(){

    }
    public static SingletonObject3 getInstance(){
        if(null == instance){
            synchronized(SingletonObject3.class){
                if(null == instance){
                    instance = new SingletonObject3();
                }
            }
        }
        return instance;
    }
}
