package cn.edu.cqvie.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    int i = 0;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("pool-test-" + i++);
                        return thread;
                    }
                },
                // CallerRunsPolicy 如果当前线程池没有关闭会调用当前提交任务的线程参与执行
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String name = Thread.currentThread().getName();
                    if ("main".equals(name)) {
                        // CallerRunsPolicy 策略 提交任务线程参与执行
                        System.out.println("this is a idea debug line");
                        throw  new RuntimeException("test runtime exception");
                    }
                    System.out.println(name + ": " + this.toString());
                }
            });
        }
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(100);
        }
    }
}
