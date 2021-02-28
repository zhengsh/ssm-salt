package cn.edu.cqvie.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {

    private AtomicInteger atomicInteger = new AtomicInteger();
    private CountDownLatch downLatch;

    private AtomicIntegerTest(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(400);
        AtomicIntegerTest test1 = new AtomicIntegerTest(downLatch);
        AtomicIntegerTest test2 = new AtomicIntegerTest(downLatch);
        for (int i = 0; i < 200; i++) {
            new Thread(test1).start();
            new Thread(test2).start();
        }
        downLatch.await();
        System.out.println(test1.atomicInteger.intValue());
        System.out.println(test2.atomicInteger.intValue());
    }

    @Override
    public void run() {
        atomicInteger.incrementAndGet();
        this.downLatch.countDown();
    }
}
