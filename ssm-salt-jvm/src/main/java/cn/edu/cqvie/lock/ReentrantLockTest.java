package cn.edu.cqvie.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(test::serviceMethod);
        }
    }

    private void serviceMethod() {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    private static void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
