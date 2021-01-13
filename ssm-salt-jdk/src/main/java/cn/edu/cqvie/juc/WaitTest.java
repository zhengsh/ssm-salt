package cn.edu.cqvie.juc;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    static Object object = new Object();

    static class T1 extends Thread {
        private String name;

        public T1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "开始执行");
                synchronized (object) {
                    TimeUnit.SECONDS.sleep(5);
                    object.wait(1000);
                    System.out.println(name + "被唤醒");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class T2 extends Thread {
        private String name;

        public T2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "开始执行");
                synchronized (object) {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(name + "执行完毕，准备唤醒其它线程");
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        T1 t1 = new T1("线程1");
        T2 t2 = new T2("线程2");
        t1.start();
        t2.start();

    }
}
