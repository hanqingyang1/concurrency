package com.hanqingyang.concurrent.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/10  17:19
 * @Version 1.0
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState(){
        return this.state;
    }
    public void setState(int state){
        if(state == this.state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attch(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){
        observers.stream().forEach(Observer::update);
    }
}
