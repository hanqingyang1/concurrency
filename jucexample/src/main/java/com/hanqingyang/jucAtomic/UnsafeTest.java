package com.hanqingyang.jucAtomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnsafeTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/9  16:30
 * @Version 1.0
 **/
public class UnsafeTest {

    public static void main(String[] args) {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
        System.out.println(getUnsafe());
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
