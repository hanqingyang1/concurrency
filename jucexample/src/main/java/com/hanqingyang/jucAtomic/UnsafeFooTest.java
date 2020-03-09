package com.hanqingyang.jucAtomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnsafeFooTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/10  8:48
 * @Version 1.0
 **/
public class UnsafeFooTest {

    public static void main(String[] args) {

    }


    static class Simple{
        private long l = 0;

        public Simple(){
            this.l = 1;
        }
        public long get(){
            return this.l;
        }
    }

    private static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
}
