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
        for (int i = 0; i < 3; i++) {
            executorService.submit(test::serviceMethod);
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }

        }
    }

    private void serviceMethod() {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    private static void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
