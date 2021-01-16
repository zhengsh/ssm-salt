package cn.edu.cqvie.juc;

import cn.edu.cqvie.dp.notify.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 条件队列
 *
 * @author zhengsh
 */
public class ConditionTest {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void await() {
        try {
            lock.lock();
            System.out.println(" await 时间为: " + System.currentTimeMillis());
            condition.wait();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void signal() {
        try {
            lock.lock();
            System.out.println(" signal 时间为: " + System.currentTimeMillis());
            condition.signal();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static class T extends Thread {

        @Override
        public void run() {
            super.run();
            await();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        Thread.sleep(3000);

        signal();
    }
}
