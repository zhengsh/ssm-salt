package com.test;

import org.openjdk.jol.info.ClassLayout;

public class LockTest {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
            object.hashCode();
        }
        object.toString();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
