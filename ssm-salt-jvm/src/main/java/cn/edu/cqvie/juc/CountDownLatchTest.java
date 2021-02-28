package cn.edu.cqvie.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        CountDownLatch downLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("任务 "+ taskId +", 开始执行");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("任务 "+ taskId +", 结束执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    downLatch.countDown();
                }
            }).start();
        }
        downLatch.await();
        System.out.println("任务执行完毕：cost: " + (System.currentTimeMillis() - now) + "ms");
    }
}
