package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName ObserverClient
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  9:01
 * @Version 1.0
 **/
public class ObserverClient {

    public static void main(String[] args) {
         Subject subject =new Subject();
         new BinaryObserver(subject);
         new OctalObserver(subject);
        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(15);
    }
}
