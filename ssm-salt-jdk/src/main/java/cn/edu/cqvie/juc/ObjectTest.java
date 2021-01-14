package cn.edu.cqvie.juc;

import org.openjdk.jol.info.ClassLayout;

public class ObjectTest {

    public static void main(String[] args) {
        Object obj = new Object();
        String classInfo = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(classInfo);

        synchronized (obj) {
            classInfo = ClassLayout.parseInstance(obj).toPrintable();
            System.out.println(classInfo);
        }
    }
}
