package com.hanqingyang.concurrent.chapter17;

/**
 * @ClassName Request
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/20  8:41
 * @Version 1.0
 **/
public class Request {

    private final String name;

    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() +"  execute "+this);
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
