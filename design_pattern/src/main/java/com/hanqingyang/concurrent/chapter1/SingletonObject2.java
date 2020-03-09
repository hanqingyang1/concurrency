package com.hanqingyang.concurrent.chapter1;

/**
 * @ClassName SingletonObject2
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/19  19:14
 * @Version 1.0
 **/
public class SingletonObject2 {

    private static SingletonObject2 instance = new SingletonObject2();
    private SingletonObject2(){

    }
    public  static SingletonObject2 getInstance(){
        if(instance == null){
            instance = new SingletonObject2();
        }
        return instance;
    }
}
