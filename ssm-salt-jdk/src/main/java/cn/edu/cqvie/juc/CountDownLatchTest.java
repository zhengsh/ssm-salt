package cn.edu.cqvie.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 减1
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + " count = " + countDownLatch.getCount());
                        // 阻塞 count = 0
                        countDownLatch.await();
                        // 占用
                        System.out.println(Thread.currentThread().getName() + ": 开始买票");

                        // 模拟买票流程
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + ": 买票成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            }).start();
        }

    }
}
