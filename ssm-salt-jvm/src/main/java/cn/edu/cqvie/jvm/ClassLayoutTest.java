package cn.edu.cqvie.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ClassLayoutTest {

    public static void main(String[] args) {
        ClassLayout layout1 = ClassLayout.parseInstance(new Object());
        System.out.println(layout1.toPrintable());

        System.out.println();
        ClassLayout layout2 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout2.toPrintable());

        System.out.println();
        ClassLayout layout3 = ClassLayout.parseInstance(new A());
        System.out.println(layout3.toPrintable());
    }

    //-XX:+UseCompressedOops          默认开启的压缩所有指针
    //-XX:+UseCompressedClassPointers 默认开启的只压缩对象头里的类型指针 Klass Pointer
    //Oops: Ordinary Object Pointers
    public static class A {
                        //8B  mark word
                        //4B Klass Pointer 如果关闭 -XX:-UseCompressedClassPointers 或者 -XX:-UseCompressedOops, 则占 8个字节
        int id;         //4B
        String name;    //4B 如果关闭 -XX:-UseCompressedOops, 则占 8个字节
        byte b;         //1B
        Object o;       //4B 如果关闭 -XX:-UseCompressedOops, 则占 8个字节

    }
}
