package com.hanqingyang.concurrent.chapter4;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.util.AuthResources_de;

import java.util.List;

/**
 * @ClassName ThreadLifeCycleObserver
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  9:33
 * @Version 1.0
 **/
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object  LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if(ids == null || ids.isEmpty()){
            return;
        }
        ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try{
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println(" query for the id "+ id);
                    Thread.sleep(1000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        },id).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized(LOCK){
            System.out.println("the runnable "+ event.getThread().getName()+"   data changed and state is "+ event.getState());
            if(event.getCause() != null){
                System.out.println("the runnable "+ event.getThread().getName()+"  process failed .");
                event.getCause().printStackTrace();
            }
        }
    }
}
