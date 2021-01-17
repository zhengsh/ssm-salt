package cn.edu.cqvie.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();

    static class T extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread() + "开始尝试获取锁");
                if (lock.tryLock(10, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread() + "成功获取锁");
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread() + "开始释放锁");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        t1.start();
        t2.start();
        t3.start();
    }
}
