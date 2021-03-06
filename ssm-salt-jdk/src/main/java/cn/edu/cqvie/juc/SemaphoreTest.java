package cn.edu.cqvie.juc;

import java.util.concurrent.Semaphore;

/**
 * 信号量（在共享锁中使用）
 * <p>
 * 场景：模拟售票的场景
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        //semaphore.
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        // 占用
                        System.out.println(Thread.currentThread().getName() + ": 开始买票");

                        // 模拟买票流程
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + ": 买票成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }).start();
        }
    }
}