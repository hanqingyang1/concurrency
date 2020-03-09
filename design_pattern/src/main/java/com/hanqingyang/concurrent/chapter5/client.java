package com.hanqingyang.concurrent.chapter5;

/**
 * @ClassName client
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/25  10:58
 * @Version 1.0
 **/
public class client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("Shanglao", "Shanghai", gate);
        User  gz = new User("Guanglao", "Guangzhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }
}
