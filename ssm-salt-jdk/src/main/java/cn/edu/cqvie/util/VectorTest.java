package cn.edu.cqvie.util;

import java.util.Vector;

public class VectorTest {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                // 获得 vector 的大小
                for (int i = 0; i < vector.size(); i++) {
                    // 当前线程让出 cpu, 使例子中的错误更加快出现
                    Thread.yield();

                    // 移除第 i 个数据
                    // 不是线程安全的，没有全局锁会报错：
                    // java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 10
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                // 获得 vector 的大小
                for (int i = 0; i < vector.size(); i++) {
                    // 当前线程让出 cpu, 使例子中的错误更加快出现
                    Thread.yield();

                    // 移除第 i 个数据
                    System.out.println(Thread.currentThread().getName() + ":" + vector.get(i));
                }
            });

            thread1.start();
            thread2.start();

            //避免线程过多
            while (Thread.activeCount() > 20);
        }
    }
}
