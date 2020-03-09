package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName LifeCycleListener
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  9:23
 * @Version 1.0
 **/
public interface LifeCycleListener {
    void onEvent(ObservableRunnable.RunnableEvent event);
}
