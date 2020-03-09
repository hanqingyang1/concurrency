package com.hanqingyang.concurrent.chapter5;

/**
 * @ClassName User
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/25  10:48
 * @Version 1.0
 **/
public class User extends Thread {
    private final String myName;
    private final String myAddress;
    private final Gate gate;

    public User(String myName,String myAddress,Gate gate){
        this.myAddress = myAddress;
        this.myName = myName;
        this.gate = gate;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(myName + "BEGIN");
            gate.pass(myName,myAddress);
        }
    }
}
