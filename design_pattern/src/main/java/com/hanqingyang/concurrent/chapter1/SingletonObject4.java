package com.hanqingyang.concurrent.chapter1;

/**
 * @ClassName SingletonObject4
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/9/19  19:32
 * @Version 1.0
 **/
public class SingletonObject4 {
    private static volatile SingletonObject4 instance;
    private SingletonObject4(){

    }
    public static SingletonObject4 getInstance(){
        if(null == instance){
            synchronized(SingletonObject4.class){
                if(null == instance)
                instance = new SingletonObject4();
            }
        }
        return instance;
    }
}
