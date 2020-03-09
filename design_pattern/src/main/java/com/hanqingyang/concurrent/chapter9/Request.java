package com.hanqingyang.concurrent.chapter9;

/**
 * @ClassName Request
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  16:52
 * @Version 1.0
 **/
public class Request {

    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
