package cn.edu.cqvie.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPool =
                new ScheduledThreadPoolExecutor(2);

//        scheduledThreadPool.schedule(() -> {
//            System.out.println("延迟三秒执行");
//        }, 3, TimeUnit.SECONDS);


        // 延迟队列需要任务异常的处理，不然会丢任务
        scheduledThreadPool.scheduleAtFixedRate(
                () -> {
                    System.out.println("task over ...");
                }, 1000, 2000, TimeUnit.MILLISECONDS);

//        scheduledThreadPool.shutdown();
//        while (true) {
//            if (scheduledThreadPool.isTerminated()) {
//                break;
//            }
//            Thread.sleep(100);
//        }
    }
}
