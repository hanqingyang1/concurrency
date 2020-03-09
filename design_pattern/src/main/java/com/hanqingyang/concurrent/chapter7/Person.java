package com.hanqingyang.concurrent.chapter7;

/**
 * @ClassName Person
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/10/30  14:26
 * @Version 1.0
 **/
public class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
