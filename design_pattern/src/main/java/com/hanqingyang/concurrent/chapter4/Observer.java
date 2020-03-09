package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName Observer
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/10  17:21
 * @Version 1.0
 **/
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attch(this);
    }

    public abstract void update();
}
