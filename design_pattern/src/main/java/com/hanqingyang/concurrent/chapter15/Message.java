package com.hanqingyang.concurrent.chapter15;

/**
 * @ClassName Message
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/15  9:03
 * @Version 1.0
 **/
public class Message {

    private final String value;


    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
