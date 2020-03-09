package com.hanqingyang.concurrent.chapter5;

/**
 * @ClassName Gate
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/25  10:38
 * @Version 1.0
 **/
public class Gate {
    private int counter = 0;
    private String name = "NoBody";
    private String address = "NoWhere";

    public void pass(String name ,String address){
        this.name = name;
        this.address = address;
        counter ++;
        verify();
    }

    private void verify() {
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("*********Broker*******" + toString());
        }
    }

    public String toString(){
        return "No "+counter+" : name "+name+"  address "+address;
    }
}
