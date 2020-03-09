package com.hanqingyang.concurrent.chapter4;

/**
 * @ClassName ObsercableRunnable
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/11  9:13
 * @Version 1.0
 **/
public abstract class ObservableRunnable implements Runnable {

    protected final LifeCycleListener listener;

    public ObservableRunnable(final LifeCycleListener listener){
        this.listener = listener;
    }

    public void notifyChange(final RunnableEvent event){
        listener.onEvent(event);

    }

    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    public static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }

}