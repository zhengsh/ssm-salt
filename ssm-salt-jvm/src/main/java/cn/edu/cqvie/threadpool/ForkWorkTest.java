package cn.edu.cqvie.threadpool;

import java.util.concurrent.*;

public class ForkWorkTest {

    public static void main(String[] args) throws
            ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 异步阻塞
        Future<?> submit = executor.submit(() -> {
            System.out.println("this worker start~");

            try {
                // 异步阻塞
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        System.out.println(submit.get(3, TimeUnit.SECONDS));
        executor.shutdown();

    }
}
