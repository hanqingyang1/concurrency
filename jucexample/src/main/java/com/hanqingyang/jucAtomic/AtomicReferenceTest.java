package com.hanqingyang.jucAtomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceTest
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/12/4  15:09
 * @Version 1.0
 **/
public class AtomicReferenceTest {
    public static void main(String[] args) {
        Simple han = new Simple("han", 10);
        AtomicReference<Simple> reference = new AtomicReference<>(han);
        System.out.println(reference.get());
        boolean result = reference.compareAndSet(han, new Simple("hfdhk", 14));
        System.out.println(result);
    }

    static class Simple{
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
